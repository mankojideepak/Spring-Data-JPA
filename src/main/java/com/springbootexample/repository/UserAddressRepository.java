package com.springbootexample.repository;

import com.springbootexample.model.UserAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserAddressRepository extends CrudRepository<UserAddress, Integer> {

}