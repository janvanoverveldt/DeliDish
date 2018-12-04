package be.kdg.deliDish.business;

import be.kdg.deliDish.business.delivery.*;
import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.order.OrderEvent;
import be.kdg.deliDish.business.domain.order.OrderLine;
import be.kdg.deliDish.business.domain.order.OrderState;
import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.foundation.contact.Position;
import be.kdg.infra.MemoryRepository;

import java.time.LocalDateTime;
import java.util.*;

public class OrderService {
    private static int orerIdSequence = 0;
    private final MemoryRepository<Integer,Order> orderRepo = new MemoryRepository<>();
	private  AvailableDeliveriesStrategy deliveryStrategy;


	/**
     * Sequence for OrderIds
     *
     * @return newly generated orderId
     */
    public static int generateOrderId() {
        return orerIdSequence++;
    }



    /**
     * Returns deliveries that a specific courier can deliver. The selectionalgorithm depends on the country of the courier demanding the available deliveries.
     *
     * @param courier
     * @return
     */
    public Collection<Order> getAvailableDeliveries(Courier courier) {
        return deliveryStrategy.getAvailableDeliveries(courier);
    }

    public void addOrder(Order order) {
        orderRepo.put(order.getOrderID(),order);
    }


    /**
     * Gets all orders in de repository
     *
     * @return all available Orders in the repository
     */
    public Collection<Order> getOrders() {
        return orderRepo.entities();
    }

    public Collection<Order> getDeliverableOrders() {
        return orderRepo.findWhere(order -> order.getCurrentState() == OrderState.ORDER_PLACED);
    }

    public Position getDeliveryPosition(Order o) {
        return o.getDeliveryAdress().getPosition();
    }

    public Restaurant getResto(Order o) {
        return o.getOrderlines().get(0).getDish().getResto();
    }

    public Position getPosition(Order o) {
        return o.getOrderlines().get(0).getDish().getResto().getPosition();
    }

    /**
     * Gets the highest preparationTime of all Dishes in the order
     *
     * @param o
     * @return time in minutes (or -1 if order is Empty)
     */
    public int getPreparationTime(Order o) {
        Optional<OrderLine> longestOrderline = o.getOrderlines().stream().max(Comparator.comparing(ol -> ol.getDish().getProductionTime()));
        return longestOrderline.map(orderLine -> orderLine.getDish().getProductionTime()).orElse(-1);
    }

    public Order getOrder(int orderId) {
        return orderRepo.findOneWhere(o -> o.getOrderID() == orderId);
    }

    public Order assignOrder(int orderId, Courier appUser) {
        Order o = registerOrderEvent(orderId, OrderState.COURIER_ASSIGNED, "");
        o.setDeliverer(appUser);
        return o;
    }

    public Order registerOrderPickup(int orderId) {
        return registerOrderEvent(orderId, OrderState.DISHES_UNDERWAY, "");
    }

    public boolean isOnTimePickup(Order o) {
        return !o.getOrderPlacedDateTime().plusMinutes(o.getOrderlines().stream().mapToInt(ol -> ol.getDish().getProductionTime()).max().getAsInt()).isBefore(LocalDateTime.now());
    }

    public Order registerDelivery(int orderId) {
        return registerOrderEvent(orderId, OrderState.DELIVERED, "");
    }

    private Order registerOrderEvent(int orderId, OrderState state, String remark) {
        Order o = getOrder(orderId);
        o.addEvent(new OrderEvent(state, remark));
        orderRepo.update(orderId,o);
        return o;
    }

	public void setAvailableDeliveriesStrategy(AvailableDeliveriesStrategy strategy) {
		deliveryStrategy=strategy;

	}
}
