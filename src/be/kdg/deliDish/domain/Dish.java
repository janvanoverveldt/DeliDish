package be.kdg.deliDish.domain;

import java.util.List;

public class Dish {
    private String name;
    private String description;
    private double price;
    private List<Allergen> allergens;
    private int productionTime;
    private int maximumDeliveryTime;

    public Dish(String name, String description, double price, List<Allergen> allergens, int productionTime, int maximumDeliveryTime) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.allergens = allergens;
        this.productionTime = productionTime;
        this.maximumDeliveryTime = maximumDeliveryTime;
    }
}
