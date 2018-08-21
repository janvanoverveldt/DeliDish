package be.kdg.deliDish.domain.restaurant;


import be.kdg.foundation.contact.Adress;

import java.util.List;

public class Restaurant {
    private String name;
    private Adress adres;
    private List<RestaurantOpening> openingShedule;
    private List<Dish> dishes;

    public Restaurant(String name, Adress adres) {
        this.name = name;
        this.adres = adres;
    }

    public void addOpening(RestaurantOpening opening) {
        openingShedule.add(opening);

    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public Dish getDish(int i) {
        return dishes.get(i);
    }
}
