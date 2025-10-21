package com.speed_liv.menu.model.repository;

import com.speed_liv.menu.model.entity.Restaurant;
import java.util.List;

/**
 * Interface du repository pour les restaurants
 * Définie dans la couche Domain / Model
 */
public interface RestaurantRepository {

    /**
     * Récupère la liste de tous les restaurants avec leurs plats
     * @return liste des restaurants
     */
    List<Restaurant> findAll();
}
