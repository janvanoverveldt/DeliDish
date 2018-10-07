package be.kdg.deliDish.business.domain.restaurant;

import java.time.DayOfWeek;
import java.time.LocalTime;


public class OpeningPeriod {
    private DayOfWeek weekday;
    private LocalTime opening;
    private LocalTime closing;

    public OpeningPeriod(DayOfWeek weekday, LocalTime opening, LocalTime closing) {
        this.weekday = weekday;
        this.opening = opening;
        this.closing = closing;
    }
}
