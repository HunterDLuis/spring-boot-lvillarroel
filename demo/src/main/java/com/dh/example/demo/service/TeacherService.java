package com.dh.example.demo.service;

import com.dh.example.demo.domain.Teacher;
import com.dh.example.demo.repository.TeacherRepository;
import com.dh.example.demo.web.TeacherController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lucho on 03/06/2017.
 */
@Service
public class TeacherService {
    //injeccion de dependencia
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        //TODO use repository
        /*List<Teacher> res = new ArrayList<>();

        res.add(new Teacher("lv","Luis",1234,"Informatico"));
        res.add(new Teacher("lv","Gabo",1234,"Informatico"));
        res.add(new Teacher("lv","Susi",1234,"Informatico"));
        res.add(new Teacher("lv","Andi",1234,"Informatico"));
        */
        List<Teacher> res = teacherRepository.findAll();
        return res;
    }

    public Teacher getTeachers(String id){
        //TODO use repository
        return teacherRepository.findOne(id);

    }

    public Teacher updateTeacher(Teacher teacher){
        return teacher;
    }

    public void delete(String id){
        teacherRepository.delete(id);
    }

    public void addTeacher(TeacherController.TeacherRequestDTO newTeacheDTO){
        //TODO add into Database
        Teacher newTeacher = new Teacher();
        newTeacher.setCi(newTeacheDTO.getCi());
        newTeacher.setName(newTeacheDTO.getName());
        newTeacher.setPrefession(newTeacheDTO.getPrefession());
        teacherRepository.save(newTeacher);
        // find one Teacher
        //teacherRepository.findOne(newTeache.getId());
        // delete teacher
        //teacherRepository.delete(newTeache);

        System.out.println("the Name of teacher is --->" + newTeacher.getName());
    }
}
