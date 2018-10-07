package be.kdg.deliDish.business.domain.restaurant;


import be.kdg.foundation.contact.Adress;
import be.kdg.foundation.contact.Position;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private Adress adres;
    private List<OpeningPeriod> openingShedule = new ArrayList<>();
    private List<Dish> dishes = new ArrayList<>();

    public Restaurant(String name, Adress adres) {
        this.name = name;
        this.adres = adres;

    }

    public void addOpening(OpeningPeriod opening) {
        openingShedule.add(opening);
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public Dish getDish(int i) {
        return dishes.get(i);
    }

    public Position getPosition() {
        return adres.getPosition();
    }
}