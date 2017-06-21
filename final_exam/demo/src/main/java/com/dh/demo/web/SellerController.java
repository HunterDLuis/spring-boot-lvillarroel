package com.dh.demo.web;

import com.dh.demo.domain.Seller;
import com.dh.demo.service.SellerService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Lucho on 18/06/2017.
 */
@RestController
@RequestMapping("/sellers")
public class SellerController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(SellerController.class);

    @Autowired
    private SellerService sellerService;

    //mostrar seller
    @RequestMapping(method = RequestMethod.GET)
    public List<Seller> getAllSeller(){
        return sellerService.getAllSellers();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<Seller> getSellerByIds(@PathVariable long id){
        Seller seller = sellerService.getSeller(id);
        ResponseEntity<Seller> response;
        if(seller==null){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity<>(seller,HttpStatus.OK);
        }
        return response;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSeller(@RequestBody Seller seller,@PathVariable long id){
        Seller sellerOld = sellerService.getSeller(id);
        if(sellerOld!=null){
            sellerService.updateSeller(seller);
        }
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity<Seller> updateSeller(@RequestBody Seller seller){
        logger.info("test----->" + seller.getId());
        System.out.println("the values i");
        return new ResponseEntity(HttpStatus.OK);
    }


    //agregar seller
    @RequestMapping(method = RequestMethod.POST)
    public void addSeller(@RequestBody SellerRequestDTO newSellerDTO){
        sellerService.addNewSeller(newSellerDTO);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeSeller(@PathVariable Long id){
        sellerService.deleteSeller(id);
    }

    public static class SellerRequestDTO{
        private String name;
        private Long edad;
        private Long ci;
        private Long num_car_sold;

        public String getName() {
            return name;
        }

        public Long getEdad() {
            return edad;
        }

        public Long getCi() {
            return ci;
        }

        public Long getNum_car_sold() {
            return num_car_sold;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEdad(Long edad) {
            this.edad = edad;
        }

        public void setCi(Long ci) {
            this.ci = ci;
        }

        public void setNum_car_sold(Long num_car_sold) {
            this.num_car_sold = num_car_sold;
        }
    }
}
