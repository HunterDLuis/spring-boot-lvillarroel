package com.dh.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Lucho on 18/06/2017.
 */
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long edad;
    private Long ci;
    private Long num_car_sold;


    public Seller() {
    }

    public Seller(String name, Long edad, Long ci, Long num_car_sold) {
        this.name = name;
        this.edad = edad;
        this.ci = ci;
        this.num_car_sold = num_car_sold;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getEdad() {
        return edad;
    }

    public Long getCi() {
        return ci;
    }

    public Long getNum_car_sold() {
        return num_car_sold;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    public void setCi(Long ci) {
        this.ci = ci;
    }

    public void setNum_car_sold(Long num_car_sold) {
        this.num_car_sold = num_car_sold;
    }
}
