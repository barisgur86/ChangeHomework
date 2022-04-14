package com.change.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private long id;

    public AccountDto() {
    }

    private BigDecimal balance;
    private long userId;


    public void setId(long id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public long getUserId() {
        return userId;
    }

    public AccountDto(long userId) {
        this.balance = new BigDecimal(0);
        this.userId = userId;

    }
}
