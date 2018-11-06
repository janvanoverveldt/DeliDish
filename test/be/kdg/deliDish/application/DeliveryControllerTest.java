package be.kdg.deliDish.application;

import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.order.OrderState;
import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.deliDish.business.domain.user.Courier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * In de test methoden van deze klasse mag je niks veranderen
 *
 * @author Jan de Rijke.
 */
public class DeliveryControllerTest {
    private static DeliveryController ctrl;


    // De setup methode wordt uitgevoerd voor elke Test die hieronder beschreven staat.
    // In de testmethode beschrijven we wat er moet gebeuren
    @BeforeEach
    public void setUp() {
        TestData data = new TestData();
        //TODO Opdracht 3: Maak de controller op de juiste manier aan. En initiëer alles wat nodig is.
        //TODO Opdracht 3: Blijf van onderstaande code af. Hier wordt de testdata doorgegeven aan de controller. Zorg er voor dat de data wordt opgeslagen op een logische plaats in de businesslaag.
        //TODO Opdracht 4: De data moet in repositories worden opgeslagen. Meer detail over hoe dat moet krijg je tijdens de les.
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
        //TODO Opdracht 4: Uncomment onderstaande test voor Belgische couriers.
        //Er zijn verschillende types van beschikbare orders. Twee zijn er beschikbaar. De reden waarom wel en waarom niet staat in de DeliveryInstructions van de testdata.
        Collection<Order> availableDeliveries = ctrl.getAvailableDeliveries();
        assertEquals(2, availableDeliveries.size(), "Slechts 2 orders voldoen aan de voorwaarden");
        assertTrue(availableDeliveries.stream().anyMatch(d -> d.getDeliveryInstructions().startsWith("Na vijf minuten")));
        assertTrue(availableDeliveries.stream().anyMatch(d -> d.getDeliveryInstructions().startsWith("Binnen eerste vijf minuten, maar courier heeft meer dan gemiddelde deliveryPoints")));

        //TODO Opdracht 3: Zorg ervoor dat volgende test op groen komt als je deze uitvoert.
        //Voor de courier uit de US wordt de default selector gebruikt en zijn daarom alle leverbare orders beschikbaar.
        ctrl.setAppUser(ctrl.getCouriers().stream().filter(u -> u.getFirstName().equals("Frats")).findFirst().get());
        Collection<Order> availableDeliveries2 = ctrl.getAvailableDeliveries();
        assertEquals(4, availableDeliveries2.size(), "4 orders voldoen aan de voorwaarden");
    }


    //TODO Opdracht 4: uncomment test selectDelivery
    @Test
    void selectDelivery() {
        int orderID = ctrl.getAvailableDeliveries().stream().findFirst().get().getOrderID();
        Order selectedOrder = ctrl.selectDelivery(orderID);
        assertEquals(selectedOrder.getDeliverer(), ctrl.getAppUser());
        assertEquals(ctrl.getDeliveryPointsTotal(ctrl.getAppUser()), 501 + 5);
        assertEquals(selectedOrder.getCurrentState(), OrderState.COURIER_ASSIGNED);
    }

    //TODO Opdracht 4: uncomment test registerDeliveryPickup en registerSuccesfullDelivery
    @Test
    void registerDeliveryPickup() {
        int orderID = ctrl.getAvailableDeliveries().stream().findFirst().get().getOrderID();
        Order selectedOrder = ctrl.selectDelivery(orderID);
        selectedOrder = ctrl.registerDeliveryPickup(orderID);
        assertEquals(ctrl.getDeliveryPointsTotal(ctrl.getAppUser()), 501 + 10);
        assertEquals(OrderState.DISHES_UNDERWAY, selectedOrder.getCurrentState());
    }

    @Test
    void registerSuccesfullDelivery() {
        int orderID = ctrl.getAvailableDeliveries().stream().findFirst().get().getOrderID();
        Order selectedOrder = ctrl.selectDelivery(orderID);
        selectedOrder = ctrl.registerDeliveryPickup(orderID);
        selectedOrder = ctrl.registerSuccesfullDelivery(orderID);
        assertEquals(ctrl.getDeliveryPointsTotal(ctrl.getAppUser()), 501 + 15);
        assertEquals(OrderState.DELIVERED, selectedOrder.getCurrentState());
    }

}