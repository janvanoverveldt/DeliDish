package be.kdg.deliDish.business.domain.order;

import be.kdg.deliDish.business.domain.restaurant.Dish;

public class OrderLine {
    private Dish dish;
    private int quantity;
    private String remark;

    public OrderLine(Dish dish, int quantity, String remark) {
        this.dish = dish;
        this.quantity = quantity;
        this.remark = remark;
    }

    public Dish getDish() {
        return dish;
    }
}
