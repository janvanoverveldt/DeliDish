package be.kdg.deliDish.business.domain.user;

import java.time.LocalDateTime;

public class DeliveryPointEvent {
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
        ORDER_ACCEPTED, ORDER_PICKUP_ONTIME, ORDER_PICKUP_LATE;
    }
}
