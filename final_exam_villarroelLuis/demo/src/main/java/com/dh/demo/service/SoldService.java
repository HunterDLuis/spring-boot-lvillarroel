package com.dh.demo.service;

import com.dh.demo.domain.Buyer;
import com.dh.demo.domain.Seller;
import com.dh.demo.domain.Sold;
import com.dh.demo.repository.BuyerRepository;
import com.dh.demo.repository.SellerRepository;
import com.dh.demo.repository.SoldRepository;
import com.dh.demo.web.SoldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Lucho on 18/06/2017.
 */
@Service
public class SoldService {
    @Autowired
    private SoldRepository soldRepository;
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private SellerRepository sellerRepository;

    public List<Sold> getAllSold(){
        return (List<Sold>) soldRepository.findAll();
    }

    public Sold getSoldById(Long id){
        return soldRepository.findOne(id);
    }

    public void updateSold(SoldController.SoldRequestDTO soldDTO,Long id){

        Buyer updateBuyer = buyerRepository.findOne(soldDTO.getBuyerId());
        Seller updateSeller = sellerRepository.findOne(soldDTO.getSellerId());

        Sold sold = soldRepository.findOne(id);

        if(soldDTO.getBuyerId()!=null){
            sold.setBuyer(updateBuyer);
        }
        if(soldDTO.getSellerId()!=null){
            sold.setSeller(updateSeller);
        }
        if(soldDTO.getDate()!=null){
            sold.setDate(soldDTO.getDate());
        }
        soldRepository.save(sold);

    }

    public void addNewSold(SoldController.SoldRequestDTO soldDTO){
        Sold newsold = new Sold();
        Seller seller = sellerRepository.findOne(soldDTO.getSellerId());
        Buyer buyer = buyerRepository.findOne(soldDTO.getBuyerId());
        newsold.setSeller(seller);
        newsold.setBuyer(buyer);
        newsold.setDate(soldDTO.getDate());

        soldRepository.save(newsold);
    }

    public void deleteSold(Long id){
        soldRepository.delete(id);
    }
}
