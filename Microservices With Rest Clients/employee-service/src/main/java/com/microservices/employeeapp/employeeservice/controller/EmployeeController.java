package com.microservices.employeeapp.employeeservice.controller;

import com.microservices.employeeapp.employeeservice.dto.AddressDto;
import com.microservices.employeeapp.employeeservice.dto.EmployeeAddressResponseDto;
import com.microservices.employeeapp.employeeservice.dto.EmployeeResponseDto;
import com.microservices.employeeapp.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    @Value("${address_service.base_url}")
    private String addressBaseUrl;



    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeDetails(@PathVariable("id") int id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeDetails(id));
    }


    // Using RestTemplate
    @GetMapping("/employeeWithAddress/{id}")
    public ResponseEntity<EmployeeAddressResponseDto> getEmployeeWithAddressDetails(@PathVariable("id") int id)
    {

        EmployeeResponseDto employeeResponseDto = employeeService.getEmployeeDetails(id);

        EmployeeAddressResponseDto employeeAddressResponseDto = new EmployeeAddressResponseDto();
        employeeAddressResponseDto.setEmployee(employeeResponseDto);


//        AddressDto addressDto = restTemplate.getForObject(
//                "http://localhost:8081/address-app/api/address/{id}",
//                AddressDto.class,id
//        );


        AddressDto addressDto = restTemplate.getForObject(
                addressBaseUrl + "/address/{id}",
                AddressDto.class,id
        );
        employeeAddressResponseDto.setAddress(addressDto);

        return ResponseEntity.status(HttpStatus.OK).body(employeeAddressResponseDto);

    }


    // Using WebClient
    @GetMapping("/employeeWithAddressWC/{id}")
    public ResponseEntity<EmployeeAddressResponseDto> getEmployeeWithAddressDetailsWC(@PathVariable("id") int id)
    {

        EmployeeResponseDto employeeResponseDto = employeeService.getEmployeeDetails(id);

        EmployeeAddressResponseDto employeeAddressResponseDto = new EmployeeAddressResponseDto();
        employeeAddressResponseDto.setEmployee(employeeResponseDto);


        AddressDto addressDto = webClient.get().uri("/address/{id}",id).retrieve().bodyToMono(AddressDto.class).block();

        employeeAddressResponseDto.setAddress(addressDto);

        return ResponseEntity.status(HttpStatus.OK).body(employeeAddressResponseDto);

    }



}
