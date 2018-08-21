package be.kdg.deliDish.domain;

import java.time.LocalDateTime;

public class OrderEvent {
    private LocalDateTime timestamp;
    private OrderState orderState;
    private String remark;
}
