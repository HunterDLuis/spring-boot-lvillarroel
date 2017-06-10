package com.dh.example.demo.repository;

import com.dh.example.demo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Lucho on 10/06/2017.
 */
public interface StudentRepository extends MongoRepository<Student,String>{
}
