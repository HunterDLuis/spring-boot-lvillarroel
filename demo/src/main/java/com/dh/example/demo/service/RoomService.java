package com.dh.example.demo.service;

import com.dh.example.demo.domain.Room;
import com.dh.example.demo.repository.RoomRepository;
import com.dh.example.demo.web.RoomController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lucho on 10/06/2017.
 */
@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
    public void addNewRoom(RoomController.RoomRequestDTO roomDTO){
        Room newRoom = new Room();
        newRoom.setCode(roomDTO.getCode());
        newRoom.setCapacity(roomDTO.getCapacity());

        roomRepository.save(newRoom);
    }
}
