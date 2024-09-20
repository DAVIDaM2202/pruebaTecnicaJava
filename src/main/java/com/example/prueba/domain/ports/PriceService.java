package com.example.prueba.domain.ports;

import com.example.prueba.domain.model.Price;
import com.example.prueba.domain.model.PriceResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {
    List<PriceResponseDTO> getPrices(Long productId, Integer brandId, LocalDateTime applicationDate);
}
