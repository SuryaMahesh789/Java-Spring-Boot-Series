package com.microservices.employeeapp.employeeservice.openfiegnclients;


import com.microservices.employeeapp.employeeservice.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="address-service",path="/address-app/api")
public interface AddressClient {

    @GetMapping("/address/{id}")
    AddressDto getAddressByEmployeeId(@PathVariable("id") int id);

}
