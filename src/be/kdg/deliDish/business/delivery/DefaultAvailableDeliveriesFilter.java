package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.user.Courier;

import java.util.Collection;

public class DefaultAvailableDeliveriesFilter implements DeliveriesFilter {


	@Override
	public boolean select(Order order, Courier courier) {
		return order.isAvailable();
	}

	@Override
	public long getLimit() {
		return 3;
	}


}
