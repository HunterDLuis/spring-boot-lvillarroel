package com.dh.demo.repository;

import com.dh.demo.domain.RegistrySold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lucho on 18/06/2017.
 */
public interface RegistrySoldRepository extends JpaRepository<RegistrySold,Long>{

}
