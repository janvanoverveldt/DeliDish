package be.kdg.deliDish.business.domain.user;

import java.io.Serializable;
import java.time.LocalDateTime;

//TODO Je mag zaken toevoegen aan deze klasse. Bestaande attributen en methodes wijzigen doe je beter niet.
public class DeliveryPointEvent implements Serializable {
    private final LocalDateTime eventTime;
    private final int points;
    private final DeliveryPointEventType eventType;

    public DeliveryPointEvent(int points, DeliveryPointEventType eventType) {
        this.points = points;
        this.eventType = eventType;
        eventTime = LocalDateTime.now();
    }


    public enum DeliveryPointEventType {
        ORDER_ACCEPTED, ORDER_PICKUP_ONTIME, ORDER_PICKUP_LATE
    }
}
