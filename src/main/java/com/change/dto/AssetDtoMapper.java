package com.change.dto;

import com.change.entity.Asset;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssetDtoMapper {
    AssetDto assetToDto(Asset Asset);
    Asset dtoToAsset(AssetDto AssetDto);
}