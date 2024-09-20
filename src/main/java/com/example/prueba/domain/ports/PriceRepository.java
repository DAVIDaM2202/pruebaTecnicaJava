package com.example.prueba.domain.ports;


import com.example.prueba.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

   /* List<Price> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Long productId, Integer brandId, LocalDateTime startDate, LocalDateTime endDate);*/
   @Query("SELECT p FROM Price p WHERE p.productId = :productId AND p.brandId = :brandId " +
           "AND :applicationDate BETWEEN p.startDate AND p.endDate")
   List<Price> findApplicablePrice(@Param("productId") Long productId,
                                   @Param("brandId") Integer brandId,
                                   @Param("applicationDate") LocalDateTime applicationDate);
}
