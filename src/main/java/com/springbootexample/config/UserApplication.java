package com.springbootexample.config;

import com.springbootexample.model.UserAddress;
import com.springbootexample.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SuppressWarnings("unused")
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.springbootexample.*")
@EntityScan(basePackages = "com.springbootexample.*")
@EnableJpaRepositories(basePackages = {"com.springbootexample.*"})
@SpringBootApplication
public class UserApplication implements CommandLineRunner {

    @Autowired
    private UserAddressRepository userAddressRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Override
    public void run(String... args) {
        UserAddress ua = new UserAddress(16846, "Sector-16", "Noida", "Uttar Pradesh", "KiwiTech");
        userAddressRepository.save(ua);
        System.out.println("User Address Inserted Successfully");
    }
}
