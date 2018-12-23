package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.domain.order.Order;
import be.kdg.deliDish.domain.order.OrderState;
import be.kdg.deliDish.domain.user.Courier;
import be.kdg.deliDish.business.DistanceManager;
import be.kdg.deliDish.business.DistanceApiManager;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class BelgianAvailableDeliveriesFilter implements DeliveriesFilter {
	private static final int COURIER_SPEED=15;
// TODO moving the distancecalculator to the service level, implies moving the filter to the service level, with a dependency on the distanceAPIManager
//    and the orderrepo (the entire selection can not happen in the order repo anymore

	public boolean select(Order order, Courier courier) {
		DistanceManager rideToRestaurant = new DistanceApiManager(courier.getCurrentPosition(), order.getPosition(), 60/COURIER_SPEED);
		return order.hasCurrentState(OrderState.ORDER_PLACED)
			&& order.getProductionDateTime()
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
