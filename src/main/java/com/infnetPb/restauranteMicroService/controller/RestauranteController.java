package com.infnetPb.restauranteMicroService.controller;


import com.infnetPb.restauranteMicroService.DTO.RestauranteDTO;
import com.infnetPb.restauranteMicroService.model.history.RestauranteHistory;
import com.infnetPb.restauranteMicroService.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<RestauranteDTO> createRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        try {
        RestauranteDTO createdRestaurante = restauranteService.createRestaurante(restauranteDTO);
        return new ResponseEntity<>(createdRestaurante, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> getAllRestaurantes() {
        List<RestauranteDTO> restaurantes = restauranteService.getAllRestaurantes();
        return new ResponseEntity<>(restaurantes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestauranteById(@PathVariable UUID id) {
        try {
        restauranteService.deleteRestauranteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestauranteDTO> updateRestaurante(@PathVariable UUID id, @RequestBody RestauranteDTO restauranteDTO) {
        try {
        RestauranteDTO updatedRestaurante = restauranteService.updateRestaurante(id, restauranteDTO);
        return new ResponseEntity<>(updatedRestaurante, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDTO> getRestauranteById(@PathVariable("id") UUID id) {
        RestauranteDTO restauranteDTO = restauranteService.getRestauranteById(id);
        if (restauranteDTO != null) {
            return ResponseEntity.ok(restauranteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/historico")
    public ResponseEntity<List<RestauranteHistory>> getAllRestauranteHistories() {
        List<RestauranteHistory> history = restauranteService.getAllRestauranteHistories();
        return new ResponseEntity<>(history, HttpStatus.OK);
    }
}
