package be.kdg.deliDish.domain.order;

import java.time.LocalDateTime;

public class OrderEvent {
    private LocalDateTime timestamp;
    private OrderState orderState;
    private String remark;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public String getRemark() {
        return remark;
    }
}
