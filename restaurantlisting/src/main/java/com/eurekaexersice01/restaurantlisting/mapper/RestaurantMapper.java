package com.eurekaexersice01.restaurantlisting.mapper;

import org.mapstruct.Mapper;
import com.eurekaexersice01.restaurantlisting.dto.RestaurantDTO;
import com.eurekaexersice01.restaurantlisting.entity.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
}
