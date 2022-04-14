package com.change.controller;

import com.change.dto.*;
import com.change.entity.User;
import com.change.service.AccountService;
import com.change.service.AssetService;
import com.change.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestController {

    private final UserService userService;
    private final AccountService accountService;
    private final AssetService assetService;
    @GetMapping("/user")
    public List<UserDto> getUsers() {
        return userService.getUserList();
    }


    @PostMapping("/user/create")
    private long saveUser(@RequestBody UserDto userDto)
    {
        userService.saveOrUpdate(userDto);
        return userDto.getId();
    }

    @DeleteMapping("/user/delete/{id}")
    private void deleteUser(@PathVariable("id") long id)
    {
        userService.delete(id);
    }

    @PutMapping("/user/update")
    private UserDto updateUser(@RequestBody UserDto userDto)
    {
        return userService.updateUser(userDto);
    }

    @PostMapping("/account/create/{userId}")
    private long saveAccount(@PathVariable("userId") long userId)
    {
        AccountDto accountDto = new AccountDto(userId);
        accountService.saveAccount(accountDto);
        return accountDto.getId();
    }

    @GetMapping("/account")
    public List<AccountDto> getAccounts() {
        return accountService.getAccountList();
    }

    @PostMapping("/account/deposit")
    private boolean deposit(@RequestBody AccountTransferDto accountTransferDto)
    {
        return accountService.deposit(accountTransferDto);
    }

    @PostMapping("/account/withdraw")
    private boolean withdraw(@RequestBody AccountTransferDto accountTransferDto)
    {
        return accountService.withdraw(accountTransferDto);
    }

    @PostMapping("/asset/create")
    private void createAsset(@RequestBody AssetCreateDto assetCreateDto)
    {
        assetService.saveAsset(assetCreateDto);

    }

    @GetMapping("/asset")
    public List<AssetDto> getAssets() {

        return assetService.getAssetList();
    }

    @PostMapping("/asset/buy")
    private boolean buy(@RequestBody AssetTransferDto assetTransferDto)
    {
        return assetService.buy(assetTransferDto);
    }

    @PostMapping("/asset/sell")
    private boolean sell(@RequestBody AssetTransferDto assetTransferDto)
    {
        return assetService.sell(assetTransferDto);
    }

}
