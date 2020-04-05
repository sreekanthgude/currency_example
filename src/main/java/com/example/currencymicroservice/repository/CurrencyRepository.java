package com.example.currencymicroservice.repository;


import com.example.currencymicroservice.entity.CurrencyModel;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyModel, String> {



}
