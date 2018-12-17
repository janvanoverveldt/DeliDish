package be.kdg.deliDish.domain.user;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DeliveryPointEvent implements Serializable {
    private final LocalDateTime eventTime;
    private final int points;
    private final DeliveryPointEventType eventType;

    public DeliveryPointEvent(int points, DeliveryPointEventType eventType) {
        this.points = points;
        this.eventType = eventType;
        eventTime = LocalDateTime.now();
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public int getPoints() {
        return points;
    }

    public enum DeliveryPointEventType {
        ORDER_ACCEPTED, ORDER_PICKUP_ONTIME, ORDER_PICKUP_LATE
    }
}
