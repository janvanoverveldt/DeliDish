package be.kdg.foundation.operatie;

import java.util.logging.Logger;

/**
 * @author Jan de Rijke.
 * Sort wordt gebruikt om de gegevens te sorten. Voorbeeld new Sort("naam", Order.ASCENDING).
 * Dit wordt meegegeven aan de Repository die op zijn beurt op basis van deze info een gesorteerde collectie kan teruggeven.
 */
//TODO: Kan verwijderd worden.
public class Sort {
    private static Logger logger = Logger.getLogger("be.kdg.foundation.operatie.Sort");

    private String field;
    private Order order;

    public Sort(String target, Order order) {
        this.field = target;
        this.order = order;
    }

    public String getField() {
        return field;
    }

    public Order getOrder() {
        return order;
    }
}
