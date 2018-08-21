package be.kdg.deliDish.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;


public class RestaurantOpening {
    public DayOfWeek weekday;
    public LocalTime opening;
    public LocalTime closing;

    public RestaurantOpening(DayOfWeek weekday, LocalTime opening, LocalTime closing) {
        this.weekday = weekday;
        this.opening = opening;
        this.closing = closing;
    }
}
