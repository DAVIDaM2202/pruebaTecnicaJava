package com.example.prueba.inbound;

import com.example.prueba.application.PriceServiceImp;
import com.example.prueba.domain.model.PriceResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import com.example.prueba.domain.model.Price;


@RestController
@RequestMapping("/api/prices")
public class PriceController {

    @Autowired
    private PriceServiceImp priceService;

    @GetMapping("/prices")
    public List<PriceResponseDTO> getPrices(
            @RequestParam Long productId,
            @RequestParam Integer brandId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

        return priceService.getPrices(productId, brandId, applicationDate);
    }
}
