package com.dh.demo.service;

import com.dh.demo.domain.Car;
import com.dh.demo.domain.RegistrySold;
import com.dh.demo.domain.Sold;
import com.dh.demo.repository.CarRepository;
import com.dh.demo.repository.RegistrySoldRepository;
import com.dh.demo.repository.SoldRepository;
import com.dh.demo.web.RegistrySoldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lucho on 18/06/2017.
 */
@Service
public class RegistrySoldService {
    @Autowired
    private RegistrySoldRepository registrySoldRepository;
    @Autowired
    private SoldRepository soldRepository;
    @Autowired
    private CarRepository carRepository;

    public List<RegistrySold> getAllRegistrySolds(){
        return registrySoldRepository.findAll();
    }

    public RegistrySold getRegisterSoldById(Long id){
        return registrySoldRepository.findOne(id);
    }

    public void addNewRegistrySold(RegistrySoldController.RegistrySoldRequestDTO registrySoldDTO){
        RegistrySold newregistrySold = new RegistrySold();
        Car newcar = carRepository.findOne(registrySoldDTO.getCarId());
        Sold newSold = soldRepository.findOne(registrySoldDTO.getSoldId());
        newregistrySold.setCar(newcar);
        newregistrySold.setSold(newSold);
        newregistrySold.setAmount(registrySoldDTO.getAmount());
        newregistrySold.setAddAmount(registrySoldDTO.getAddAmount());

        registrySoldRepository.save(newregistrySold);
    }

    public void deleteRegistrySold(Long id){
        registrySoldRepository.delete(id);
    }
}
