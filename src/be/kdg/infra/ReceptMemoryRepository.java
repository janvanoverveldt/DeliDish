package be.kdg.infra;

import be.kdg.hiFresh.domain.recept.Recept;

public class ReceptMemoryRepository<V> extends MemoryRepository<Recept> {

    @Override
    public boolean put(Recept recept) {
        return super.put(recept);
    }
}