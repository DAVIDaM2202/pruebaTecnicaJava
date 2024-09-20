package com.example.prueba.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data // Lombok genera getters, setters, equals, hashCode y toString automáticamente.
@Entity // Define que esta clase es una entidad JPA.
@Table(name = "prices") // Asocia esta entidad con la tabla 'prices'.
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define la estrategia de generación de la clave primaria.
    private Long id;

    private Integer brandId; // Identificador de la cadena
    private LocalDateTime startDate; // Fecha de inicio de la tarifa
    private LocalDateTime endDate;   // Fecha de fin de la tarifa
    private Integer priceList; // Tarifa de precios
    private Long productId;  // Identificador del producto
    private Integer priority;  // Prioridad de la tarifa
    private BigDecimal price;  // Precio final
    private String curr;       // Moneda del precio
}
