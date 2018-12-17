package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.domain.order.Order;
import be.kdg.deliDish.domain.user.Courier;

import java.util.Comparator;

public interface DeliveriesFilter {

    boolean select(Order order, Courier courier);

    long getLimit();

    Comparator<Order> orderBy();

}
