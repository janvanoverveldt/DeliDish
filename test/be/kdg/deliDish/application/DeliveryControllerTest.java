package be.kdg.deliDish.application;

import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.deliDish.business.domain.user.Courier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * In de test methoden van deze klasse mag je niks veranderen
 *
 * @author Jan de Rijke.
 */
public class DeliveryControllerTest {
    private DeliveryController ctrl;


    // De setUp() methode wordt uitgevoerd voor elke Test-methode die hieronder beschreven staat.
    // In de setUp initialiseer je alle testdata zodat het programma er gebruik van kan maken.
    @BeforeEach
    public void setUp() {
        TestData data = new TestData();
        //TODO (week 3-4) Maak een instantie ctrl aan en initiëer alles wat nodig is om je applicatie uit te voeren.


        //TODO (week 3-4) Laat onderstaande for-loops staan. Hier wordt de testdata doorgegeven aan de controller. Zorg er voor dat de data wordt opgeslagen op een logische plaats in de businesslaag.
        //TODO (week 4-5) De data moet in afzonderlijke laag worden opgeslagen .
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

        //TODO (Week 3-4) Zorg ervoor dat volgende test op groen komt als je deze uitvoert.
        //  Voor de courier uit de US wordt de default selector gebruikt en zijn daarom alle leverbare orders beschikbaar.
        ctrl.setAppUser(ctrl.getCouriers().stream().filter(u -> u.getFirstName().equals("Frats")).findFirst().get());
        Collection<Order> availableDeliveries2 = ctrl.getAvailableDeliveries();
        assertEquals(3, availableDeliveries2.size(), "3 orders voldoen aan de voorwaarden");

        //TODO (Week 4-5) Uncomment onderstaande test voor Belgische couriers.
        //  Er zijn verschillende types van beschikbare orders. Twee zijn er beschikbaar.
	      //  De reden waarom wel en waarom niet staat in de DeliveryInstructions van de testdata.
	      //  Pas voor deze alternatieve filterlogica de daarvoor logische SOLID patronen toe.

        /*
        ctrl.setAppUser(ctrl.getCouriers().stream().filter(u -> u.getFirstName().equals("Frits")).findFirst().get());
        Collection<Order> availableDeliveries = ctrl.getAvailableDeliveries();
        assertEquals(2, availableDeliveries.size(), "Slechts 2 orders voldoen aan de voorwaarden");
        assertTrue(availableDeliveries.stream().anyMatch(d -> d.getDeliveryInstructions().startsWith("Na vijf minuten")));
        assertTrue(availableDeliveries.stream().anyMatch(d -> d.getDeliveryInstructions().startsWith("Binnen eerste vijf minuten, maar courier heeft meer dan gemiddelde deliveryPoints")));
        */

    }


    //TODO (Week 4-5) uncomment test selectDelivery
   @Test
    void selectDelivery() {
   /*      int orderID = ctrl.getAvailableDeliveries().stream().findFirst().get().getOrderID();
        Order selectedOrder = ctrl.selectDelivery(orderID);
        assertEquals(selectedOrder.getDeliverer(), ctrl.getAppUser());
        assertEquals(ctrl.getDeliveryPointsTotal(ctrl.getAppUser()), 501 + 5);
        assertEquals(selectedOrder.getCurrentState(), OrderState.COURIER_ASSIGNED); */
    }

    //TODO (Week 4-5): De volgende twee methoden kunnen optioneel worden uitgewerkt:  uncomment test registerDeliveryPickup en registerSuccesfullDelivery
  /*  @Test
    void registerDeliveryPickup() {
        int orderID = ctrl.getAvailableDeliveries().stream().findFirst().get().getOrderID();
        Order selectedOrder = ctrl.selectDelivery(orderID);
        selectedOrder = ctrl.registerDeliveryPickup(orderID);
        assertEquals(ctrl.getDeliveryPointsTotal(ctrl.getAppUser()), 501 + 10);
        assertEquals(OrderState.DISHES_UNDERWAY, selectedOrder.getCurrentState());
    }*/

/*    @Test
    void registerSuccesfullDelivery() {
        int orderID = ctrl.getAvailableDeliveries().stream().findFirst().get().getOrderID();
        Order selectedOrder = ctrl.selectDelivery(orderID);
        selectedOrder = ctrl.registerDeliveryPickup(orderID);
        selectedOrder = ctrl.registerSuccesfullDelivery(orderID);
        assertEquals(ctrl.getDeliveryPointsTotal(ctrl.getAppUser()), 501 + 15);
        assertEquals(OrderState.DELIVERED, selectedOrder.getCurrentState());
    }*/

}