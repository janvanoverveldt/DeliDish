package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.business.OrderService;
import be.kdg.deliDish.business.UserService;
import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.user.Courier;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BelgianAvailableDeliveriesSelector implements AvailableDeliveriesSelector {
    private UserService us;
    private OrderService os;

    public BelgianAvailableDeliveriesSelector(UserService us, OrderService os) {
        this.us = us;
        this.os = os;
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
            Ride rideToRestaurant = new Ride(courier.getCurrentPosition(), os.getPosition(order), 4);
            if (order.getOrderPlacedDateTime().plus(os.getPreparationTime(order), ChronoUnit.MINUTES).isAfter(LocalDateTime.now().plus((int) rideToRestaurant.getDuration(), ChronoUnit.MINUTES))
                    && order.getAverageCourierDeliveryPoints() > us.getDeliveryPointsTotal(courier)) {
                availableDeliveries.add(order);
            }
        }
        return availableDeliveries;
    }


}
