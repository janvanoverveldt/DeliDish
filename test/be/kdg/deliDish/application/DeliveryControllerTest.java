package be.kdg.deliDish.application;

import be.kdg.deliDish.business.AvailableDeliveriesService;
import be.kdg.deliDish.business.BelgianAvailableDeliveriesService;
import be.kdg.deliDish.business.domain.courier.Courier;
import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In de test methoden van deze klasse mag je niks veranderen
 *
 * @author Jan de Rijke.
 */
public class DeliveryControllerTest {
    private static DeliveryController ctrl;
    private static AvailableDeliveriesService ads;

    @BeforeAll
    public static void setUp() {
        // TODO0 initialiseer het systeem
        TestData data = new TestData();

        ctrl = new DeliveryController();
        ctrl.setAppUser(data.getCouriers().get(0));
        ads = new BelgianAvailableDeliveriesService(ctrl.getCourierCatalog(), ctrl.getOrderCatalog(), ctrl.getRestoCatalog());

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
        Collection<Order> availableDeliveries = ctrl.getAvailableDeliveries(ads);
        assertEquals(1, availableDeliveries.size(), "Slechts één order voldoet aan de voorwaarden");
        assertEquals(ctrl.getOrderCatalog().getOrders().stream().findFirst().get(), availableDeliveries.stream().findFirst().get());

    }

    @Test
    void selectDelivery() {
    }

    @Test
    void registerDeliveryPickup() {
    }

    @Test
    void registerSuccesfullDelivery() {
    }

    @Test
    void getDeliveryPointsTotal() {
    }
}