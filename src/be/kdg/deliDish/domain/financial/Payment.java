package be.kdg.deliDish.domain.financial;

import java.time.LocalDateTime;

public class Payment {
    private LocalDateTime timestamp;
    private String paymentDetail;
    private Money amount;

    public Payment(LocalDateTime timestamp, String paymentDetail, Money amount) {
        this.timestamp = timestamp;
        this.paymentDetail = paymentDetail;
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(String paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }
}
