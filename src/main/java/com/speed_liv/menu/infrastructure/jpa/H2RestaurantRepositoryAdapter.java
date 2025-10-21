package com.speed_liv.menu.infrastructure.jpa;

import com.speed_liv.menu.model.entity.Restaurant;
import com.speed_liv.menu.model.repository.RestaurantRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Adapter qui permet à H2 de respecter l'interface RestaurantRepository
 */
@Repository
@Profile("h2") // actif uniquement pour le profil H2
public class H2RestaurantRepositoryAdapter implements RestaurantRepository {

    private final JpaRestaurantJpaRepository jpaRepository;

    public H2RestaurantRepositoryAdapter(JpaRestaurantJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Restaurant> findAll() {
        return jpaRepository.findAll();
    }
}
