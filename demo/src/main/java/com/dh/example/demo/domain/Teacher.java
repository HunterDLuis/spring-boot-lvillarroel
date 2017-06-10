package com.dh.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Lucho on 03/06/2017.
 */
@Document
public class Teacher {
    @Id
    //esto hace que se ignore la persistencia de una columna
    //@Transient
    private  String id;
    private  String name;
    private long ci;
    private String prefession;

    public Teacher(){

    }

    public Teacher(String id, String name, long ci, String prefession){
        this.id = id;
        this.name = name;
        this.ci = ci;
        this.prefession = prefession;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCi() {
        return ci;
    }

    public String getPrefession() {
        return prefession;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCi(long ci) {
        this.ci = ci;
    }

    public void setPrefession(String prefession) {
        this.prefession = prefession;
    }
}
