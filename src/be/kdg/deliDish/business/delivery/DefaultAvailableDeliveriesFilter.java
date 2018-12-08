package be.kdg.deliDish.business.delivery;

import be.kdg.deliDish.business.manager.OrderManager;
import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.user.Courier;

import java.util.Collection;

public class DefaultAvailableDeliveriesFilter implements DeliveriesFilter {
    private OrderManager os;

    public DefaultAvailableDeliveriesFilter(OrderManager orderService) {
        os = orderService;
    }

    @Override
    public Collection<Order> getAvailableDeliveries(Courier courier) {
        return os.getDeliverableOrders();
    }
}
