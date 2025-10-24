package com.eurekaexersice01.restaurantlisting.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eurekaexersice01.restaurantlisting.dto.RestaurantDTO;
import com.eurekaexersice01.restaurantlisting.entity.Restaurant;
import com.eurekaexersice01.restaurantlisting.mapper.RestaurantMapper;
import com.eurekaexersice01.restaurantlisting.repositories.RestaurantRepo;

@Service
public class RestaurantService {
    
    private final RestaurantRepo restaurantRepo;
    private final RestaurantMapper restaurantMapper;

    @Autowired
    public RestaurantService(RestaurantRepo restaurantRepo, RestaurantMapper restaurantMapper) {
        this.restaurantRepo = restaurantRepo;
        this.restaurantMapper = restaurantMapper;
    }

    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        return restaurants.stream()
            .map(restaurantMapper::mapRestaurantToRestaurantDTO)
            .collect(Collectors.toList());
    }

    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
        Restaurant saveRestaurant = restaurantRepo.save(
            restaurantMapper.mapRestaurantDTOToRestaurant(restaurantDTO)
        );
        return restaurantMapper.mapRestaurantToRestaurantDTO(saveRestaurant);
    }

    public ResponseEntity<RestaurantDTO> fetchRestaurantById(Long id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if (restaurant.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
            restaurantMapper.mapRestaurantToRestaurantDTO(restaurant.get()),
            HttpStatus.OK
        );
    }
}

    

