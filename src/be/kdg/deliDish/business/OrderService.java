package be.kdg.deliDish.business;

import be.kdg.deliDish.business.delivery.AvailableDeliveriesSelector;
import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.order.OrderEvent;
import be.kdg.deliDish.business.domain.order.OrderLine;
import be.kdg.deliDish.business.domain.order.OrderState;
import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.foundation.contact.Position;
import be.kdg.infra.MemoryRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

public class OrderService {
    private final MemoryRepository<Order> orderRepo = new MemoryRepository<>();
    private RestoService rc;
    private AvailableDeliveriesSelector ads;
    private static int orerIdSequence = 0;

    public OrderService() {

    }

    public void setAvailableDeliveriesSelector(AvailableDeliveriesSelector ads) {
        this.ads = ads;
    }

    public Collection<Order> getAvailableDeliveries(Courier courier) {
        return ads.getAvailableDeliveries(courier);
    }

    public void addOrder(Order order) {
        orderRepo.put(order);
    }

    public void setRc(RestoService rc) {
        this.rc = rc;
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

    public Position getDeliveryPosition(Order o) {
        return o.getDeliveryAdress().getPosition();
    }

    public Restaurant getOrderResto(Order o) {
        return o.getOrderlines().get(0).getDish().getResto();
    }

    public Position getOrderPosition(Order o) {
        return o.getOrderlines().get(0).getDish().getResto().getPosition();
    }

    /**
     * Gets the highest preparationTime of all Dishes in the order
     *
     * @param o
     * @return time in minutes (or -1 if order is Empty)
     */
    public int getOrderPreparationTime(Order o) {
        Optional<OrderLine> longestOrderline = o.getOrderlines().stream().max(Comparator.comparing(ol -> ol.getDish().getProductionTime()));
        if (longestOrderline.isPresent()) {
            return longestOrderline.get().getDish().getProductionTime();
        }
        return -1;
    }

    public static int generateOrderId() {
        return orerIdSequence++;
    }


    public Order getOrder(int orderId) {
        return (Order) orderRepo.findWhere(o -> o.getOrderID() == orderId);
    }

    public Order assignOrder(int orderId, Courier appUser) {
        Order o = getOrder(orderId);
        o.setDeliverer(appUser);
        o.addEvent(new OrderEvent(OrderState.COURIER_ASSIGNED, "No Remark"));
        orderRepo.update(o);
        return o;

    }

    public Order registerOrderPickup(int orderId) {
        Order o = getOrder(orderId);
        o.addEvent(new OrderEvent(OrderState.DISHES_UNDERWAY, "No Remark"));
        return o;
    }

    public boolean isOnTimePickup(Order o) {
        if (o.getOrderPlacedDateTime().plusMinutes(o.getOrderlines().stream().mapToInt(ol -> ol.getDish().getProductionTime()).max().getAsInt()).isBefore(LocalDateTime.now())) {
            return false;
        } else {
            return true;
        }
    }
}
