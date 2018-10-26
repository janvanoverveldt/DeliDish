package be.kdg.deliDish.business;

import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.distanceAPI.DistanceCalculator;
import be.kdg.distanceAPI.Point;
import be.kdg.foundation.contact.Position;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BelgianAvailableDeliveriesSelector implements AvailableDeliveriesSelector {
    private static final double MIN_PER_KM = 4;
    private UserService us;
    private OrderService os;
    private RestoService rs;
    private Courier requestingCourier;

    public BelgianAvailableDeliveriesSelector(UserService us, OrderService os, RestoService rs) {
        this.us = us;
        this.os = os;
        this.rs = rs;
    }

    public void setUs(UserService us) {
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

        List<Order> availableOrders = new ArrayList<>(os.getDeliverableOrders());
        List<Order> availableDeliveries = new ArrayList<>();

        for (Order order : availableOrders) {
            double courierTimeToResto = timeToPosition(courier.getCurrentPosition(), (os.getOrderResto(order)).getPosition());
            if (order.getOrderPlacedDateTime().plus(os.getOrderPreparationTime(order), ChronoUnit.MINUTES).isAfter(LocalDateTime.now().plus((int) courierTimeToResto, ChronoUnit.MINUTES))
                    && order.getAverageCourierDeliveryPoints() > us.getDeliveryPointsTotal(courier)) {
                availableDeliveries.add(order);
                }
            }

        return availableDeliveries;
    }

    private double timeToPosition(Position start, Position dest) {
        return new DistanceCalculator().getDistance(new Point(start.getLattitude(), start.getLongitude()), new Point(dest.getLattitude(), dest.getLongitude())) * MIN_PER_KM;
    }


}
