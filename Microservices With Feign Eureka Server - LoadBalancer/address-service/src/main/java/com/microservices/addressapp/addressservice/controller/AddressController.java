package com.microservices.addressapp.addressservice.controller;

import com.microservices.addressapp.addressservice.dto.AddressResponseDto;
import com.microservices.addressapp.addressservice.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AddressController
{

    private final AddressService addressService;

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponseDto> getAddressByEmployeeId(@PathVariable("employeeId") int id)
    {
        System.out.println("Yo Brooo Pablo Eskobarrr : I'm Getting Called By Someoneee");

        AddressResponseDto addressResponseDto = addressService.getAddressByEmployeeId(id);

        return ResponseEntity.status(HttpStatus.OK).body(addressResponseDto);

    }

    @GetMapping("/allAddresses")
    public ResponseEntity<Iterable<AddressResponseDto>> getAllAddresses()
    {
        System.out.println("Inside getAllAddresses");
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAllAddresses());
    }


}
