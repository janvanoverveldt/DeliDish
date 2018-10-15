package be.kdg.deliDish.business.domain.order;

import java.time.LocalDateTime;

public class OrderEvent {
    private final LocalDateTime timestamp;
    private final OrderState orderState;
    private final String remark;

    public OrderEvent(OrderState orderState, String remark) {
        this.orderState = orderState;
        this.remark = remark;
        timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public String getRemark() {
        return remark;
    }

    public OrderEvent(LocalDateTime timestamp, OrderState orderState, String remark) {
        this.timestamp = timestamp;
        this.orderState = orderState;
        this.remark = remark;
    }
}
