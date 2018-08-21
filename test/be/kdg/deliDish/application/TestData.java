package be.kdg.deliDish.application;

import be.kdg.deliDish.domain.order.Order;
import be.kdg.deliDish.domain.order.OrderLine;
import be.kdg.deliDish.domain.restaurant.Allergen;
import be.kdg.deliDish.domain.restaurant.Dish;
import be.kdg.deliDish.domain.restaurant.Restaurant;
import be.kdg.deliDish.domain.restaurant.RestaurantOpening;
import be.kdg.foundation.contact.Adress;
import be.kdg.foundation.contact.Gemeente;
import be.kdg.foundation.contact.Position;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Deze klasse bevat test data.
 * Zij mag enkel gebruikt worden bij het initialiseren van het systeem,
 * om de test data in het systeem te stoppen
 * Bij het uitvoeren van de tests worden dan de data in het systeem gebruikt,
 * en mag deze klasse niet meer aangesproken worden.
 *
 * @author Jan Van Overveldt.
 */
class TestData {
    private List<Order> orders = new ArrayList<>();
    private List<Dish> dishes = new ArrayList<>();
    private List<Restaurant> restos = new ArrayList<>();

    // Hieronder wordt de testdata opgezet.

    TestData() {
        makeRestaurants();
        makeDishes();
        maakOrders();
    }

    private void makeRestaurants() {
        Restaurant r1 = new Restaurant("Didier's Place", new Adress("Tolstraat", "30", new Gemeente("2000", "Antwerpen"), new Position(51.210150, 4.397607)));
        RestaurantOpening ro = new RestaurantOpening(DayOfWeek.FRIDAY, LocalTime.of(11, 30), LocalTime.of(23, 30));
        r1.addOpening(ro);
        r1.addDish(dishes.get(0));
    }

    public List<Order> getOrders() {
        return orders;
    }

    protected List<Dish> getDishes() {
        return dishes;
    }

    private void maakOrders() {
        OrderLine ol = new OrderLine(restos.get(0).getDish(0), 4, "No remark");
    }

    private void makeDishes() {
        ArrayList<Allergen> allergens = new ArrayList<>();
        allergens.add(Allergen.Eggs);
        dishes.add(new Dish("Ravioli Summervides", "Ravioli met rucola & Parmezaan, witte asperges, eigeelcrème, jus van Parmezaan (Vegetarisch)", 17.5, allergens, 30, 20));
    }


}