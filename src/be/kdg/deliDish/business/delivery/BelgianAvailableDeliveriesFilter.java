package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.business.service.OrderService;
import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.deliDish.business.service.UserService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BelgianAvailableDeliveriesFilter implements DeliveriesFilter {
    private UserService us;
    private OrderService os;

    public BelgianAvailableDeliveriesFilter(UserService us, OrderService os) {
    	this.us =us;
    	this.os=os;

    }


    /**
     * Gives a list of deliveries available for the requesting user. The requesting user as well ass the available orders and couriers must be set before running this method.
     */
    @Override
    public Collection<Order> getAvailableDeliveries(Courier courier) {

        List<Order> availableOrders = new ArrayList<>(os.getDeliverableOrders());
        List<Order> availableDeliveries = new ArrayList<>();

        for (Order order : availableOrders) {
            Ride rideToRestaurant = new Ride(courier.getCurrentPosition(), os.getPosition(order), 4);
            if (order.getOrderPlacedDateTime().plus(os.getPreparationTime(order), ChronoUnit.MINUTES).isAfter(LocalDateTime.now().plus((int) rideToRestaurant.getDuration(), ChronoUnit.MINUTES))
                    && (order.getAverageCourierDeliveryPoints() <= us.getDeliveryPointsTotal(courier)
                    ||
                    order.getOrderPlacedDateTime().plusMinutes(5).isBefore(LocalDateTime.now()))) {
                availableDeliveries.add(order);
            }
        }
        return availableDeliveries;
    }


}
