package com.springbootexample.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@SuppressWarnings("unused")
@Component
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    @ElementCollection(fetch = EAGER)
    private Set<String> phoneNumbers = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("WeakerAccess")
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    @SuppressWarnings("WeakerAccess")
    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

}
