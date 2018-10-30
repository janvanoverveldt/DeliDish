package be.kdg.deliDish.business.domain.financial;

import be.kdg.deliDish.business.domain.user.Partner;

import java.time.LocalDateTime;

public class MoneyTransfer extends Payment {
    private Partner benificiery;

    public MoneyTransfer(Partner benificiery, LocalDateTime timestamp, String paymentDetail, Money amount) {
        super(timestamp, paymentDetail, amount);
        this.benificiery = benificiery;
    }


    public Partner getBenificiery() {
        return benificiery;
    }

    public void setBenificiery(Partner benificiery) {
        this.benificiery = benificiery;
    }
}
