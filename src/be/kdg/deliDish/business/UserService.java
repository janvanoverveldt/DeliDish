package be.kdg.deliDish.business;

import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.deliDish.business.domain.user.Customer;
import be.kdg.deliDish.business.domain.user.DeliveryPointEvent;
import be.kdg.infra.MemoryRepository;

import java.util.Collection;

public class UserService {
    private final MemoryRepository<Customer> customerRepo = new MemoryRepository<>();
    private final MemoryRepository<Courier> courierRepo = new MemoryRepository<>();

    public void addCustomer(Customer customer) {
        customerRepo.put(customer);
    }

    public Collection<Customer> getCustomers() {
        return customerRepo.entities();
    }

    public void addCourier(Courier Courier) {
        courierRepo.put(Courier);
    }


    public Collection<Courier> getCouriers() {
        return courierRepo.entities();
    }


    public Collection<Courier> getAvailableCouriers() {
        return courierRepo.findWhere(c -> c.isAvailable());
    }

    public int getDeliveryPointsTotal(Courier c) {
        int total = 0;
        for (DeliveryPointEvent event : c.getDeliveryPointEvents()) {
            total += event.getPoints();
        }
        return total;
    }

}
