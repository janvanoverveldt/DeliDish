package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.domain.order.Order;
import be.kdg.deliDish.domain.order.OrderState;
import be.kdg.deliDish.domain.user.Courier;
import be.kdg.foundation.contact.Move;
import be.kdg.foundation.contact.Ride;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class BelgianAvailableDeliveriesFilter implements DeliveriesFilter {
	private static final int COURIER_SPEED=15;


	public boolean select(Order order, Courier courier) {
		Move rideToRestaurant = new Ride(courier.getCurrentPosition(), order.getPosition(), 60/COURIER_SPEED);
		return order.hasCurrentState(OrderState.ORDER_PLACED)
			&& order.getOrderPlacedDateTime()
				.plus(order.getProductionTime(), ChronoUnit.MINUTES)
				.isAfter(LocalDateTime.now().plus((int) rideToRestaurant.getDuration(), ChronoUnit.MINUTES))
			&& (order.getAverageCourierDeliveryPoints() <= courier.getDeliveryPointsTotal()
				|| order.getOrderPlacedDateTime().plusMinutes(5).isBefore(LocalDateTime.now()));
	}


	@Override
	public long getLimit() {
		return -1;
	}

	@Override
	public Comparator<Order> orderBy() {
		return null;
	}
}
