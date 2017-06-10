package com.dh.example.demo.service;

import com.dh.example.demo.domain.Room;
import com.dh.example.demo.domain.Student;
import com.dh.example.demo.domain.Subscription;
import com.dh.example.demo.domain.Teacher;
import com.dh.example.demo.repository.RoomRepository;
import com.dh.example.demo.repository.StudentRepository;
import com.dh.example.demo.repository.SubscriptionRepository;
import com.dh.example.demo.repository.TeacherRepository;
import com.dh.example.demo.web.SubscriptionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lucho on 10/06/2017.
 */
@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RoomRepository roomRepository;

    public List<Subscription> getAllSubscriptions(){
        return subscriptionRepository.findAll();
    }

    public void addNewSubscription(SubscriptionController.SubscriptionRequestDTO subscriptionDTO){
        Subscription newSubcription = new Subscription();
        Student newStudent = studentRepository.findOne(subscriptionDTO.getStudentId());
        Teacher newTeacher = teacherRepository.findOne(subscriptionDTO.getTeacherId());
        Room newRoom = roomRepository.findOne(subscriptionDTO.getRoomId());

        newSubcription.setStudent(newStudent);
        newSubcription.setTeacher(newTeacher);
        newSubcription.setRoom(newRoom);
        newSubcription.setSubDate(subscriptionDTO.getSubDate());

        subscriptionRepository.save(newSubcription);
    }

}

