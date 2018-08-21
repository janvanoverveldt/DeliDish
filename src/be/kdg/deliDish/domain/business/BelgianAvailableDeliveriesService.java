package be.kdg.deliDish.domain.business;

import be.kdg.deliDish.domain.courier.Courier;
import be.kdg.deliDish.domain.order.Order;

import java.util.Collection;

public class BelgianAvailableDeliveriesService implements AvailableDeliveriesService {
    private CourierCatalog cc;
    private OrderCatalog oc;
    private Courier requestingCourier;

    public BelgianAvailableDeliveriesService(CourierCatalog cc, OrderCatalog oc) {
        this.cc = cc;
        this.oc = oc;
    }

    public void setCc(CourierCatalog cc) {
        this.cc = cc;
    }

    public void setOc(OrderCatalog oc) {
        this.oc = oc;
    }

    /**
     * Gives a list of deliveries available for the requesting courier. The requesting courier as well ass the available orders and couriers must be set before running this method.
     */
    @Override
    public Collection<Order> getAvailableDeliveries(Courier courier) {

        return null;
    }
}
