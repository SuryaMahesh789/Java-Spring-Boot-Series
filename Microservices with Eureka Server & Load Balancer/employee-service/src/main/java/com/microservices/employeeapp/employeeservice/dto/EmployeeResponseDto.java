package com.microservices.employeeapp.employeeservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeResponseDto
{

    private int id;
    private String name;
    private String email;
    private String bloodgroup;

}
