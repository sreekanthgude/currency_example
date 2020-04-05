package com.example.currencymicroservice.service;

import com.example.currencymicroservice.entity.CurrencyModel;
import com.example.currencymicroservice.repository.CurrencyRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;


    public List<CurrencyModel> fetchCurrencyValues(CurrencyModel currencyModel,JsonNode jsonNode, String currencyType){
        List<CurrencyModel> dbData = null;
        String currencyValue = extractCurrencyValueFromJSON(jsonNode,currencyType);
        currencyModel.setCurrencyType(currencyType);
        currencyModel.setCurrencyValue(currencyValue);
        dbData = currencyRepository.findAll();
        BigDecimal bigDecimal = new BigDecimal(currencyValue);
        if(dbData != null && dbData.size() > 0) {
            dbData.forEach(entity -> {
                entity.setCurrencyValue(String.valueOf(new BigDecimal(entity.getCurrencyValue()).multiply(bigDecimal)));
                entity.setCurrencyType(currencyType);
            });
        }
        return dbData;
    }

    public String extractCurrencyValueFromJSON(JsonNode jsonNode, String currencyType){
        String currencyValue = null;
        if(jsonNode != null){
            if(jsonNode.has("rates")){
                JsonNode rates = jsonNode.get("rates");
                currencyValue =rates.get(currencyType).asText();
            }
        }
        return currencyValue;
    }

}
