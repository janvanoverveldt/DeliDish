package be.kdg.deliDish.business.domain.restaurant;

import java.io.Serializable;
import java.util.List;

//TODO Je mag zaken toevoegen aan deze klasse. Bestaande attributen en methodes wijzigen doe je beter niet.
public class Dish implements Serializable {
    private String name;
    private String description;
    private double price;
    private List<Allergen> allergens;
    private int productionTime;
    private int maximumDeliveryTime;
    private Restaurant restaurant;

    public Dish(String name, String description, double price, List<Allergen> allergens, int productionTime, int maximumDeliveryTime, Restaurant restaurant) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.allergens = allergens;
        this.productionTime = productionTime;
        this.maximumDeliveryTime = maximumDeliveryTime;
        this.restaurant = restaurant;
        this.restaurant.addDish(this);
    }

}
