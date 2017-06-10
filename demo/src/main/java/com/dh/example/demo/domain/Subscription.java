package com.dh.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Lucho on 10/06/2017.
 */
@Document
public class Subscription {
    @Id
    private String id;
    //Referencia a base de datos @DBRef
    @DBRef
    private Teacher teacher;
    @DBRef
    private Student student;
    @DBRef
    private Room room;
    private Date subDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getSubDate() {
        return subDate;
    }


    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }


}
