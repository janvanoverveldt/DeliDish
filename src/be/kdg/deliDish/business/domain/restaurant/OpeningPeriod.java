package be.kdg.deliDish.business.domain.restaurant;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;


public class OpeningPeriod implements Serializable {
    private DayOfWeek weekday;
    private LocalTime opening;
    private LocalTime closing;

    public OpeningPeriod(DayOfWeek weekday, LocalTime opening, LocalTime closing) {
        this.weekday = weekday;
        this.opening = opening;
        this.closing = closing;
    }
}
