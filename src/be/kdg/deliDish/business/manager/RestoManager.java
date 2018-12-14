package be.kdg.deliDish.business.manager;

import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.persistence.MemoryRepository;

import java.util.Collection;

public class RestoManager {
    private final MemoryRepository<String,Restaurant> restoRepo = new MemoryRepository<>();

    public void addResto(Restaurant resto) {
        restoRepo.put(resto.getName(),resto);
    }

    public Collection<Restaurant> getRestos() {
        return restoRepo.entities();
    }


}