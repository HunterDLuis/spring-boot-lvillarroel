package com.dh.demo.service;

import com.dh.demo.domain.Buyer;
import com.dh.demo.repository.BuyerRepository;
import com.dh.demo.web.BuyerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lucho on 18/06/2017.
 */
@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer> getAllBuyers(){
        return buyerRepository.findAll();
    }



    public Buyer getBuyerById(Long id){
        return buyerRepository.findOne(id);
    }

    public void updateBuyer(Long id,BuyerController.BuyerRequestDTO buyerDTO){

        Buyer buyer = buyerRepository.findOne(id);
        if(buyerDTO.getName()!=null){
            buyer.setName(buyerDTO.getName());
        }
        if(buyerDTO.getCi()!=null){
            buyer.setCi(buyerDTO.getCi());
        }
        if(buyerDTO.getCel()!=null){
            buyer.setCel(buyerDTO.getCel());
        }
        if(buyerDTO.getProfession()!=null){
            buyer.setProfession(buyerDTO.getProfession());
        }
        buyerRepository.save(buyer);

    }

    public void addNewBuyer(BuyerController.BuyerRequestDTO newBuyerDTO){
        Buyer newBuyer = new Buyer();

        newBuyer.setName(newBuyerDTO.getName());
        newBuyer.setCi(newBuyerDTO.getCi());
        newBuyer.setProfession(newBuyerDTO.getProfession());
        newBuyer.setCel(newBuyerDTO.getCel());

        buyerRepository.save(newBuyer);
    }

    public void deleteBuyer(Long id){
        buyerRepository.delete(id);
    }
}
