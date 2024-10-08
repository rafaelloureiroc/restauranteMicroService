package com.infnetPb.restauranteMicroService.repository.history;

import com.infnetPb.restauranteMicroService.model.history.RestauranteHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestauranteHistoryRepository extends JpaRepository<RestauranteHistory, UUID> {
}