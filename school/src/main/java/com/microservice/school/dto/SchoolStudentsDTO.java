package com.microservice.school.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolStudentsDTO {
    private String name;
    private String email;
    List<StudentDTO> students;
}