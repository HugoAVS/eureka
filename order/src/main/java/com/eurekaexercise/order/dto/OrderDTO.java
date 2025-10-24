package com.eurekaexercise.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long orderId;
    private List<FoodItemDTO> foodItemsList;
    private Restaurant restaurant;
    private UserDTO userDTO;
}
