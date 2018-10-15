package be.kdg.deliDish.business;

import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.deliDish.business.domain.user.Customer;
import be.kdg.deliDish.business.domain.user.DeliveryPointEvent;
import be.kdg.infra.MemoryRepository;

import java.util.Collection;

public class UserService {
    private final MemoryRepository<Customer> customerRepo = new MemoryRepository<>();
    private final MemoryRepository<Courier> courierRepo = new MemoryRepository<>();
    private static int ORDER_ACCEPTED_POINTS = 5;
    private static int ORDER_PICKUP_ONTIME = 5;
    private static int ORDER_PICKUP_LATE = -5;

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

    public void assignOrderAcceptedPoints(Courier appUser) {
        appUser.addPointEvent(new DeliveryPointEvent(ORDER_ACCEPTED_POINTS, DeliveryPointEvent.DeliveryPointEventType.ORDER_ACCEPTED));
    }

    public void addOnTimePickupPoints(Courier appUser) {
        appUser.addPointEvent(new DeliveryPointEvent(ORDER_PICKUP_ONTIME, DeliveryPointEvent.DeliveryPointEventType.ORDER_PICKUP_ONTIME));
    }

    public void deductLatePickupPoints(Courier appUser) {
        appUser.addPointEvent(new DeliveryPointEvent(ORDER_PICKUP_LATE, DeliveryPointEvent.DeliveryPointEventType.ORDER_PICKUP_LATE));

    }
}
