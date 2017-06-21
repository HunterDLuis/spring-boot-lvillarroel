package com.dh.demo.web;

import com.dh.demo.domain.Sold;
import com.dh.demo.service.SoldService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Lucho on 18/06/2017.
 */
@RestController
@RequestMapping("/solds")
public class SoldController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(SoldController.class);

    @Autowired
    private SoldService soldService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Sold> getAllSolds(){
        return soldService.getAllSold();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewSold(@RequestBody SoldRequestDTO newSoldDTO){
        soldService.addNewSold(newSoldDTO);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<Sold> getSoldByIds(@PathVariable long id){
        Sold sold = soldService.getSoldById(id);
        ResponseEntity<Sold> response;
        if(sold==null){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity<>(sold,HttpStatus.OK);
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity updateSold(@RequestBody Sold sold){
        logger.info("test---->"+sold.getId());
        System.out.println("the values i");
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeSold(@PathVariable long id){
        soldService.deleteSold(id);
    }

    public static class SoldRequestDTO{
        private Long buyerId;
        private Long sellerId;
        private Date date;

        public Long getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(Long buyerId) {
            this.buyerId = buyerId;
        }

        public Long getSellerId() {
            return sellerId;
        }

        public void setSellerId(Long sellerId) {
            this.sellerId = sellerId;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }
}
