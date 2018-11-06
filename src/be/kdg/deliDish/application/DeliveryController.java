package be.kdg.deliDish.application;


import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.deliDish.business.domain.user.Customer;

import java.util.Collection;

/**
 * @author Jan Van Overveldt.
 */
// Dit is de controllerklasse van het BackOffice subsysteem
public class DeliveryController {
    //Session Info
    private Courier appUser;


    public Courier getAppUser() {
        return appUser;
    }

    /**
     * Sets the sessionUser
     *
     * @param appUser
     */
    public void setAppUser(Courier appUser) {
        this.appUser = appUser;
    }

    // TODO Opdracht 3: Methode implementeren (wordt gebruikt om data beschikbaar te stellen
    public void addOrder(Order o) {

    }

    // TODO Opdracht 3: Methode implementeren (wordt gebruikt om data beschikbaar te stellen
    public void addCourier(Courier courier) {
    }

    // TODO Opdracht 3: Methode implementeren (wordt gebruikt om data beschikbaar te stellen
    public void addCustomer(Customer customer) {

    }

    // TODO Opdracht 3: Methode implementeren (wordt gebruikt om data beschikbaar te stellen
    public void addResto(Restaurant restaurant) {

    }

    // TODO Opdracht 3: Methode implementeren (wordt gebruikt om data beschikbaar te stellen
    public Collection<Courier> getCouriers() {
        return null;
    }

    // TODO Opdracht 3: Methode implementeren (wordt gebruikt in een test)
    public int getDeliveryPointsTotal(Courier c) {
        return 0;
    }

    // TODO Opdracht 3: Dit is DE methode die in opdracht 3 moet uitgewerkt worden comform de interactiediagrammen die ook worden uitgewerkt.
    // TODO Opdracht 4: In opdracht 4 moet de implementatie van deze methode aangepast worden (zie beschrijving)
    public Collection<Order> getAvailableDeliveries() {

        return null;
    }

    // TODO Opdracht 4: Deze methode moet ontworpen worden in opdracht 4. Code en diagrammen moet consistent zijn.
    public Order selectDelivery(int orderId) {
        return null;
    }

    // TODO Opdracht 4: Deze methode moet ontworpen worden in opdracht 4. Code en diagrammen moet consistent zijn.
    public Order registerDeliveryPickup(int orderId) {
        return null;
    }

    // TODO Opdracht 4: Deze methode moet ontworpen worden in opdracht 4. Code en diagrammen moet consistent zijn.
    public Order registerSuccesfullDelivery(int orderId) {
        return null;
    }



}
