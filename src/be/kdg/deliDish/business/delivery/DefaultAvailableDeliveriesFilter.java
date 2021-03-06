package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.domain.order.Order;
import be.kdg.deliDish.domain.order.OrderState;
import be.kdg.deliDish.domain.user.Courier;

import java.util.Comparator;

public class DefaultAvailableDeliveriesFilter implements DeliveriesFilter {


	@Override
	public boolean select(Order order, Courier courier) {
		return order.hasCurrentState(OrderState.ORDER_PLACED);
	}

	@Override
	public long getLimit() {
		return 3;
	}

	@Override
	public Comparator<Order> orderBy() {
		return Comparator.comparing(Order::getOrderPlacedDateTime);
	}
}
