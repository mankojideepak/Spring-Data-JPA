package com.springbootexample.model;

import javax.persistence.*;
import java.util.Set;

@SuppressWarnings("unused")
@Entity
public class Product {
    private int id;
    private String name;
    private Set<Manufacturer> manufacturerSet;

    public Product() {

    }

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, Set<Manufacturer> manufacturerSet) {
        this.name = name;
        this.manufacturerSet = manufacturerSet;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Product_Manufacturer", joinColumns = @JoinColumn(name = "Product_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Manufacturer_id", referencedColumnName = "id"))
    public Set<Manufacturer> getManufacturers() {
        return manufacturerSet;
    }

    public void setManufacturers(Set<Manufacturer> manufacturerSet) {
        this.manufacturerSet = manufacturerSet;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Product [id=%d, name='%s']%n",
                id, name);
        if (manufacturerSet != null) {
            for (Manufacturer Manufacturer : manufacturerSet) {
                result += String.format(
                        "Manufacturer[id=%d, name='%s']%n",
                        Manufacturer.getId(), Manufacturer.getName());
            }
        }

        return result;
    }
}
