package be.kdg.deliDish.business.manager;

import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.deliDish.business.domain.user.Customer;
import be.kdg.deliDish.business.domain.user.DeliveryPointEvent;
import be.kdg.persistence.MemoryRepository;

import java.util.Collection;

public class UserManager {
    private final MemoryRepository<String,Customer> customerRepo = new MemoryRepository<>();
    private final MemoryRepository<String,Courier> courierRepo = new MemoryRepository<>();
    private static int ORDER_ACCEPTED_POINTS = 5;
    private static int ORDER_PICKUP_ONTIME_POINTS = 5;
    private static int ORDER_PICKUP_LATE_POINTS = -5;

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

    public int getDeliveryPointsTotal(Courier c) {
        int total = 0;
        for (DeliveryPointEvent event : c.getDeliveryPointEvents()) {
            total += event.getPoints();
        }
        return total;
    }

    public void assignOrderAcceptedPoints(Courier appUser) {
        appUser.addPointEvent(new DeliveryPointEvent(ORDER_ACCEPTED_POINTS, DeliveryPointEvent.DeliveryPointEventType.ORDER_ACCEPTED));
    }

    public void addOnTimePickupPoints(Courier appUser) {
        appUser.addPointEvent(new DeliveryPointEvent(ORDER_PICKUP_ONTIME_POINTS, DeliveryPointEvent.DeliveryPointEventType.ORDER_PICKUP_ONTIME));
    }

    public void deductLatePickupPoints(Courier appUser) {
        appUser.addPointEvent(new DeliveryPointEvent(ORDER_PICKUP_LATE_POINTS, DeliveryPointEvent.DeliveryPointEventType.ORDER_PICKUP_LATE));

    }
}
