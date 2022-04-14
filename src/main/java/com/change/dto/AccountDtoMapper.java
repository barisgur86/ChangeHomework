package com.change.dto;

import com.change.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountDtoMapper {
    AccountDto accountToDto(Account Account);
    Account dtoToAccount(AccountDto AccountDto);
}