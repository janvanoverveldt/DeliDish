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

    // TODO (Week 3-4): Methode implementeren (wordt gebruikt om data beschikbaar te stellen)
    public void addOrder(Order o) {

    }

    // TODO (Week 3-4): Methode implementeren (wordt gebruikt om data beschikbaar te stellen)
    public void addCourier(Courier courier) {
    }

    // TODO (Week 3-4): Methode implementeren (wordt gebruikt om data beschikbaar te stellen)
    public void addCustomer(Customer customer) {

    }

    // TODO (Week 3-4): Methode implementeren (wordt gebruikt om data beschikbaar te stellen)
    public void addResto(Restaurant restaurant) {

    }

    // TODO (Week 3-4): Methode implementeren (wordt gebruikt om data beschikbaar te stellen
    public Collection<Courier> getCouriers() {
        return null;
    }

    // TODO (Week 3-5): Methode implementeren (wordt gebruikt in een test)
    public int getDeliveryPointsTotal(Courier c) {
        return 0;
    }

    // TODO (Week 3-4): Dit is DE methode die in opdracht 3 moet uitgewerkt worden comform de interactiediagrammen die ook worden uitgewerkt.
    // TODO (Week 4-5): In opdracht 4 moet de implementatie van deze methode aangepast worden (zie beschrijving)
    public Collection<Order> getAvailableDeliveries() {

        return null;
    }

    // TODO (Week 4-5): Deze methode moet ontworpen worden in opdracht 4. Code en diagrammen moet consistent zijn.
    public Order selectDelivery(int orderId) {
        return null;
    }

    // TODO (Week 4-5): Optioneel: Deze methode kan ontworpen worden in opdracht 4.
    public Order registerDeliveryPickup(int orderId) {
        return null;
    }

    // TODO (Week 4-5): Optioneel: Deze methode kan ontworpen worden in opdracht 4.
    public Order registerSuccesfullDelivery(int orderId) {
        return null;
    }



}
