package be.kdg.deliDish.business.domain.restaurant;


import be.kdg.deliDish.business.domain.user.Partner;
import be.kdg.foundation.contact.Adress;
import be.kdg.foundation.contact.Position;

import java.util.*;

public class Restaurant {
    private String name;
    private Adress adres;
    private List<OpeningPeriod> openingShedule = new ArrayList<>();
    private List<Dish> dishes = new ArrayList<>();
    private Partner partner;

    public Restaurant(String name, Adress adres, Partner partner) {
        this.name = name;
        this.adres = adres;
        this.partner = partner;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Restaurant that = (Restaurant) o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
