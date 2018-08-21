package be.kdg.deliDish.domain.business;

import be.kdg.deliDish.domain.order.Order;
import be.kdg.deliDish.domain.order.OrderState;
import be.kdg.infra.MemoryRepository;

import java.util.Collection;

public class OrderCatalog {
    private final MemoryRepository<Order> orderRepo = new MemoryRepository<>();

    public void addOrder(Order order) {
        orderRepo.put(order);
    }

    /**
     * Gets all orders in de repository
     *
     * @return all available Orders in the repository
     */
    public Collection<Order> getOrders() {
        return orderRepo.entities();
    }

    public Collection<Order> getDeliverableOrders() {
        return orderRepo.findWhere(order -> order.getCurrentState() == OrderState.ORDER_PLACED);
    }



}
