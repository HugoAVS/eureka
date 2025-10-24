package com.eurekaexercise.order.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.eurekaexercise.order.dto.OrderDTO;
import com.eurekaexercise.order.entity.Order;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    
    Order mapOrderDtoToOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDto(Order order);
    
}
