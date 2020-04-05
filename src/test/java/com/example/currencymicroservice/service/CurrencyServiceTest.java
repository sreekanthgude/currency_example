package com.example.currencymicroservice.service;

import com.example.currencymicroservice.entity.CurrencyModel;
import com.example.currencymicroservice.repository.CurrencyRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

public class CurrencyServiceTest {


    @Mock
    CurrencyRepository currencyRepository;


    @Test
    public void saveCurrencyValueTest(){
        CurrencyService temp = new CurrencyService();
        CurrencyService spyTemp = Mockito.spy(temp);
        Mockito.doReturn("2.3").when(spyTemp).extractCurrencyValueFromJSON(Mockito.any(),Mockito.any());
        List<CurrencyModel> currencyModel = new ArrayList<>();
        Mockito.doReturn(currencyModel).when(spyTemp).fetchCurrencyValues(Mockito.any(),Mockito.any(),Mockito.any());
    }
}
