package com.microservices.employeeapp.employeeservice.service;

import com.microservices.employeeapp.employeeservice.Entity.Employee;
import com.microservices.employeeapp.employeeservice.dto.EmployeeResponseDto;
import com.microservices.employeeapp.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final ModelMapper modelMapper;

    private final EmployeeRepository employeeRepository;


    public EmployeeResponseDto getEmployeeDetails(int id)
    {
        Employee employee = employeeRepository.findById(id);

        EmployeeResponseDto employeeResponseDto = modelMapper.map(employee, EmployeeResponseDto.class);

        return employeeResponseDto;
    }


}
