package be.kdg.deliDish.business.domain.restaurant;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

//TODO Je mag zaken toevoegen aan deze klasse. Bestaande attributen en methodes wijzigen doe je beter niet.
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
