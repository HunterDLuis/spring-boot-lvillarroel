package com.dh.demo.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Lucho on 18/06/2017.
 */
@Entity
public class RegistrySold {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Sold sold;
    @ManyToOne
    private Car car;
    //cantidad vendida
    private Long amount;
    //Monto total
    private Double addAmount;

    private Date dateofsell;

    public RegistrySold(){

    }

    public RegistrySold(Sold sold, Car car, Long amount, Double addAmount, Date dateofsell) {
        this.sold = sold;
        this.car = car;
        this.amount = amount;
        this.addAmount = addAmount;
        this.dateofsell = dateofsell;
    }

    public Long getId() {
        return id;
    }

    public Sold getSold() {
        return sold;
    }

    public Car getCar() {
        return car;
    }

    public Long getAmount() {
        return amount;
    }

    public Double getAddAmount() {
        return addAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSold(Sold sold) {
        this.sold = sold;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setAddAmount(Double addAmount) {
        this.addAmount = addAmount;
    }

    public Date getDateofsell(Date dateofsell) {
        return this.dateofsell;
    }

    public void setDateofsell(Date dateofsell) {
        this.dateofsell = dateofsell;
    }
}
