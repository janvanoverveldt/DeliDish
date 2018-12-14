package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.user.Courier;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BelgianAvailableDeliveriesFilter implements DeliveriesFilter {


	public boolean select(Order order, Courier courier) {
		Ride rideToRestaurant = new Ride(courier.getCurrentPosition(), order.getPosition(), 4);
		return order.isAvailable()
			&& order.getOrderPlacedDateTime()
				.plus(order.getPreparationTime(), ChronoUnit.MINUTES)
				.isAfter(LocalDateTime.now().plus((int) rideToRestaurant.getDuration(), ChronoUnit.MINUTES))
			&& (order.getAverageCourierDeliveryPoints() <= courier.getDeliveryPointsTotal()
				|| order.getOrderPlacedDateTime().plusMinutes(5).isBefore(LocalDateTime.now()));
	}


	@Override
	public long getLimit() {
		return -1;
	}
}
