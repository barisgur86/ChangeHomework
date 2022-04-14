package com.change.entity;

import com.change.dto.AssetType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ASSET")
public class Asset {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="BALANCE")
    private BigDecimal balance;
    @Column(name="ASSET")
    private String asset;
    @Column(name="ASSET_RATE")
    private BigDecimal assetRate;
    @Column(name="TYPE")
    private String type;

    public long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }



    public String getType() {
        return type;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getAsset() {
        return asset;
    }

    public BigDecimal getAssetRate() {
        return assetRate;
    }

    public void setAssetRate(BigDecimal assetRate) {
        this.assetRate = assetRate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    @Column(name="ACCOUNT_ID")
    private long accountID;

}
