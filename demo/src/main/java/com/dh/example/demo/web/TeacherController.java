package com.dh.example.demo.web;

import com.dh.example.demo.domain.Teacher;
import com.dh.example.demo.service.TeacherService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Lucho on 03/06/2017.
 */
@RestController
@RequestMapping("/teachers")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class TeacherController {
    //spring inicializa teacherService gracias a la inyeccion de dependencia con Autowired
    @Autowired
    TeacherService teacherService;
    //obtener docentes sin id
    @RequestMapping(method = RequestMethod.GET)
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }
    //obtener un docente get con id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> getUser(@PathVariable String userId) {
        Teacher user = teacherService.getTeachers(userId);
        ResponseEntity<Teacher> response;
        if (user == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<>(user, HttpStatus.OK);
        }
        return response;
    }

    //actualizar docente
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTeacher(@RequestBody Teacher teacher,@PathVariable String id){
        Teacher teacherOld = teacherService.getTeachers(id);
        if(teacherOld != null){
            teacherService.updateTeacher(teacher);
        }
    }

    //crea un nuevo docente
    @RequestMapping(method = RequestMethod.POST)
    public void addTeacher(@RequestBody TeacherRequestDTO newTeacher){
        teacherService.addTeacher(newTeacher);
    }
    //eliminar docente
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeTeacher(@PathVariable String id){
        //return teacherService.getAllTeachers();
        teacherService.delete(id);
    }

    public static class TeacherRequestDTO{
        private  String name;
        private long ci;
        private String prefession;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getCi() {
            return ci;
        }

        public void setCi(long ci) {
            this.ci = ci;
        }

        public String getPrefession() {
            return prefession;
        }

        public void setPrefession(String prefession) {
            this.prefession = prefession;
        }
    }
}
