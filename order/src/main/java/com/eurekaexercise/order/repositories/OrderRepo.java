package com.eurekaexercise.order.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eurekaexercise.order.entity.Order;

public interface OrderRepo extends MongoRepository<Order, Long>{
    
}
