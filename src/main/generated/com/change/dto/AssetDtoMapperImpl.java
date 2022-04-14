package com.change.dto;

import com.change.entity.Asset;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-14T14:38:34+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class AssetDtoMapperImpl implements AssetDtoMapper {

    @Override
    public AssetDto assetToDto(Asset Asset) {
        if ( Asset == null ) {
            return null;
        }

        AssetDto assetDto = new AssetDto();

        assetDto.setAsset( Asset.getAsset() );
        assetDto.setType( Asset.getType() );
        assetDto.setAccountID( Asset.getAccountID() );
        assetDto.setId( Asset.getId() );
        assetDto.setAssetRate( Asset.getAssetRate() );
        assetDto.setBalance( Asset.getBalance() );

        return assetDto;
    }

    @Override
    public Asset dtoToAsset(AssetDto AssetDto) {
        if ( AssetDto == null ) {
            return null;
        }

        Asset asset = new Asset();

        asset.setAsset( AssetDto.getAsset() );
        asset.setAssetRate( AssetDto.getAssetRate() );
        asset.setId( AssetDto.getId() );
        asset.setBalance( AssetDto.getBalance() );
        asset.setType( AssetDto.getType() );
        asset.setAccountID( AssetDto.getAccountID() );

        return asset;
    }
}
