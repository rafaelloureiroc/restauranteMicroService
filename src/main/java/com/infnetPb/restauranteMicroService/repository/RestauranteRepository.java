package com.infnetPb.restauranteMicroService.repository;



import com.infnetPb.restauranteMicroService.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestauranteRepository extends JpaRepository<Restaurante, UUID> {
}
