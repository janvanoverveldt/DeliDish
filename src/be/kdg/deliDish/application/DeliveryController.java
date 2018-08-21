package be.kdg.deliDish.application;


import be.kdg.deliDish.domain.business.AvailableDeliveriesService;
import be.kdg.deliDish.domain.business.CourierCatalog;
import be.kdg.deliDish.domain.business.OrderCatalog;
import be.kdg.deliDish.domain.courier.Courier;
import be.kdg.deliDish.domain.order.Order;

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


    public DeliveryController() {
        orderCatalog = new OrderCatalog();
        courierCatalog = new CourierCatalog();
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
    }

    public void registerDeliveryPickup(int deliveryNr) {
        //TODO: Complete use case deliver order event registerDeliveryPickup
    }

    public void registerSuccesfullDelivery(int deliveryNr) {
        //TODO: Complete use case deliver order event registerSuccesfullDelivery
    }

    public void getDeliveryPointsTotal() {

    }
}
