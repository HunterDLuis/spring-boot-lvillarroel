package com.dh.demo.web;

import com.dh.demo.domain.RegistrySold;
import com.dh.demo.service.RegistrySoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Lucho on 18/06/2017.
 */
@RestController
@RequestMapping("/registrySolds")
public class RegistrySoldController {
    @Autowired
    private RegistrySoldService registrySoldService;
    @RequestMapping(method = RequestMethod.GET)
    public List<RegistrySold> getAllRegistrySold(){
        return registrySoldService.getAllRegistrySolds();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewRegistrySold(@RequestBody RegistrySoldRequestDTO newRegistrySoldDTO){
        registrySoldService.addNewRegistrySold(newRegistrySoldDTO);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<RegistrySold> getBuyerByIds(@PathVariable long id){
        RegistrySold registrySold = registrySoldService.getRegisterSoldById(id);
        ResponseEntity<RegistrySold> response;
        if(registrySold==null){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity<>(registrySold,HttpStatus.OK);
        }
        return response;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRegistrySold(@PathVariable long id){
        registrySoldService.deleteRegistrySold(id);
    }

    public static class RegistrySoldRequestDTO{
        private Long soldId;
        private Long carId;
        private Long amount;
        private Double addAmount;
        private Date dateofsell;

        public Long getSoldId() {
            return soldId;
        }

        public void setSoldId(Long soldId) {
            this.soldId = soldId;
        }

        public Long getCarId() {
            return carId;
        }

        public void setCarId(Long carId) {
            this.carId = carId;
        }

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }

        public Double getAddAmount() {
            return addAmount;
        }

        public void setAddAmount(Double addAmount) {
            this.addAmount = addAmount;
        }

        public Date getDateofsell() {
            return dateofsell;
        }

        public void setDateofsell(Date dateofsell) {
            this.dateofsell = dateofsell;
        }
    }
}
