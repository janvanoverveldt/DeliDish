package be.kdg.hiFresh.domain;

import java.util.List;

public class Dish {
    private String name;
    private String description;
    private float price;
    private List<Allergen> allergens;
    private int productionTime;
    private int maximumDeliveryTime;
}
