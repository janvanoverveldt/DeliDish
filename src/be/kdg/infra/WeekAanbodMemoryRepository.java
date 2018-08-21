package be.kdg.infra;

import be.kdg.deliDish.domain.recept.WeekAanbod;

import java.util.Collection;

public class WeekAanbodMemoryRepository<V> extends MemoryRepository<WeekAanbod> {

    @Override
    public boolean put(WeekAanbod weekAanbod) {
        return super.put(weekAanbod);
    }

    @Override
    public Collection<WeekAanbod> entities() {
        return super.entities();
    }

}
