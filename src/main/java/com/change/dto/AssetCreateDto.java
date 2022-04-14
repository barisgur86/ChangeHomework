package com.change.dto;

public class AssetCreateDto {
    private String asset;
    private long accountId;

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAsset() {
        return asset;
    }

    public long getAccountId() {
        return accountId;
    }
}
