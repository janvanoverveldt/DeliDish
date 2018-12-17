package be.kdg.deliDish.business;

import be.kdg.deliDish.business.delivery.*;
import be.kdg.deliDish.domain.order.Order;
import be.kdg.deliDish.domain.order.OrderEvent;
import be.kdg.deliDish.domain.order.OrderState;
import be.kdg.deliDish.domain.user.Courier;
import be.kdg.persistence.MemoryRepository;

import java.time.LocalDateTime;
import java.util.*;

public class OrderManager {
    private static int orerIdSequence = 0;
    private final MemoryRepository<Integer,Order> orderRepo = new MemoryRepository<>();
	  private DeliveriesFilterSelector selector;


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
    	DeliveriesFilter filter = selector.getDeliveriesFilter(courier);
        return orderRepo.findWhere(o -> filter.select(o,courier),filter.orderBy(),filter.getLimit());
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


	public Order assignOrder(int orderId, Courier appUser) {
    	Order o = orderRepo.get(orderId);
				o.setDeliverer(appUser);
        registerOrderEvent(o, OrderState.COURIER_ASSIGNED, "");
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
	    Order o = orderRepo.get(orderId);
	    return registerOrderEvent(o, state, remark);
    }

	private Order registerOrderEvent(Order o, OrderState state, String remark) {
		o.addEvent(new OrderEvent(state, remark));
		orderRepo.update(o.getOrderID(),o);
		return o;
	}

	public void setAvailableDeliveriesSelector(DeliveriesFilterSelector select) {
		selector =select;

	}
}
