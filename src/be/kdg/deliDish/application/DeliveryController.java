package be.kdg.deliDish.application;


import be.kdg.deliDish.business.OrderService;
import be.kdg.deliDish.business.RestoService;
import be.kdg.deliDish.business.UserService;
import be.kdg.deliDish.business.delivery.AvailableDeliveriesSelector;
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
    // Orchestration classes
    private OrderService orderService;
    private RestoService restoService;
    private UserService userService;


    public DeliveryController() {
        orderService = new OrderService();
        restoService = new RestoService();
        userService = new UserService();
    }


    /**
     * Sets the sessionUser
     *
     * @param appUser
     */
    public void setAppUser(Courier appUser) {
        this.appUser = appUser;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public UserService getUserService() {
        return userService;
    }

    public RestoService getRestoCatalog() {
        return restoService;
    }

    public void addOrder(Order o) {
        orderService.addOrder(o);
    }

    public Collection<Order> getAvailableDeliveries(AvailableDeliveriesSelector ads) {

        return orderService.getAvailableDeliveries(appUser);
    }

    public void selectDelivery(int orderId) {
        orderService.assignOrder(orderId, appUser);
        userService.assignOrderAcceptedPoints(appUser);
        appUser.setAvailable(false);
    }

    public void registerDeliveryPickup(int orderId) {
        Order o = orderService.registerOrderPickup(orderId);
        if (orderService.isOnTimePickup(o)) {
            userService.addOnTimePickupPoints(appUser);
        } else {
            userService.deductLatePickupPoints(appUser);
        }
    }

    public void registerSuccesfullDelivery(int deliveryNr) {
        //TODO: Complete use case deliver order event registerSuccesfullDelivery
        //Makes a new orderEvent, DeliveryPoints added, sets Courier available
    }

    public void getDeliveryPointsTotal() {

    }

    public void addCourier(Courier courier) {
        userService.addCourier(courier);
    }

    public void addCustomer(Customer customer) {
        userService.addCustomer(customer);
    }

    public void addResto(Restaurant restaurant) {
        restoService.addResto(restaurant);
    }

}
