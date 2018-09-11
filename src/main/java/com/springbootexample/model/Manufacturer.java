package com.springbootexample.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@SuppressWarnings("unused")
@Component
@Entity
public class Manufacturer {
    private int id;
    private String name;
    private Set<Product> Products;

    public Manufacturer() {

    }

    public Manufacturer(String name) {
        this.name = name;
    }

    public Manufacturer(String name, Set<Product> Products) {
        this.name = name;
        this.Products = Products;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "manufacturers", fetch = FetchType.EAGER)
    public Set<Product> getProducts() {
        return Products;
    }

    public void setProducts(Set<Product> Products) {
        this.Products = Products;
    }

}
