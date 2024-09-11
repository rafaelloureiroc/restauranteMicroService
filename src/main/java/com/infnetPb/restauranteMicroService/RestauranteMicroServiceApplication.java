package com.infnetPb.restauranteMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class RestauranteMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteMicroServiceApplication.class, args);
	}

}
