package com.dh.demo.repository;

import com.dh.demo.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Created by Lucho on 18/06/2017.
 */
public interface CarRepository extends CrudRepository<Car,Long> {

    public List<Car> getCarById(Long id);
}
