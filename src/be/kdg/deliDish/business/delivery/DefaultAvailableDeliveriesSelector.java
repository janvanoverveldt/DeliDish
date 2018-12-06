package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.business.service.OrderService;
import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.user.Courier;

import java.util.Collection;

public class DefaultAvailableDeliveriesSelector implements AvailableDeliveriesSelector {
    private OrderService os;

    public DefaultAvailableDeliveriesSelector(OrderService orderService) {
        os = orderService;
    }

    @Override
    public Collection<Order> getAvailableDeliveries(Courier courier) {
        return os.getDeliverableOrders();
    }
}
