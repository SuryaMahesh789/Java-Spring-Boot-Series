package com.microservices.addressapp.addressservice.repository;

import com.microservices.addressapp.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>
{


    @Query(
        nativeQuery = true,
        value = "select ea.id,ea.lane1,ea.lane2,ea.state,ea.zip from address ea join employee e on ea.employee_id = e.id where e.id = :employeeId"
    )
    Address findAddressByEmployeeId(@Param("employeeId") int id);


}
