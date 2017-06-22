package com.dh.demo.service;

import com.dh.demo.domain.Car;
import com.dh.demo.repository.CarRepository;
import com.dh.demo.web.CarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lucho on 18/06/2017.
 */
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars(){
        return (List<Car>) carRepository.findAll();
    }

    public Car getCarId(Long id){
        return carRepository.findOne(id);
    }

    public void addNewCar(CarController.CarRequestDTO newCarDTO){
        Car newCar = new Car();
        newCar.setBrand(newCarDTO.getBrand());
        newCar.setYear(newCarDTO.getYear());
        newCar.setModel(newCarDTO.getModel());
        newCar.setColor(newCarDTO.getColor());
        newCar.setImage(newCarDTO.getImage());

        carRepository.save(newCar);
    }

    public  void updateCar(CarController.CarRequestDTO carDTO,Long id){
        Car car = carRepository.findOne(id);

        if(carDTO.getBrand()!=null){
            car.setBrand(carDTO.getBrand());
        }
        if(carDTO.getYear()!=null){
            car.setYear(carDTO.getYear());
        }
        if(carDTO.getModel()!=null){
            car.setModel(carDTO.getModel());
        }
        if(carDTO.getColor()!=null){
            car.setColor(carDTO.getColor());
        }
        if(carDTO.getImage()!=null){
            car.setImage(carDTO.getImage());
        }
        carRepository.save(car);
    }

    public void deleteCar(Long id){
        carRepository.delete(id);
    }
}
