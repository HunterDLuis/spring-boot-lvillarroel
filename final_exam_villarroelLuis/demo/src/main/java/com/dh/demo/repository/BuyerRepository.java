package com.dh.demo.repository;

import com.dh.demo.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Lucho on 18/06/2017.
 */
public interface BuyerRepository extends JpaRepository<Buyer,Long>{
    public List<Buyer> getBuyerById(long id);
}
