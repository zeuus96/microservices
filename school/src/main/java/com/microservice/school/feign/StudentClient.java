package com.microservice.school.feign;


import com.microservice.school.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${student.url}")
public interface StudentClient {
    @GetMapping("/school/{schoolid}")
    List<StudentDTO> findAllStudentsBySchool(@PathVariable("schoolid") Long schoolid);
}
