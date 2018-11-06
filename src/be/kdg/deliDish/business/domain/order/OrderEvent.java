package be.kdg.deliDish.business.domain.order;

import java.io.Serializable;
import java.time.LocalDateTime;

//TODO Je mag zaken toevoegen aan deze klasse. Bestaande attributen en methodes wijzigen doe je beter niet.
public class OrderEvent implements Serializable {
    private final LocalDateTime timestamp;
    private final OrderState orderState;
    private final String remark;


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public OrderState getOrderState() {
        return orderState;
    }


    public OrderEvent(LocalDateTime timestamp, OrderState orderState, String remark) {
        this.timestamp = timestamp;
        this.orderState = orderState;
        this.remark = remark;
    }
}
