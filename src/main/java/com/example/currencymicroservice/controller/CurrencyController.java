package com.example.currencymicroservice.controller;


import com.example.currencymicroservice.entity.CurrencyModel;
import com.example.currencymicroservice.service.CurrencyService;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value="Currency Rates", description="Showing Currency rates based on Input Currency")
public class CurrencyController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CurrencyService currencyService;

    private final String THIRD_PARTY_CURRENCY_URL="https://api.exchangeratesapi.io/latest?base=USD";

    @GetMapping("/currency/value/{currencyType}")
    public ResponseEntity<?> getCurrencyValue(@PathVariable(value = "currencyType",required = true) String currencyType){
        JsonNode value = restTemplate.getForObject(THIRD_PARTY_CURRENCY_URL, JsonNode.class);
        CurrencyModel currencyModel = new CurrencyModel();
        List<CurrencyModel> currencyData = currencyService.fetchCurrencyValues(currencyModel,value,currencyType);
        return new ResponseEntity(currencyData, HttpStatus.OK);
    }

}
