package com.dh.demo.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Lucho on 18/06/2017.
 */
@Entity
public class Sold {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Buyer buyer;
    @ManyToOne
    private Seller seller;
    private Date date;

    public Sold(){

    }

    public Sold(Buyer buyer, Seller seller, Date date) {
        this.buyer = buyer;
        this.seller = seller;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public Date getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
