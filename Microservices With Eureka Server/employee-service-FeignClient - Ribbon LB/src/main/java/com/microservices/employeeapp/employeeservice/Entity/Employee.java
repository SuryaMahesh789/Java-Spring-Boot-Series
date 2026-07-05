package com.microservices.employeeapp.employeeservice.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


@Entity
@Table(name = "employee")
@Data
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "bloodgroup")
    private String bloodgroup;
}
