package com.eurekaexercise.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTOFromFE {
    private List<FoodItemDTO> foodItemsList;
    private Long userId;
    private Restaurant restaurant;
}
