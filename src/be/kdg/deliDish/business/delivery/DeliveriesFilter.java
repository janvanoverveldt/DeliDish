package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.user.Courier;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public interface DeliveriesFilter {

    boolean select(Order order, Courier courier);

    long getLimit();

    Comparator<Order> orderBy();

}
