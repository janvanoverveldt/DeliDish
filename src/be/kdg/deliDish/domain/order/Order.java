package be.kdg.deliDish.domain.order;

import be.kdg.foundation.contact.Adress;

import java.util.List;

public class Order {
    private List<OrderEvent> events;
    private List<OrderLine> orderlines;
    private Adress deliveryAdress;
    private String deliveryInstructions;


    public Order(List<OrderLine> orderlines, Adress deliveryAdress, String deliveryInstructions) {
        this.orderlines = orderlines;
        this.deliveryAdress = deliveryAdress;
        this.deliveryInstructions = deliveryInstructions;
    }

    public OrderState getCurrentState() {
        return events.get(events.size() - 1).getOrderState();
    }

}
