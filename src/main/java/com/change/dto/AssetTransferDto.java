package com.change.dto;

import java.math.BigDecimal;

public class AssetTransferDto {
    private long assetId;
    private BigDecimal amount;

    public long getAssetId() {
        return assetId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
