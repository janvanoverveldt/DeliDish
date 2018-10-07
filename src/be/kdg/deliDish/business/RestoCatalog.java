package be.kdg.deliDish.business;

import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.infra.MemoryRepository;

import java.util.Collection;

public class RestoCatalog {
    private final MemoryRepository<Restaurant> restoRepo = new MemoryRepository<>();

    public void addResto(Restaurant resto) {
        restoRepo.put(resto);
    }

    /**
     * Gets all restos in de repository
     *
     * @return all available Restos in the repository
     */
    public Collection<Restaurant> getRestos() {
        return restoRepo.entities();
    }


}
