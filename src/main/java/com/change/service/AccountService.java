package com.change.service;

import com.change.dto.AccountDto;

import java.math.BigDecimal;

public class AccountService {

    public boolean deposit(AccountDto accountDto,BigDecimal amount){

        accountDto.setBalance(accountDto.getBalance().add(amount));
        return true;
    }

    public boolean withdraw(AccountDto accountDto, BigDecimal amount){
        if(amount.compareTo(accountDto.getBalance()) > 0){
            return false;
        }else{
            accountDto.setBalance(accountDto.getBalance().subtract(amount));
            return true;
        }

    }


}
