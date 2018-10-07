package be.kdg.deliDish.business;

import be.kdg.deliDish.business.domain.courier.Courier;
import be.kdg.deliDish.business.domain.order.Order;

import java.util.Collection;

public interface AvailableDeliveriesService {

    Collection<Order> getAvailableDeliveries(Courier courier);
}
