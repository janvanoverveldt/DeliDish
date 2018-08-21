package be.kdg.deliDish.domain.business;

import be.kdg.deliDish.domain.Order;
import be.kdg.infra.MemoryRepository;

import java.util.Collection;

public class OrderCatalog {
    private final MemoryRepository<Order> orders = new MemoryRepository<>();

    public void addOrder(Order order) {
        orders.put(order);
    }

    public Collection<Order> getOrders() {
        return orders.entities();
    }
}
