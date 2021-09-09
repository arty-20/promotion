package com.fullstack.promotion.repository;

import com.fullstack.promotion.model.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author arturo
 */
public interface PromocionRepository extends JpaRepository<Promocion, Long> {

    @Query("select p.message from Promocion p where p.id = 1")
    String getUniqueMessage();
}
