package com.change.dto;

import java.math.BigDecimal;
import java.util.stream.Stream;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssetDto {
    private String asset;
    private BigDecimal assetRate;
    private BigDecimal balance;
    private String type;
    private long accountID;
    private long id;

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    public void setId(long id) {
        this.id = id;
    }



    public AssetDto(long accountID, String asset ) {
        this.asset = asset;
        this.accountID = accountID;
        if(Stream.of(CryptoAssetType.values()).anyMatch(v -> v.name().equals(asset))){
            type = AssetType.CRYPTO.toString();
        }else if(Stream.of(StockAssetType.values()).anyMatch(v -> v.name().equals(asset))){
            type = AssetType.STOCK.toString();
        }else if(Stream.of(CommodityAssetType.values()).anyMatch(v -> v.name().equals(asset))){
            type = AssetType.COMMODITY.toString();
        }
        this.balance= new BigDecimal(0);
        this.assetRate = new BigDecimal(Math.random()*100);
    }

    //Asset -> BTC, ETH, TESLA, UBER




    public BigDecimal getAssetRate() {
        return assetRate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setAssetRate(BigDecimal assetRate) {
        this.assetRate = assetRate;
    }

    public String getAsset() {
        return asset;
    }

    public String getType() {
        return type;
    }



    public long getAccountID() {
        return accountID;
    }

    public long getId() {
        return id;
    }

    public AssetDto() {
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


}
