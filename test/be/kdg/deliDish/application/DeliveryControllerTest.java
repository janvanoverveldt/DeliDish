package be.kdg.deliDish.application;


import be.kdg.deliDish.business.delivery.*;
import be.kdg.deliDish.business.service.*;
import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.order.OrderState;
import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.deliDish.business.domain.user.Courier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static be.kdg.foundation.contact.Country.BELGIUM;
import static be.kdg.foundation.contact.Country.DEFAULT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * In de test methoden van deze klasse mag je niks veranderen
 *
 * @author Jan de Rijke.
 */
public class DeliveryControllerTest {
    private static DeliveryController ctrl;
    private static OrderService os;
    private static UserService us;
    private static RestoService rs;


    @BeforeEach
    public void setUp() {
        TestData data = new TestData();

        os = new OrderService();
        us = new UserService();
        rs = new RestoService();

        ctrl = new DeliveryController(os, us, rs);
        ctrl.setAppUser(data.getCouriers().get(0));
        // Add the specialised Delevery selector. The default selector is created in de orderService itself.
	    AvailableDeliveriesStrategy deliveryStrategy = new AvailableDeliveriesStrategy();
	    deliveryStrategy.addAvailableDeliveriesSelector(DEFAULT, new DefaultAvailableDeliveriesSelector( os));
	    deliveryStrategy.addAvailableDeliveriesSelector(BELGIUM, new BelgianAvailableDeliveriesSelector(us, os));
			os.setAvailableDeliveriesStrategy(deliveryStrategy);
        //Load testdata into repositories
        for (Courier courier : data.getCouriers()) {
            ctrl.addCourier(courier);
        }

        ctrl.addCustomer(data.getCustomer());

        for (Restaurant restaurant : data.getRestos()) {
            ctrl.addResto(restaurant);
        }

        for (Order order : data.getOrders()) {
            ctrl.addOrder(order);
        }
    }


    @Test
    void getAvailableDeliveries() {
        //Er zijn verschillende types van beschikbare orders. Twee zijn er beschikbaar. De reden waarom wel en waarom niet staat in de DeliveryInstructions van de testdata.
        Collection<Order> availableDeliveries = ctrl.getAvailableDeliveries();
        assertEquals(2, availableDeliveries.size(), "Slechts 2 orders voldoen aan de voorwaarden");
        assertTrue(availableDeliveries.stream().anyMatch(d -> d.getDeliveryInstructions().startsWith("Na vijf minuten")));
        assertTrue(availableDeliveries.stream().anyMatch(d -> d.getDeliveryInstructions().startsWith("Binnen eerste vijf minuten, maar courier heeft meer dan gemiddelde deliveryPoints")));

        //Voor de courier uit de US wordt de default selector gebruikt en zijn daarom alle leverbare orders beschikbaar.
        ctrl.setAppUser(us.getCouriers().stream().filter(u -> u.getFirstName().equals("Frats")).findFirst().get());
        Collection<Order> availableDeliveries2 = ctrl.getAvailableDeliveries();
        assertEquals(4, availableDeliveries2.size(), "4 orders voldoen aan de voorwaarden");
    }

    @Test
    void selectDelivery() {
        int orderID = ctrl.getAvailableDeliveries().stream().findFirst().get().getOrderID();
        Order selectedOrder = ctrl.selectDelivery(orderID);
        assertEquals(selectedOrder.getDeliverer(), ctrl.getAppUser());
        assertEquals(us.getDeliveryPointsTotal(ctrl.getAppUser()), 501 + 5);
        assertEquals(selectedOrder.getCurrentState(), OrderState.COURIER_ASSIGNED);


    }

    @Test
    void registerDeliveryPickup() {
        int orderID = ctrl.getAvailableDeliveries().stream().findFirst().get().getOrderID();
        Order selectedOrder = ctrl.selectDelivery(orderID);
        selectedOrder = ctrl.registerDeliveryPickup(orderID);
        assertEquals(us.getDeliveryPointsTotal(ctrl.getAppUser()), 501 + 10);
        assertEquals(OrderState.DISHES_UNDERWAY, selectedOrder.getCurrentState());
    }

    @Test
    void registerSuccesfullDelivery() {
        int orderID = ctrl.getAvailableDeliveries().stream().findFirst().get().getOrderID();
        Order selectedOrder = ctrl.selectDelivery(orderID);
        selectedOrder = ctrl.registerDeliveryPickup(orderID);
        selectedOrder = ctrl.registerSuccesfullDelivery(orderID);
        assertEquals(us.getDeliveryPointsTotal(ctrl.getAppUser()), 501 + 15);
        assertEquals(OrderState.DELIVERED, selectedOrder.getCurrentState());
    }

}