package be.kdg.deliDish.business;

import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.infra.MemoryRepository;

import java.util.Collection;

public class RestoService {
    private final MemoryRepository<Restaurant> restoRepo = new MemoryRepository<>();

    public void addResto(Restaurant resto) {
        restoRepo.put(resto);
    }

    public Collection<Restaurant> getRestos() {
        return restoRepo.entities();
    }


}
