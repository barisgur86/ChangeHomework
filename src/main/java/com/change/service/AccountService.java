package com.change.service;

import com.change.dto.AccountDto;
import com.change.dto.AccountDto;
import com.change.dto.AccountDtoMapper;
import com.change.dto.AccountTransferDto;
import com.change.entity.Account;
import com.change.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

   private final AccountRepository accountRepository;
   private final AccountDtoMapper accountDtoMapper;


    public boolean deposit(AccountTransferDto accountTransferDto) {
        Account account = accountRepository.findById(accountTransferDto.getAccountId()).get();
        AccountDto accountDto = accountDtoMapper.accountToDto(account);
        accountDto.setBalance(accountDto.getBalance().add(accountTransferDto.getAmount()));
        account = accountDtoMapper.dtoToAccount(accountDto);
        accountRepository.save(account);
        return true;
    }

    public boolean withdraw(AccountTransferDto accountTransferDto){
        Account account = accountRepository.findById(accountTransferDto.getAccountId()).get();
        AccountDto accountDto = accountDtoMapper.accountToDto(account);
        if(accountTransferDto.getAmount().compareTo(accountDto.getBalance()) > 0){
            return false;
        }else{
            accountDto.setBalance(accountDto.getBalance().subtract(accountTransferDto.getAmount()));
            account = accountDtoMapper.dtoToAccount(accountDto);
            accountRepository.save(account);
            return true;
        }

    }

    public List<AccountDto> getAccountList(){
        //database e baglan Accountlari al dto ya convert et
        List <Account> accountList = new ArrayList<Account>();
        accountRepository.findAll().forEach(account-> accountList.add(account));
        List<AccountDto> accountDtoList = new ArrayList<AccountDto>();
        accountList.forEach(account-> accountDtoList.add(accountDtoMapper.accountToDto(account)));

        //donen datayi org.mapstruct.mapper ile dto ya maplemen gerekiyor
        // List<Account> AccountList= List.of(new Account("baris"));
        return accountDtoList;
    }
    public void saveAccount(AccountDto accountDto)
    {

        Account account = accountDtoMapper.dtoToAccount(accountDto);

        accountRepository.save(account);
    }

   /* public void delete(long id)
    {
        AccountRepository.deleteById(id);
    }*/

/*    public AccountDto updateAccount(AccountDto accountDto)
    {

        Account accountDb = AccountRepository.findById(accountDto.getId()).get();
        accountDb.set(accountDto.getName());
        AccountRepository.save(AccountDb);
        AccountDto =AccountDtoMapper.AccounttoDto(AccountDb);

        return AccountDto;
    }*/


}
