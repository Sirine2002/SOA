package com.speed_liv.menu.service;

import com.speed_liv.menu.model.entity.Restaurant;
import com.speed_liv.menu.model.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    /**
     * Retourne la liste des restaurants avec leurs plats
     */
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
