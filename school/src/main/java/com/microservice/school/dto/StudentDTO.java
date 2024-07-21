package com.microservice.school.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Long schoolId;
}
