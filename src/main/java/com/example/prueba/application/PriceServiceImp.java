package com.example.prueba.application;

import com.example.prueba.domain.model.Price;
import com.example.prueba.domain.model.PriceResponseDTO;
import com.example.prueba.domain.ports.PriceRepository;
import com.example.prueba.domain.ports.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceServiceImp implements PriceService {

    @Autowired
    private PriceRepository priceRepository;
    /*@Override
    public List<Price> getPrices(Long productId, Integer brandId, LocalDateTime startDate, LocalDateTime endDate) {
        return priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                productId, brandId, startDate, endDate
        );
    }*/
    @Override
    public List<PriceResponseDTO> getPrices(Long productId, Integer brandId, LocalDateTime applicationDate) {
        List<Price> prices = priceRepository.findApplicablePrice(productId, brandId, applicationDate);

        List<PriceResponseDTO> pricesService = prices.stream()
                .map(price -> new PriceResponseDTO(
                        price.getProductId(),
                        price.getBrandId(),
                        price.getPriceList(),
                        price.getStartDate(),
                        price.getEndDate(),
                        price.getPrice()))
                .collect(Collectors.toList());
        return pricesService;
    }


}

