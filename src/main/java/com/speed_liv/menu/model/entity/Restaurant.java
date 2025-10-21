package com.speed_liv.menu.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants") // nom de la table dans H2
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment pour H2
    private Long id;

    private String name;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Plat> plats;

    public Restaurant() {}

    public Restaurant(Long id, String name, List<Plat> plats) {
        this.id = id;
        this.name = name;
        this.plats = plats;
        if (plats != null) plats.forEach(p -> p.setRestaurant(this));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Plat> getPlats() { return plats; }
    public void setPlats(List<Plat> plats) {
        this.plats = plats;
        if (plats != null) plats.forEach(p -> p.setRestaurant(this));
    }
}
