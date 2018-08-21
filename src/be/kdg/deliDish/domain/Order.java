package be.kdg.hiFresh.domain;

import be.kdg.foundation.contact.Adres;

import java.util.List;

public class Order {
    private List<OrderEvent> events;
    private List<OrderLine> orderlines;
    private Adres deliveryAdress;
    private String deliveryInstructions;

}
