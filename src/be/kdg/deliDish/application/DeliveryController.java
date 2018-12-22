package be.kdg.deliDish.application;


import be.kdg.deliDish.business.*;
import be.kdg.deliDish.domain.order.Order;
import be.kdg.deliDish.domain.restaurant.Restaurant;
import be.kdg.deliDish.domain.user.*;

import java.util.Collection;

import static be.kdg.deliDish.domain.user.DeliveryPointEvent.DeliveryPointEventType.*;

/**
 * @author Jan Van Overveldt.
 */
// Dit is de controllerklasse van het BackOffice subsysteem
public class DeliveryController {
	//Session Info
	private Courier appUser;
	// Orchestration classes
	private OrderManager orderService;
	private RestoManager restoService;
	private UserManager userService;

	public DeliveryController(OrderManager os, UserManager is, RestoManager rs) {
		orderService = os;
		restoService = rs;
		userService = is;
	}

	public Courier getAppUser() {
		return appUser;
	}

	/**
	 * Sets the sessionUser
	 *
	 * @param appUser
	 */
	public void setAppUser(Courier appUser) {
		this.appUser = appUser;
	}

	public void addOrder(Order o) {
		orderService.addOrder(o);
	}

	public void addCourier(Courier courier) {
		userService.addCourier(courier);
	}

	public void addCustomer(Customer customer) {
		userService.addCustomer(customer);
	}

	public void addResto(Restaurant restaurant) {
		restoService.addResto(restaurant);
	}


	public Collection<Order> getAvailableDeliveries() {
		return orderService.getAvailableDeliveries(appUser);
	}

	public Order selectDelivery(int orderId) {
		Order o = orderService.assignOrder(orderId, appUser);
		userService.assignPoints(appUser, ORDER_ACCEPTED);
		appUser.setAvailable(false);
		return o;
	}

	public Order registerDeliveryPickup(int orderId) {
		Order o = orderService.registerOrderPickup(orderId);
		userService.assignPoints(
			appUser,
			orderService.isOnTimePickup(o) ? ORDER_PICKUP_ONTIME : ORDER_PICKUP_LATE);
		return o;
	}

	public Order registerSuccesfullDelivery(int orderId) {
		Order o = orderService.registerDelivery(orderId);
		userService.assignPoints(appUser,
			orderService.isOnTimeDelivery(o) ? ORDER_PICKUP_ONTIME : ORDER_PICKUP_LATE);
		return o;
		//TODO: Complete use case deliver order event registerSuccesfullDelivery
		//Makes a new orderEvent, DeliveryPoints added, sets Courier available
	}


}
