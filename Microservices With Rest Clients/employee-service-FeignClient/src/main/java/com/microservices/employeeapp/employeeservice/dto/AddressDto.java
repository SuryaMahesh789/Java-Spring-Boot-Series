package com.microservices.employeeapp.employeeservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AddressDto
{
    private int id;
    private String lane_1;
    private String lane_2;
    private String state;
    private String zip;
}