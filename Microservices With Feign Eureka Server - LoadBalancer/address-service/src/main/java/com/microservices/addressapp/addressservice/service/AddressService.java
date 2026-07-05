package com.microservices.addressapp.addressservice.service;

import com.microservices.addressapp.addressservice.dto.AddressResponseDto;
import com.microservices.addressapp.addressservice.entity.Address;
import com.microservices.addressapp.addressservice.repository.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService
{

    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;

    public AddressResponseDto getAddressByEmployeeId(int id)
    {
        Address address = addressRepository.findAddressByEmployeeId(id);

        AddressResponseDto addressResponseDto =  modelMapper.map(address, AddressResponseDto.class);

        return addressResponseDto;
    }

    public List<AddressResponseDto> getAllAddresses()
    {
        return addressRepository.findAll().stream().map(address -> modelMapper.map(address, AddressResponseDto.class)).toList();
    }


}
