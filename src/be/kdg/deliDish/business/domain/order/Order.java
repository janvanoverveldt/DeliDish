package be.kdg.deliDish.business.domain.order;

import be.kdg.deliDish.business.domain.customer.Customer;
import be.kdg.foundation.contact.Adress;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderEvent> events = new ArrayList<>();
    private List<OrderLine> orderlines;
    private Adress deliveryAdress;
    private String deliveryInstructions;
    private Customer customer;


    public Order(List<OrderLine> orderlines, Adress deliveryAdress, String deliveryInstructions, Customer customer) {
        this.orderlines = orderlines;
        this.deliveryAdress = deliveryAdress;
        this.deliveryInstructions = deliveryInstructions;
        this.customer = customer;
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

    public void addEvent(OrderEvent e) {
        events.add(e);
    }
}
