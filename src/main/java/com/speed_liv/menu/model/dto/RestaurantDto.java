package com.speed_liv.menu.model.dto;

import java.util.List;

public class RestaurantDto {
    private Long id;
    private String name;
    private List<PlatDto> plats;

    public RestaurantDto() {}

    public RestaurantDto(Long id, String name, List<PlatDto> plats) {
        this.id = id;
        this.name = name;
        this.plats = plats;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<PlatDto> getPlats() { return plats; }
    public void setPlats(List<PlatDto> plats) { this.plats = plats; }
}
