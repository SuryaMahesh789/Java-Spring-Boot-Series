package com.microservices.employeeapp.employeeservice.controller;

import com.microservices.employeeapp.employeeservice.dto.AddressDto;
import com.microservices.employeeapp.employeeservice.dto.EmployeeAddressResponseDto;
import com.microservices.employeeapp.employeeservice.dto.EmployeeResponseDto;
import com.microservices.employeeapp.employeeservice.feignclient.AddressClient;
import com.microservices.employeeapp.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final RestTemplate restTemplate;


    @Value("${address_service.base_url}")
    private String addressBaseUrl;

    private final AddressClient addressClient;



    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeDetails(@PathVariable("id") int id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeDetails(id));
    }


    // Using Feign Client
    @GetMapping("/employeeWithAddress/{id}")
    public ResponseEntity<EmployeeAddressResponseDto> getEmployeeWithAddressDetails(@PathVariable("id") int id)
    {

        EmployeeResponseDto employeeResponseDto = employeeService.getEmployeeDetails(id);

        EmployeeAddressResponseDto employeeAddressResponseDto = new EmployeeAddressResponseDto();
        employeeAddressResponseDto.setEmployee(employeeResponseDto);


        AddressDto addressDto = addressClient.getAddressByEmployeeId(id);

        employeeAddressResponseDto.setAddress(addressDto);

        return ResponseEntity.status(HttpStatus.OK).body(employeeAddressResponseDto);

    }

    @GetMapping("/employeeAllAddresses")
    public ResponseEntity<Iterable<AddressDto>> getAllAddresses()
    {
        return ResponseEntity.status(HttpStatus.OK).body(addressClient.getAllAddresses());
    }

}
