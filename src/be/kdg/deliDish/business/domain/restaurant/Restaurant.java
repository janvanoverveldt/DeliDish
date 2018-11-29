package be.kdg.deliDish.business.domain.restaurant;


import be.kdg.deliDish.business.domain.user.Partner;
import be.kdg.foundation.contact.Adress;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO Je mag zaken toevoegen aan deze klasse. Bestaande attributen en methodes wijzigen doe je beter niet.
public class Restaurant implements Serializable {
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
