package com.dh.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * Created by Lucho on 18/06/2017.
 */
@Entity
@Table(name = "Buyers")

public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long ci;
    private String profession;
    private Long cel;

    public Buyer(){

    }

    public Buyer(String name, Long ci, String profession, Long cel) {
        this.name = name;
        this.ci = ci;
        this.profession = profession;
        this.cel = cel;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCi() {
        return ci;
    }

    public String getProfession() {
        return profession;
    }

    public Long getCel() {
        return cel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCi(Long ci) {
        this.ci = ci;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setCel(Long cel) {
        this.cel = cel;
    }
}
