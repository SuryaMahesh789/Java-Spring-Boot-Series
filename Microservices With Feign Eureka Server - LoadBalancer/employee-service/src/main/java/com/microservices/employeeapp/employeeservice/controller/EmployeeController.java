package com.microservices.employeeapp.employeeservice.controller;

import com.microservices.employeeapp.employeeservice.dto.AddressDto;
import com.microservices.employeeapp.employeeservice.dto.EmployeeAddressResponseDto;
import com.microservices.employeeapp.employeeservice.dto.EmployeeResponseDto;
import com.microservices.employeeapp.employeeservice.openfiegnclients.AddressClient;
import com.microservices.employeeapp.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    @Value("${address_service.base_url}")
    private String addressBaseUrl;
    
    private final DiscoveryClient discoveryClient;

    private final LoadBalancerClient loadBalancerClient;

    private final AddressClient addressClient;



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


    // Using RestTemplate and HardCoded URL for Address Service API Calling
    @GetMapping("/employeeWithAddressHardCodedURL/{id}")
    public ResponseEntity<EmployeeAddressResponseDto> getEmployeeWithAddressDetailsWithHardcodedURL(@PathVariable("id") int id)
    {

        EmployeeResponseDto employeeResponseDto = employeeService.getEmployeeDetails(id);

        EmployeeAddressResponseDto employeeAddressResponseDto = new EmployeeAddressResponseDto();
        employeeAddressResponseDto.setEmployee(employeeResponseDto);



        AddressDto addressDto = restTemplate.getForObject(
                "http://localhost:8082/address-app/api/address/{id}",
                AddressDto.class,id
        );
        employeeAddressResponseDto.setAddress(addressDto);

        return ResponseEntity.status(HttpStatus.OK).body(employeeAddressResponseDto);

    }

    // Using RestTemplate and Eureka for Address Service Instance Discovery - Discovery Client
    @GetMapping("/employeeWithEureka/{id}")
    public ResponseEntity<EmployeeAddressResponseDto> getEmployeeWithAddressDetailsWithEurekaLB(@PathVariable("id") int id)
    {

        EmployeeResponseDto employeeResponseDto = employeeService.getEmployeeDetails(id);

        EmployeeAddressResponseDto employeeAddressResponseDto = new EmployeeAddressResponseDto();
        employeeAddressResponseDto.setEmployee(employeeResponseDto);


        // get me the details of Ip and Port number for Address Service

        List<ServiceInstance> instances = discoveryClient.getInstances("address-service");

        ServiceInstance serviceInstance = instances.get(0);

        String uri = serviceInstance.getUri().toString();

        System.out.println("uri >>>>>>>>>>>>>>>>> "+uri );
        AddressDto addressDto = restTemplate.getForObject(
                uri+"/address-app/api/address/{id}",
                AddressDto.class,id
        );
        employeeAddressResponseDto.setAddress(addressDto);

        return ResponseEntity.status(HttpStatus.OK).body(employeeAddressResponseDto);

    }



    // Using Feign Client and Eureka for Address Service Instance Discovery - Load Balancer Client
    @GetMapping("/employeeWithAddressFeignEurekaLB/{id}")
    public ResponseEntity<EmployeeAddressResponseDto> getEmployeeDetailsWithFeignEurekaLB(@PathVariable("id") int id)
    {

        EmployeeResponseDto employeeResponseDto = employeeService.getEmployeeDetails(id);

        EmployeeAddressResponseDto employeeAddressResponseDto = new EmployeeAddressResponseDto();
        employeeAddressResponseDto.setEmployee(employeeResponseDto);


        AddressDto addressDto = addressClient.getAddressByEmployeeId(id);
        employeeAddressResponseDto.setAddress(addressDto);

        return ResponseEntity.status(HttpStatus.OK).body(employeeAddressResponseDto);

    }







}
