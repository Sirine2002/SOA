package com.speed_liv.menu.infrastructure.jpa;

import com.speed_liv.menu.model.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA pur pour H2
 * findAll(), save(), delete() sont fournis par JpaRepository
 */
@Repository
public interface JpaRestaurantJpaRepository extends JpaRepository<Restaurant, Long> {
    // Aucune méthode supplémentaire nécessaire pour l'instant
}
