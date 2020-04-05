package com.example.currencymicroservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "currency_values")
public class CurrencyModel {

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(String currencyValue) {
        this.currencyValue = currencyValue;
    }
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    @Column(name="currency_type",unique = true)
        private String currencyType;

    @Column(name="currency_value")
    private String currencyValue;


}
