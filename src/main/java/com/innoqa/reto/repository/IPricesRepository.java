package com.innoqa.reto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innoqa.reto.dao.Prices;

@Repository
public interface IPricesRepository extends CrudRepository<Prices, Long>{

}
