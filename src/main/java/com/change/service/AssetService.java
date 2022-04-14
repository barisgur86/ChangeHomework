package com.change.service;

import com.change.dto.*;
import com.change.entity.Account;
import com.change.entity.Asset;
import com.change.repository.AccountRepository;
import com.change.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetService {


    private final AssetRepository assetRepository;
    private final AssetDtoMapper assetDtoMapper;
    private final AccountDtoMapper accountDtoMapper;
    private final AccountRepository accountRepository;


    public boolean buy(AssetTransferDto assetTransferDto) {
        Asset asset = assetRepository.findById(assetTransferDto.getAssetId()).get();
        AssetDto assetDto = assetDtoMapper.assetToDto(asset);
        Account account = accountRepository.findById(assetDto.getAccountID()).get();
        AccountDto accountDto = accountDtoMapper.accountToDto(account);
        BigDecimal amountForAcconut = assetDto.getAssetRate().multiply(assetTransferDto.getAmount());
        if (amountForAcconut.compareTo(accountDto.getBalance())>0){
            return false;
        }else{
            assetDto.setBalance(assetDto.getBalance().add(assetTransferDto.getAmount()));
            asset = assetDtoMapper.dtoToAsset(assetDto);
            assetRepository.save(asset);
            accountDto.setBalance(accountDto.getBalance().subtract(amountForAcconut));
            account = accountDtoMapper.dtoToAccount(accountDto);
            accountRepository.save(account);
            return true;
        }

    }

    public boolean sell(AssetTransferDto assetTransferDto){
        Asset asset = assetRepository.findById(assetTransferDto.getAssetId()).get();
        AssetDto assetDto = assetDtoMapper.assetToDto(asset);
        if(assetTransferDto.getAmount().compareTo(assetDto.getBalance()) > 0){
            return false;
        }else{
            Account account = accountRepository.findById(assetDto.getAccountID()).get();
            AccountDto accountDto = accountDtoMapper.accountToDto(account);
            BigDecimal amountForAcconut = assetDto.getAssetRate().multiply(assetTransferDto.getAmount());
            assetDto.setBalance(assetDto.getBalance().subtract(assetTransferDto.getAmount()));
            asset = assetDtoMapper.dtoToAsset(assetDto);
            assetRepository.save(asset);
            accountDto.setBalance(accountDto.getBalance().add(amountForAcconut));
            account = accountDtoMapper.dtoToAccount(accountDto);
            accountRepository.save(account);
            return true;
        }

    }

    public List<AssetDto> getAssetList(){
        //database e baglan Assetlari al dto ya convert et
        List <Asset> assetList = new ArrayList<Asset>();
        assetRepository.findAll().forEach(asset-> assetList.add(asset));
        List<AssetDto> assetDtoList = new ArrayList<AssetDto>();
        assetList.forEach(asset-> assetDtoList.add(assetDtoMapper.assetToDto(asset)));

        //donen datayi org.mapstruct.mapper ile dto ya maplemen gerekiyor
        // List<Asset> AssetList= List.of(new Asset("baris"));
        return assetDtoList;
    }
    public void saveAsset(AssetCreateDto assetCreateDto)
    {
        AssetDto assetDto = new AssetDto(assetCreateDto.getAccountId(),assetCreateDto.getAsset());

        Asset asset = assetDtoMapper.dtoToAsset(assetDto);

        assetRepository.save(asset);
    }

}
