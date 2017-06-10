package com.dh.example.demo.service;

import com.dh.example.demo.domain.Student;
import com.dh.example.demo.repository.StudentRepository;
import com.dh.example.demo.web.StudentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lucho on 10/06/2017.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public void addNewStudent(StudentController.StudentRequestDTO studentDTO){
        Student newStudent = new Student();
        newStudent.setCi(studentDTO.getCi());
        newStudent.setCodeSis(studentDTO.getCodeSis());
        newStudent.setName(studentDTO.getName());

        studentRepository.save(newStudent);
    }
}
