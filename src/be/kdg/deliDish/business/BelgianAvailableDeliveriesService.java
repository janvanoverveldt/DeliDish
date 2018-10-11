package be.kdg.deliDish.business;

import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.foundation.contact.DistanceCalculator;
import be.kdg.foundation.contact.Position;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BelgianAvailableDeliveriesService implements AvailableDeliveriesService {
    private static final double MIN_PER_KM = 4;
    private UserService us;
    private OrderService os;
    private RestoService rs;
    private Courier requestingCourier;

    public BelgianAvailableDeliveriesService(UserService us, OrderService os, RestoService rs) {
        this.us = us;
        this.os = os;
        this.rs = rs;
    }

    public void setCc(UserService cc) {
        this.us = us;
    }

    public void setOs(OrderService os) {
        this.os = os;
    }

    /**
     * Gives a list of deliveries available for the requesting user. The requesting user as well ass the available orders and couriers must be set before running this method.
     */
    //TODO: CurrentPosition niet in domain.
    @Override
    public Collection<Order> getAvailableDeliveries(Courier courier) {

        List<Courier> availableCouriers = new ArrayList<>(us.getAvailableCouriers());
        List<Order> availableOrders = new ArrayList<>(os.getDeliverableOrders());
        List<List<Courier>> orderCouriers = new ArrayList<>();
        for (Order order : availableOrders) {
            List<Courier> couriersWithinTimeLimit = new ArrayList<>();
            int prepTime = os.getOrderPreparationTime(order);
            for (Courier c : availableCouriers) {
                double courierTimeToResto = timeToPosition(c.getCurrentPosition(), (os.getOrderResto(order)).getPosition());
                if (order.getOrderPlacedDateTime().plus(prepTime, ChronoUnit.MINUTES).isAfter(LocalDateTime.now().plus((int) courierTimeToResto, ChronoUnit.MINUTES))) {
                    couriersWithinTimeLimit.add(c);
                }
            }
            orderCouriers.add(couriersWithinTimeLimit);
        }
        Collection<Order> availableDeliveries = new ArrayDeque<>();
        for (int i = 0; i < availableOrders.size(); i++) {
            Order current = availableOrders.get(i);
            double averagePoints = calculateDeliveryPointAverage(orderCouriers.get(i));
            if (averagePoints <= us.getDeliveryPointsTotal(courier) && LocalDateTime.now().minus(5, ChronoUnit.MINUTES).isBefore(current.getOrderPlacedDateTime())) {
                availableDeliveries.add(current);
            }
        }

        return availableDeliveries;
    }

    private double timeToPosition(Position start, Position dest) {
        return DistanceCalculator.getDistance(start, dest) * MIN_PER_KM;
    }

    /**
     * Written in short stream notation. For loop also can be used.
     *
     * @param cs
     * @return
     */
    private double calculateDeliveryPointAverage(List<Courier> cs) {
        return cs.stream().mapToDouble(c -> us.getDeliveryPointsTotal(c)).average().getAsDouble();
    }
}
