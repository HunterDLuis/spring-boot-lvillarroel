package com.dh.demo.web;

import com.dh.demo.domain.Car;
import com.dh.demo.service.CarService;
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
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    //obtener carros
    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    //obtener carro por id
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<Car> getCarByIds(@PathVariable long id){
        Car car = carService.getCarId(id);
        ResponseEntity<Car> response;
        if(car==null){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity<>(car,HttpStatus.OK);
        }
        return response;
    }

    //crear nuevo carro
    @RequestMapping(method = RequestMethod.POST)
    public void addNewCar(@RequestBody CarRequestDTO newCarDTO){
        carService.addNewCar(newCarDTO);
    }

    //acturalizar carro
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCar(@RequestBody Car car,@PathVariable long id){
        Car carOld = carService.getCarId(id);
        if(carOld!=null){
            carService.updateCar(car);
        }
    }

    //eliminar car
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCar(@PathVariable long id){
        carService.deleteCar(id);
    }

    public static class CarRequestDTO{
        private String brand;
        private Long year;
        private String model;
        private String color;
        private String image;

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setYear(Long year) {
            this.year = year;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBrand() {
            return brand;
        }

        public Long getYear() {
            return year;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public String getImage() {
            return image;
        }
    }
}
