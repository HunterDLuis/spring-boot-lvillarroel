package com.dh.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Lucho on 18/06/2017.
 */
@Entity

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private Long year;
    private String model;
    private String color;
    private String image;

    public Car(){

    }

    public Car(String brand, Long year, String model, String color, String image) {
        this.brand = brand;
        this.year = year;
        this.model = model;
        this.color = color;
        this.image = image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public void setId(String id) {
        this.id = id;
    }*/

    public void setYear(Long year) {
        this.year = year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /*public void setYear(Integer year) {
        this.year = year;
    }*/

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    /*public String getId() {
        return id;
    }*/

    public Long getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    /*public Integer getYear() {
        return year;
    }*/

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getImage() {
        return image;
    }
}
