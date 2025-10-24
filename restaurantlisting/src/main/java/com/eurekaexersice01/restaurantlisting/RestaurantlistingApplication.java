package com.eurekaexersice01.restaurantlisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class RestaurantlistingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantlistingApplication.class, args);
	}

}
