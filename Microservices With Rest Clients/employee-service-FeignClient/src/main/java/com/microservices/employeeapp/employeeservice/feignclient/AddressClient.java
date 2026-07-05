package com.microservices.employeeapp.employeeservice.feignclient;


import com.microservices.employeeapp.employeeservice.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


// http://localhost:8081/address-app/api/address/1
@FeignClient(
        name = "address-service",
        url = "http://localhost:8081/address-app/api"
)
public interface AddressClient
{

    @GetMapping("/address/{id}")
    AddressDto getAddressByEmployeeId(@PathVariable("id") int id);

    @GetMapping("/allAddresses")
    Iterable<AddressDto> getAllAddresses();

}
