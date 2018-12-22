package be.kdg.deliDish.business;

import be.kdg.deliDish.domain.user.Courier;
import be.kdg.deliDish.domain.user.Customer;
import be.kdg.deliDish.domain.user.DeliveryPointEvent;
import be.kdg.deliDish.domain.user.DeliveryPointEvent.DeliveryPointEventType;
import be.kdg.persistence.MemoryRepository;

import java.util.Collection;

public class UserManager {
    private final MemoryRepository<String,Customer> customerRepo = new MemoryRepository<>();
    private final MemoryRepository<String,Courier> courierRepo = new MemoryRepository<>();


    public void addCustomer(Customer customer) {
        customerRepo.put(customer.getEmail(),customer);
    }

    public Collection<Customer> getCustomers() {
        return customerRepo.entities();
    }

    public void addCourier(Courier courier) {
        courierRepo.put(courier.getEmail(),courier);
    }


    public Collection<Courier> getCouriers() {
        return courierRepo.entities();
    }


    public Collection<Courier> getAvailableCouriers() {
        return courierRepo.findWhere(c -> c.isAvailable());
    }

    public void assignPoints(Courier appUser, DeliveryPointEventType event){
	    appUser.addPointEvent(event);
    }

}
