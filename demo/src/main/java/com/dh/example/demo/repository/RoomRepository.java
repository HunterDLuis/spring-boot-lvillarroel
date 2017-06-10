package com.dh.example.demo.repository;

import com.dh.example.demo.domain.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Lucho on 10/06/2017.
 */
public interface RoomRepository extends MongoRepository<Room,String> {

}
