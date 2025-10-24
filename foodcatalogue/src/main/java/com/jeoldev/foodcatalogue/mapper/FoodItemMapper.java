package com.jeoldev.foodcatalogue.mapper;

import com.jeoldev.foodcatalogue.dto.FoodItemDTO;
import com.jeoldev.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    
    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
    
    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
    
    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);
}