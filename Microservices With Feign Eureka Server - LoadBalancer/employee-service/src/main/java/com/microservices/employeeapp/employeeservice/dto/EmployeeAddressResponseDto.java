package com.microservices.employeeapp.employeeservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class EmployeeAddressResponseDto
{

    private EmployeeResponseDto employee;
    private AddressDto address;
}
