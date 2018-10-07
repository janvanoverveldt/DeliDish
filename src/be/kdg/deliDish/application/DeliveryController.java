package be.kdg.deliDish.application;


import be.kdg.deliDish.business.*;
import be.kdg.deliDish.business.domain.courier.Courier;
import be.kdg.deliDish.business.domain.customer.Customer;
import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.restaurant.Restaurant;

import java.util.Collection;

/**
 * @author Jan Van Overveldt.
 */
// Dit is de controllerklasse van het BackOffice subsysteem
public class DeliveryController {
    //Session Info
    private Courier appUser;
    // Orchestration classes
    private OrderCatalog orderCatalog;
    private CourierCatalog courierCatalog;
    private RestoCatalog restoCatalog;
    private CustomerCatalog customerCatalog;


    public DeliveryController() {
        orderCatalog = new OrderCatalog();
        courierCatalog = new CourierCatalog();
        restoCatalog = new RestoCatalog();
        customerCatalog = new CustomerCatalog();
    }

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public CourierCatalog getCourierCatalog() {
        return courierCatalog;
    }

    public void addOrder(Order o) {
        orderCatalog.addOrder(o);
    }

    public Collection<Order> getAvailableDeliveries(AvailableDeliveriesService ads) {

        return ads.getAvailableDeliveries(appUser);
    }

    public void selectDelivery(int deliveryNr) {
        //TODO: Complete use case deliver order event deliverySelection
        // Makes a new orderEvent and sets courier unavailable
    }

    public void registerDeliveryPickup(int deliveryNr) {
        //TODO: Complete use case deliver order event registerDeliveryPickup
        // Makes a new orderEvent and if in time DeliveryPoints are added.
    }

    public void registerSuccesfullDelivery(int deliveryNr) {
        //TODO: Complete use case deliver order event registerSuccesfullDelivery
        //Makes a new orderEvent, DeliveryPoints added, sets Courier available
    }

    public void getDeliveryPointsTotal() {

    }

    public void addCourier(Courier courier) {
        courierCatalog.addCourier(courier);
    }

    public void addCustomer(Customer customer) {
        customerCatalog.addCustomer(customer);
    }

    public void addResto(Restaurant restaurant) {
        restoCatalog.addResto(restaurant);
    }

    public RestoCatalog getRestoCatalog() {
        return restoCatalog;
    }

    public void setAppUser(Courier appUser) {
        this.appUser = appUser;
    }
}
