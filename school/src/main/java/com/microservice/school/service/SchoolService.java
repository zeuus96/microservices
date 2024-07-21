package com.microservice.school.service;

import com.microservice.school.domain.School;
import com.microservice.school.dto.SchoolStudentsDTO;
import com.microservice.school.feign.StudentClient;
import com.microservice.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;

    public void saveSchool(School school) {
        repository.save(school);
    }

    public List<School> findAllSchools() {
        return repository.findAll();
    }

    public SchoolStudentsDTO findSchoolsWithStudents(Long schoolId) {
        var school = repository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students = client.findAllStudentsBySchool(schoolId);
        return SchoolStudentsDTO.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}