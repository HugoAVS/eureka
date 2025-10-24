package com.eurekaexercise.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eurekaexercise.order.dto.OrderDTO;
import com.eurekaexercise.order.dto.OrderDTOFromFE;
import com.eurekaexercise.order.dto.UserDTO;
import com.eurekaexercise.order.entity.Order;
import com.eurekaexercise.order.mappers.OrderMapper;
import com.eurekaexercise.order.repositories.OrderRepo;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderInDB(OrderDTOFromFE orderDetails) {
        Long newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved =
                new Order(newOrderID, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO);
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDto(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Long userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }
}
