package be.kdg.deliDish.application;

import be.kdg.deliDish.domain.business.AvailableDeliveriesService;
import be.kdg.deliDish.domain.business.BelgianAvailableDeliveriesService;
import be.kdg.deliDish.domain.order.Order;
import org.junit.Before;

/**
 * In de test methoden van deze klasse mag je niks veranderen
 *
 * @author Jan de Rijke.
 */
public class DeliveryControllerTest {
    private DeliveryController ctrl;
    private AvailableDeliveriesService ads;

    @Before
    public void setUp() {
        // TODO0 initialiseer het systeem
        TestData data = new TestData();

        ctrl = new DeliveryController();
        ads = new BelgianAvailableDeliveriesService(ctrl.getCourierCatalog(), ctrl.getOrderCatalog());

        // TODO0 Voeg de testdata toe aan het systeem.
        // De TestData zijn beschikbaar in collections via de getter methoden van TestData
        // Na de initialisatie mag de TestData klasse niet meer gebruikt worden.
        // Tijdens de test en in de project code moet al deze data opgezocht worden via het systeem
        // 1. Contracten worden opgesteld.

        for (Order order : data.getOrders()) {
            ctrl.addOrder(order);
        }

        // 2. Producten worden opgesteld en aan contractperiodes gekoppeld.
        // 3. Met behulp van de aangemaakte producten worden recepten opgesteld.


    }


}