package com.infnetPb.restauranteMicroService.model.history;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infnetPb.restauranteMicroService.model.Restaurante;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class RestauranteHistory {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    @JsonIgnore
    private Restaurante restaurante;

    private String nome;
    private LocalDateTime timestamp;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String operation;
}