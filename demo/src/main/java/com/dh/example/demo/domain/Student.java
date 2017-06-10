package com.dh.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Lucho on 10/06/2017.
 */
@Document
public class Student {
    @Id
    private String id;
    private String name;
    private Long ci;
    private Long codeSis;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCi() {
        return ci;
    }

    public void setCi(Long ci) {
        this.ci = ci;
    }

    public Long getCodeSis() {
        return codeSis;
    }

    public void setCodeSis(Long codeSis) {
        this.codeSis = codeSis;
    }
}
