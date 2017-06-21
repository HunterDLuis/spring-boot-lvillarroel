package com.dh.demo.service;

import com.dh.demo.domain.Seller;
import com.dh.demo.repository.SellerRepository;
import com.dh.demo.web.SellerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lucho on 18/06/2017.
 */
@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public List<Seller> getAllSellers(){
        return (List<Seller>) sellerRepository.findAll();
    }

    public Seller getSeller(Long id){
        return sellerRepository.findOne(id);
    }

    public Seller updateSeller(Seller seller){
        return seller;
    }

    public void addNewSeller(SellerController.SellerRequestDTO newSellerDTO){
        Seller newseller = new Seller();
        newseller.setName(newSellerDTO.getName());
        newseller.setEdad(newSellerDTO.getEdad());
        newseller.setCi(newSellerDTO.getCi());
        newseller.setNum_car_sold(newSellerDTO.getNum_car_sold());

        sellerRepository.save(newseller);
    }

    public void deleteSeller(Long id){
        sellerRepository.delete(id);
    }
}
