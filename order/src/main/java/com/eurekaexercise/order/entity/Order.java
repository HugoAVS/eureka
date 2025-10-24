package com.eurekaexercise.order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.eurekaexercise.order.dto.FoodItemDTO;
import com.eurekaexercise.order.dto.Restaurant;
import com.eurekaexercise.order.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {
    private Long orderId;
    private List<FoodItemDTO> foodItemsList;
    private Restaurant restaurant;
    private UserDTO userDTO;
    
}
