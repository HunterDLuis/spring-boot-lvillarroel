package com.dh.demo.web;

import com.dh.demo.domain.Buyer;
import com.dh.demo.service.BuyerService;
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
@RequestMapping("/buyers")
public class BuyerController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(BuyerController.class);

    @Autowired
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Buyer> getAllBuyer(){
        return buyerService.getAllBuyers();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<Buyer> getBuyerByIds(@PathVariable long id){
        Buyer buyer = buyerService.getBuyerById(id);
        ResponseEntity<Buyer> response;
        if(buyer==null){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity<>(buyer,HttpStatus.OK);
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity updateBuyer(@RequestBody Buyer buyer){
        logger.info("test---->"+buyer.getId());
        System.out.println("the values i");
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBuyer(@RequestBody BuyerRequestDTO buyer,@PathVariable long id){
        buyerService.updateBuyer(id,buyer);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewBuyer(@RequestBody BuyerRequestDTO newBuyerDTO){
        buyerService.addNewBuyer(newBuyerDTO);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBuyerById(@PathVariable long id){
        buyerService.deleteBuyer(id);
    }


    public static class BuyerRequestDTO{
        private String name;
        private Long ci;
        private String profession;
        private Long cel;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getCi() {
            return ci;
        }

        public void setCi(Long ci) {
            this.ci = ci;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public Long getCel() {
            return cel;
        }

        public void setCel(Long cel) {
            this.cel = cel;
        }
    }
}
