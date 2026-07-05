package com.microservices.addressapp.addressservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Data
@Setter
@Getter
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "lane1")
    private String lane_1;

    @Column(name = "lane2")
    private String lane_2;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;


}
