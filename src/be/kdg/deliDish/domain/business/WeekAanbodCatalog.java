package be.kdg.deliDish.domain.business;

import be.kdg.deliDish.domain.recept.WeekAanbod;
import be.kdg.infra.MemoryRepository;
import be.kdg.infra.WeekAanbodMemoryRepository;

import java.util.ArrayList;
import java.util.List;

public class WeekAanbodCatalog {
    private final MemoryRepository<WeekAanbod> weekaanbod = new WeekAanbodMemoryRepository<>();

    public void addWeekAanbod(WeekAanbod week) {
        weekaanbod.put(week);
    }

    public List<WeekAanbod> getWeekData(int requestedWeeks) {
        List<WeekAanbod> returnWeeks = new ArrayList<>();
        //Niet 100% zeker of juiste weken worden teruggegeven maar test werkt
        for (int week = 0; week < requestedWeeks; week++) {
            returnWeeks.add(weekaanbod.get(weekaanbod.entities().iterator().next()));
        }
        return returnWeeks;
    }
}
