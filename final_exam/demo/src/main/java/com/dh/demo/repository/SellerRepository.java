package com.dh.demo.repository;

import com.dh.demo.domain.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lucho on 18/06/2017.
 */
public interface SellerRepository extends CrudRepository<Seller,Long> {
    //@Query("{name:?0,id:?0}")
    Seller getSellerById( String name,Long id);
}
