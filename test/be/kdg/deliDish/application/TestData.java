package be.kdg.deliDish.application;

import be.kdg.deliDish.business.domain.courier.Courier;
import be.kdg.deliDish.business.domain.customer.Customer;
import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.order.OrderEvent;
import be.kdg.deliDish.business.domain.order.OrderLine;
import be.kdg.deliDish.business.domain.order.OrderState;
import be.kdg.deliDish.business.domain.restaurant.Allergen;
import be.kdg.deliDish.business.domain.restaurant.Dish;
import be.kdg.deliDish.business.domain.restaurant.OpeningPeriod;
import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.foundation.contact.Adress;
import be.kdg.foundation.contact.ContactInfo;
import be.kdg.foundation.contact.Gemeente;
import be.kdg.foundation.contact.Position;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Deze klasse bevat test data.
 * Zij mag enkel gebruikt worden bij het initialiseren van het systeem,
 * om de test data in het systeem te stoppen
 * Bij het uitvoeren van de tests worden dan de data in het systeem gebruikt,
 * en mag deze klasse niet meer aangesproken worden.
 *
 * Het is niet de bedoeling deze klasse aan te passen. Als je objecten toch wezenlijk
 * verschillen dan mag je dit wel aanpassen maar je moet er wel voor zorgen dat
 * de testdata inhoudelijk gelijk blijft.
 *
 * @author Jan Van Overveldt.
 */
class TestData {
    private List<Order> orders = new ArrayList<>();

    private List<Restaurant> restos = new ArrayList<>();
    private List<Courier> couriers = new ArrayList<>();
    private List<Gemeente> gemeentes = new ArrayList<>();
    private Customer customer;

    // Hieronder wordt de testdata opgezet.

    TestData() {
        makeGemeentes();
        makeRestaurants();
        makeCouriers();
        makeCustomer();
        maakOrders();
    }

    /**
     * Maakt de Antwerpse districten aan om alles te testen
     */
    private void makeGemeentes() {
        gemeentes.add(new Gemeente("2000", "Antwerpen"));
        gemeentes.add(new Gemeente("2600", "Berchem"));
        gemeentes.add(new Gemeente("2040", "BerendrechtZandvlietLillo"));
        gemeentes.add(new Gemeente("2140", "Borgerhout"));
        gemeentes.add(new Gemeente("2100", "Deurne"));
        gemeentes.add(new Gemeente("2180", "Ekeren"));
        gemeentes.add(new Gemeente("2660", "Hoboken"));
        gemeentes.add(new Gemeente("2170", "Merksem"));
        gemeentes.add(new Gemeente("2610", "Wilrijk"));
    }
    private void makeRestaurants() {

        Restaurant r1 = new Restaurant("Didier's Place", new Adress("Tolstraat", "30", new Gemeente("2000", "Antwerpen"), new Position(51.210150, 4.397607)));
        OpeningPeriod ro = new OpeningPeriod(DayOfWeek.FRIDAY, LocalTime.of(11, 30), LocalTime.of(23, 30));
        r1.addOpening(ro);
        List<Dish> dishes = new ArrayList<>();
        ArrayList<Allergen> allergens = new ArrayList<>();
        allergens.add(Allergen.Eggs);
        new Dish("Ravioli Summervides", "Ravioli met rucola & Parmezaan, witte asperges, eigeelcrème, jus van Parmezaan (Vegetarisch)", 17.5, allergens, 30, 20, r1);
        restos.add(r1);
    }

    private void makeCouriers() {
        Courier courierThatInteracts = new Courier("Frits", "Den Dichterbij", new ContactInfo(new Adress("Volkstraat", "10", gemeentes.get(1), new Position(51.211759, 4.396674)), "frits@kdg.be", "032545856"), new Position(51.219090, 4.399394));
        Courier courierFar1 = new Courier("Frats", "Van Verre", new ContactInfo(new Adress("Nationalestraat", "10", gemeentes.get(1), new Position(51.211759, 4.396674)), "frats@kdg.be", "05652456"), new Position(51.220717, 4.471559));
        couriers.add(courierThatInteracts);
        couriers.add(courierFar1);
        //TODO: Add unavailable couriers
        //TODO: The couriers must have DeliveryPoints.
        //TODO: One of the orders must be not visible because of he has less than average points than the other available couriers.

    }

    private void makeCustomer() {
        Adress deliveryAdress1 = new Adress("Nationalestraat", "10", gemeentes.get(0), new Position(51.214236, 4.398242));
        Adress deliveryAdress2 = new Adress("Gravinstraat", "19", gemeentes.get(3), new Position(51.215090, 4.443523));
        List<Adress> delAdresses = new ArrayList<>();
        delAdresses.add(deliveryAdress1);
        delAdresses.add(deliveryAdress2);
        customer = new Customer(new ContactInfo(deliveryAdress1, "lievefransen@gmail.com", "048562675"), "Lieve", "Fransen", delAdresses);
    }

    /**
     * Maakt verschillende orders aan
     */
    private void maakOrders() {
        OrderLine ol = new OrderLine(restos.get(0).getDish(0), 4, "No remark");
        List<OrderLine> ols = new ArrayList<>();
        ols.add(ol);
        OrderEvent event = new OrderEvent(LocalDateTime.now().minus(3, ChronoUnit.MINUTES), OrderState.ORDER_PLACED, "");
        Order o = new Order(ols, customer.getDeliveryAdresses().get(0), "Op de bovenste bel drukken (hard doordrukken)", customer);
        o.addEvent(event);
        orders.add(o);
    }

    public List<Order> getOrders() {
        return orders;
    }


    public List<Restaurant> getRestos() {
        return restos;
    }

    public List<Courier> getCouriers() {
        return couriers;
    }

    public Customer getCustomer() {
        return customer;
    }
}