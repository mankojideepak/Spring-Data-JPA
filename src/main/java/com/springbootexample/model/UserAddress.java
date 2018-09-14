package com.springbootexample.model;


import com.springbootexample.CustomAnnotations.MyArea;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Component
@Entity
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Flat No. cannot be null")
    private Integer flatNo;

    @NotNull
    @MyArea
    private String area;

    @NotNull
    private String city;

    @NotNull
    @Size(max = 10, message = "State Size should not exceed {max} characters")
    private String state;

    private String near;

    public UserAddress(Integer flatNo, String area, String city, String state, String near) {
        this.flatNo = flatNo;
        this.area = area;
        this.city = city;
        this.state = state;
        this.near = near;
    }
}
