package com.eurekaexersice01.restaurantlisting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eurekaexersice01.restaurantlisting.entity.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
    
}
