package be.kdg.deliDish.domain;

import be.kdg.foundation.contact.Adres;

import java.util.List;

public class Order {
    private List<OrderEvent> events;
    private List<OrderLine> orderlines;
    private Adres deliveryAdress;
    private String deliveryInstructions;

    public Order(List<OrderLine> orderlines, Adres deliveryAdress, String deliveryInstructions) {
        this.orderlines = orderlines;
        this.deliveryAdress = deliveryAdress;
        this.deliveryInstructions = deliveryInstructions;
    }
}
