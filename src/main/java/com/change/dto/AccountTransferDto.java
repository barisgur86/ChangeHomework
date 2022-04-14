package com.change.dto;

import java.math.BigDecimal;

public class AccountTransferDto {
    private long accountId;

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    private BigDecimal amount;
}
