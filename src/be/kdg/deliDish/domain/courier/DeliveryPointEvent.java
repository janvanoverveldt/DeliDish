package be.kdg.deliDish.domain.courier;

import java.time.LocalDateTime;

public class DeliveryPointEvent {
    private final LocalDateTime eventTime;
    private final int points;

    public DeliveryPointEvent(int points) {
        this.points = points;
        eventTime = LocalDateTime.now();
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public int getPoints() {
        return points;
    }

}
