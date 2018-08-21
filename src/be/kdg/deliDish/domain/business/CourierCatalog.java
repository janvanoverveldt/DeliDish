package be.kdg.deliDish.domain.business;

import be.kdg.deliDish.domain.courier.Courier;
import be.kdg.infra.MemoryRepository;

import java.util.Collection;

public class CourierCatalog {
    private final MemoryRepository<Courier> courierRepo = new MemoryRepository<>();

    public void addCourier(Courier Courier) {
        courierRepo.put(Courier);
    }

    /**
     * Gets all Couriers in de repository
     *
     * @return all available Couriers in the repository
     */
    public Collection<Courier> getCouriers() {
        return courierRepo.entities();
    }


    public Collection<Courier> getAvailableCouriers() {
        return courierRepo.findWhere(c -> c.isAvailable());
    }
}
