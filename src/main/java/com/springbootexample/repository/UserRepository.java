package com.springbootexample.repository;

import com.springbootexample.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select u.email from User u where u.name = ?1")
    public String getEmailByName(String name);

    @Query("select u from User u where u.id = ?1")
    public User printUserbyId(Integer myId);

}