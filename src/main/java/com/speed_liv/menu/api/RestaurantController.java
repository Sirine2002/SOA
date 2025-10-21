package com.speed_liv.menu.api;

import com.speed_liv.menu.model.entity.Restaurant;
import com.speed_liv.menu.service.RestaurantService;
import com.speed_liv.menu.model.dto.PlatDto;
import com.speed_liv.menu.model.dto.RestaurantDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Contrôleur REST pour la gestion des restaurants.
 * Endpoint : GET /restaurants
 */
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    /**
     * Endpoint GET /restaurants
     * Retourne la liste des restaurants avec leurs plats
     */
    @GetMapping("/restaurants")
    public List<RestaurantDto> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();

        // Transformation des entités en DTOs
        return restaurants.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * Méthode utilitaire pour convertir une entité Restaurant en DTO
     */
    private RestaurantDto convertToDto(Restaurant restaurant) {
        List<PlatDto> platDtos = restaurant.getPlats().stream()
               .map(plat -> new PlatDto(plat.getId(), plat.getName(), plat.getPrice(), restaurant.getId()))
                .collect(Collectors.toList());

        return new RestaurantDto(restaurant.getId(), restaurant.getName(), platDtos);
    }
}
