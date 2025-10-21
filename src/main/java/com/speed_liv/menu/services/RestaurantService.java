package com.speed_liv.menu.service;

import com.speed_liv.menu.infrastructure.json.JsonRestaurantRepository;
import com.speed_liv.menu.model.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final JsonRestaurantRepository restaurantRepository;

    public RestaurantService(JsonRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    /**
     * Retourne la liste des restaurants avec leurs plats
     */
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
