package be.kdg.deliDish.domain.business;

import be.kdg.deliDish.domain.courier.Courier;
import be.kdg.deliDish.domain.order.Order;

import java.util.Collection;

public interface AvailableDeliveriesService {

    Collection<Order> getAvailableDeliveries(Courier courier);
}
