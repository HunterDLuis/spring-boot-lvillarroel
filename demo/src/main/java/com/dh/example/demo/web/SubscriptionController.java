package com.dh.example.demo.web;

import com.dh.example.demo.domain.Student;
import com.dh.example.demo.domain.Subscription;
import com.dh.example.demo.domain.Teacher;
import com.dh.example.demo.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Lucho on 10/06/2017.
 */
@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Subscription> getAllSubscriptions(){
        return subscriptionService.getAllSubscriptions();
    }
    @RequestMapping(method = RequestMethod.POST)
    public void addSubscription(@RequestBody SubscriptionRequestDTO subscriptionDTO){
             subscriptionService.addNewSubscription(subscriptionDTO);
    }

    //DTO
    public static class SubscriptionRequestDTO{
        private String teacherId;
        private String studentId;
        private String roomId;
        private Date subDate;

        public String getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(String teacherId) {
            this.teacherId = teacherId;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public Date getSubDate() {
            return subDate;
        }

        public void setSubDate(Date subDate) {
            this.subDate = subDate;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }
    }
}
