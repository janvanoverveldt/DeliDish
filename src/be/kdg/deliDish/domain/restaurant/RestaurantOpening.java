package be.kdg.deliDish.domain.restaurant;

import java.time.DayOfWeek;
import java.time.LocalTime;


public class RestaurantOpening {
    private DayOfWeek weekday;
    private LocalTime opening;
    private LocalTime closing;

    public RestaurantOpening(DayOfWeek weekday, LocalTime opening, LocalTime closing) {
        this.weekday = weekday;
        this.opening = opening;
        this.closing = closing;
    }
}
