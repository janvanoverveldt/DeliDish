package be.kdg.deliDish.business;

import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.user.Courier;

import java.util.Collection;

public interface AvailableDeliveriesService {

    Collection<Order> getAvailableDeliveries(Courier courier);
}
