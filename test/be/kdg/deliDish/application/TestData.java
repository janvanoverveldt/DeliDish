package be.kdg.deliDish.application;

import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.order.OrderEvent;
import be.kdg.deliDish.business.domain.order.OrderLine;
import be.kdg.deliDish.business.domain.order.OrderState;
import be.kdg.deliDish.business.domain.restaurant.Allergen;
import be.kdg.deliDish.business.domain.restaurant.Dish;
import be.kdg.deliDish.business.domain.restaurant.OpeningPeriod;
import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.deliDish.business.domain.user.Customer;
import be.kdg.deliDish.business.domain.user.DeliveryPointEvent;
import be.kdg.deliDish.business.domain.user.Partner;
import be.kdg.foundation.contact.Adress;
import be.kdg.foundation.contact.City;
import be.kdg.foundation.contact.ContactInfo;
import be.kdg.foundation.contact.Position;
import be.kdg.foundation.financial.RekeningNummer;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//TODO (Week 3-4) Bekijk welke testdata aangemaakt wordt en probeer te begrijpen
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
    private List<City> cities = new ArrayList<>();
    private Customer customer;

    // Hieronder wordt de testdata opgezet.

    TestData() {
        makeCitys();
        makeRestaurants();
        makeCouriers();
        makeCustomer();
        maakOrders();
    }

    /**
     * Maakt de Antwerpse districten aan om alles te testen
     */
    private void makeCitys() {
        cities.add(new City("2000", "Antwerpen", "Belgium"));
        cities.add(new City("2600", "Berchem", "Belgium"));
        cities.add(new City("2040", "BerendrechtZandvlietLillo", "Belgium"));
        cities.add(new City("2140", "Borgerhout", "Belgium"));
        cities.add(new City("2100", "Deurne", "Belgium"));
        cities.add(new City("2180", "Ekeren", "Belgium"));
        cities.add(new City("2660", "Hoboken", "Belgium"));
        cities.add(new City("2170", "Merksem", "Belgium"));
        cities.add(new City("2610", "Wilrijk", "Belgium"));
        cities.add(new City("90210", "Beverly Hills", "United States"));
    }
    private void makeRestaurants() {
        maakResto("Resto dat niet zo ver af is", new Position(51.210150, 4.397607));
        maakResto("Resto dat te ver af waardoor dishes niet dicht genoeg zijn", new Position(60, 10));

    }

    private void makeCouriers() {
        Courier courierThatInteracts = new Courier("Frits", "Den Dichterbij", new ContactInfo(new Adress("Volkstraat", "10", cities.get(1), new Position(51.211759, 4.396674)), "frits@kdg.be", "032545856"), new Position(51.219090, 4.399394), new Partner(new RekeningNummer("BE11111111111111111")));
        DeliveryPointEvent dpe = new DeliveryPointEvent(501, DeliveryPointEvent.DeliveryPointEventType.ORDER_PICKUP_ONTIME);
        courierThatInteracts.addPointEvent(dpe);
        couriers.add(courierThatInteracts);
        Courier courierWithOtherAlgoritm = new Courier("Frats", "Van UitAmerica", new ContactInfo(new Adress("BlaBla", "10", cities.get(9), new Position(51.211759, 4.396674)), "frits@kdg.be", "032545856"), new Position(51.219090, 4.399394), new Partner(new RekeningNummer("BE11111111111111111")));
        DeliveryPointEvent dpe2 = new DeliveryPointEvent(501, DeliveryPointEvent.DeliveryPointEventType.ORDER_PICKUP_ONTIME);
        couriers.add(courierWithOtherAlgoritm);

    }

    private void makeCustomer() {
        Adress deliveryAdress1 = new Adress("Nationalestraat", "10", cities.get(0), new Position(51.214236, 4.398242));
        Adress deliveryAdress2 = new Adress("Gravinstraat", "19", cities.get(3), new Position(51.215090, 4.443523));
        List<Adress> delAdresses = new ArrayList<>();
        delAdresses.add(deliveryAdress1);
        delAdresses.add(deliveryAdress2);
        customer = new Customer(new ContactInfo(deliveryAdress1, "lievefransen@gmail.com", "048562675"), "Lieve", "Fransen", delAdresses);
    }

    /**
     * Maakt verschillende orders aan
     */
    private void maakOrders() {
        maakOrder(restos.get(0).getDish(0), 3, OrderState.ORDER_PLACED, "Binnen eerste vijf minuten, maar courier heeft meer dan gemiddelde deliveryPoints", 500, 1);
        maakOrder(restos.get(0).getDish(0), 6, OrderState.ORDER_PLACED, "Na vijf minuten", 3000, 2);
        maakOrder(restos.get(0).getDish(0), 3, OrderState.ORDER_PLACED, "Courier te weinig delivery points", 3000, 3);
        maakOrder(restos.get(0).getDish(0), 6, OrderState.COURIER_ASSIGNED, "Status verkeerd", 500, 4);
        maakOrder(restos.get(1).getDish(0), 6, OrderState.ORDER_PLACED, "Resto te ver", 500, 5);

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

    public void maakOrder(Dish dish, long tijdGeleden, OrderState orderState, String orderTekst, int deliveryPoints, int orderId) {
        OrderLine ol = new OrderLine(dish, 4, "No remark");
        List<OrderLine> ols = new ArrayList<>();
        ols.add(ol);
        OrderEvent event = new OrderEvent(LocalDateTime.now().minus(tijdGeleden, ChronoUnit.MINUTES), orderState, "");
        Order o = new Order(ols, customer.getDeliveryAdresses().get(0), orderTekst + ": " + tijdGeleden + " min, " + orderState + ", " + deliveryPoints + " points", customer, orderId, deliveryPoints);
        o.addEvent(event);
        orders.add(o);
    }

    public void maakResto(String naam, Position position) {
        Restaurant r1 = new Restaurant(naam, new Adress(naam, String.valueOf(new Random().nextInt(100)), cities.get(0), position), new Partner(new RekeningNummer("BE58658963247896")));
        OpeningPeriod ro = new OpeningPeriod(DayOfWeek.FRIDAY, LocalTime.of(11, 30), LocalTime.of(23, 30));
        r1.addOpening(ro);
        List<Dish> dishes = new ArrayList<>();
        ArrayList<Allergen> allergens = new ArrayList<>();
        allergens.add(Allergen.Eggs);
        new Dish("Ravioli Summervides", "Ravioli met rucola & Parmezaan, witte asperges, eigeelcrème, jus van Parmezaan (Vegetarisch)", 17.5, allergens, 30, 20, r1);
        restos.add(r1);


    }
}