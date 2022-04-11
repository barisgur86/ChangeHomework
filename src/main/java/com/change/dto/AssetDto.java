package com.change.dto;

import java.math.BigDecimal;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssetDto {
    String currencyName;
    BigDecimal currencyRate;
    BigDecimal balance;
    String type;
    String assetName;
    long userID;
    long id;
    //Asset -> BTC, ETH, TESLA, UBER




    public BigDecimal getCurrencyRate() {
        return currencyRate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}
