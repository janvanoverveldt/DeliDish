package be.kdg.deliDish.application;

import be.kdg.deliDish.business.AvailableDeliveriesSelector;
import be.kdg.deliDish.business.BelgianAvailableDeliveriesSelector;
import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.deliDish.business.domain.user.Courier;
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
    private static AvailableDeliveriesSelector ads;

    @BeforeAll
    public static void setUp() {
        // TODO0 initialiseer het systeem
        TestData data = new TestData();

        ctrl = new DeliveryController();
        ctrl.setAppUser(data.getCouriers().get(0));
        ads = new BelgianAvailableDeliveriesSelector(ctrl.getUserService(), ctrl.getOrderService(), ctrl.getRestoCatalog());
        ctrl.getOrderService().setAvailableDeliveriesSelector(ads);

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
        //Er zijn verschillende types van beschikbare orders. Elk zijn ze om de één of andere reden niet beschikbaar, met uitzondering van 1. Zie testdata voor meer detail
        Collection<Order> availableDeliveries = ctrl.getAvailableDeliveries(ads);
        assertEquals(1, availableDeliveries.size(), "Slechts één order voldoet aan de voorwaarden");
        assertEquals(ctrl.getOrderService().getOrders().stream().findFirst().get(), availableDeliveries.stream().findFirst().get());
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