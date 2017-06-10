package com.dh.example.demo.repository;

import com.dh.example.demo.domain.Subscription;
import com.dh.example.demo.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by Lucho on 03/06/2017.
 * Esto es para acceder a la base de datos con repository
 */
public interface TeacherRepository extends MongoRepository<Teacher,String>{
    @Query("{name: ?0, ci:?0 }")
    Teacher getTeacherById(String name, String ci);

}
