package com.example.prueba.domain.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data // Lombok genera getters, setters, equals, hashCode y toString automáticamente.
public class PriceResponseDTO {
    private Long productId;
    private Integer brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;

    public PriceResponseDTO(Long productId, Integer brandId, Integer priceList, LocalDateTime startDate, LocalDateTime endDate, BigDecimal price) {
    this.productId = productId;
    this.brandId = brandId;
    this.priceList = priceList;
    this.startDate = startDate;
    this.endDate = endDate;
    this.price=price;

    }
}
