package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.user.Courier;

import java.util.Collection;

public interface DeliveriesFilter {

    Collection<Order> getAvailableDeliveries(Courier courier);
}
