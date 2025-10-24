package com.jeoldev.foodcatalogue.service;

import com.jeoldev.foodcatalogue.dto.FoodCataloguePage;
import com.jeoldev.foodcatalogue.dto.FoodItemDTO;
import com.jeoldev.foodcatalogue.dto.RestaurantDTO;
import com.jeoldev.foodcatalogue.entity.FoodItem;
import com.jeoldev.foodcatalogue.mapper.FoodItemMapper;
import com.jeoldev.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodCatalogueService {
    
    @Autowired
    private FoodItemRepo foodItemRepo;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSavedInDB = foodItemRepo.save(
            FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO)
        );
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSavedInDB);
    }
    
    public FoodCataloguePage fetchFoodCataloguePageDetails(Long restaurantId) {
        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        RestaurantDTO restaurantDTO = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurantDTO);
    }
    
    private List<FoodItem> fetchFoodItemList(Long restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }
    
    private RestaurantDTO fetchRestaurantDetailsFromRestaurantMS(Long restaurantId) {
        return restTemplate.getForObject(
            "http://RESTAURANT-SERVICE/restaurant/fetchById/" + restaurantId,
            RestaurantDTO.class
        );
    }
    
    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, RestaurantDTO restaurantDTO) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(
            foodItemList.stream()
                .map(FoodItemMapper.INSTANCE::mapFoodItemToFoodItemDTO)
                .collect(Collectors.toList())
        );
        foodCataloguePage.setRestaurant(restaurantDTO);
        return foodCataloguePage;
    }
}