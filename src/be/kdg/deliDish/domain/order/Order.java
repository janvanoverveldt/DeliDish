package be.kdg.deliDish.domain.order;

import be.kdg.deliDish.domain.user.Courier;
import be.kdg.deliDish.domain.user.Customer;
import be.kdg.foundation.contact.Adress;
import be.kdg.foundation.contact.Position;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.*;

public class Order implements Serializable {
    private int orderID;
    private List<OrderEvent> events = new ArrayList<>();
    private List<OrderLine> orderlines;
    private Adress deliveryAdress;
    private String deliveryInstructions;
    private Customer customer;
    private Courier deliverer;
    private int averageCourierDeliveryPoints;


    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public Order(List<OrderLine> orderlines, Adress deliveryAdress, String deliveryInstructions, Customer customer, int orderID, int averageDeliveryPoints) {
        this.orderID = orderID;
        this.orderlines = orderlines;
        this.deliveryAdress = deliveryAdress;
        this.deliveryInstructions = deliveryInstructions;
        this.customer = customer;
        this.averageCourierDeliveryPoints = averageDeliveryPoints;
    }

    public int getAverageCourierDeliveryPoints() {
        return averageCourierDeliveryPoints;
    }

    public void setEvents(List<OrderEvent> events) {
        this.events = events;
    }

    public Courier getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Courier deliverer) {
        this.deliverer = deliverer;
    }

    public OrderState getCurrentState() {
        return events.get(events.size() - 1).getOrderState();
    }

    public LocalDateTime getOrderPlacedDateTime() {
        return events.get(0).getTimestamp();
    }

    public Adress getDeliveryAdress() {
        return deliveryAdress;
    }

    public List<OrderLine> getOrderlines() {
        return orderlines;
    }

    public int getOrderID() {
        return orderID;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return orderID == order.orderID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderID);
	}

	public Position getPosition() {
	    return getOrderlines().get(0).getDish().getResto().getPosition();
	}

	/**
     * Gets the highest preparationTime of all Dishes in the order
     *
     * @return time in minutes (or -1 if order is Empty)
     */
    public int getProductionDuration() {
        Optional<OrderLine> longestOrderline = getOrderlines().stream().max(Comparator.comparing(ol -> ol.getDish().getProductionTime()));
        return longestOrderline.map(orderLine -> orderLine.getDish().getProductionTime()).orElse(-1);
    }

    public LocalDateTime getProductionDateTime(){
	    return getOrderPlacedDateTime().plusMinutes(getProductionDuration());
    }

    // to be implemented
	public LocalDateTime getDeliveryDateTime(){
		return getOrderPlacedDateTime().plusMinutes(getProductionDuration());
	}


	public boolean hasCurrentState(OrderState state) {
		return getCurrentState() == state;
	}

	public void addEvent(OrderState state, String remark) {
    	events.add(new OrderEvent(state, remark));
	}

	public void addEvent(LocalDateTime timestamp,OrderState state, String remark) {
		events.add(new OrderEvent(timestamp,state, remark));
	}
}
