package com.speed_liv.menu.infrastructure.json;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.context.annotation.Profile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import com.speed_liv.menu.model.entity.Restaurant;
import com.speed_liv.menu.model.repository.RestaurantRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Implémentation du repository qui lit les restaurants depuis un fichier JSON
 */
@Repository
@Profile("json")
public class JsonRestaurantRepository implements RestaurantRepository {

    private final ObjectMapper objectMapper;

    public JsonRestaurantRepository() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<Restaurant> findAll() {
        try (InputStream is = getClass().getResourceAsStream("/restaurants.json")) {
            if (is == null) {
                throw new RuntimeException("Le fichier restaurants.json est introuvable !");
            }
            // Convertit le JSON en liste de Restaurant
            return objectMapper.readValue(is, new TypeReference<List<Restaurant>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la lecture du fichier JSON", e);
        }
    }
}
