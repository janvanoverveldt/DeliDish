package be.kdg.deliDish.application;


import be.kdg.deliDish.business.domain.order.Order;
import be.kdg.deliDish.business.domain.restaurant.Restaurant;
import be.kdg.deliDish.business.domain.user.Courier;
import be.kdg.deliDish.business.domain.user.Customer;

import java.util.Collection;

/**
 * @author Jan Van Overveldt.
 */
// Dit is de controllerklasse van  Delidish. Je dient geen UI laag te implementeren. De methoden van de controller worden vanuit DeliveryControllerTest aangeroepen.
public class DeliveryController {
    //Session Info
    private Courier appUser;





        /*
    DE METHODEN HIERONDER ZIJN NODIG VOOR DE INITIALISATIE VAN HET SYSTEEM.
    #######################################################################
     */

    public Courier getAppUser() {
        return appUser;
    }

    /**
     * Sets the sessionUser
     *
     * @param appUser
     */
    public void setAppUser(Courier appUser) {
        this.appUser = appUser;
    }

    // TODO (Week 3-4): Methode implementeren (wordt gebruikt om data beschikbaar te stellen)
    public void addOrder(Order o) {

    }

    // TODO (Week 3-4): Methode implementeren (wordt gebruikt om data beschikbaar te stellen)
    public void addCourier(Courier courier) {
    }

    // TODO (Week 3-4): Methode implementeren (wordt gebruikt om data beschikbaar te stellen)
    public void addCustomer(Customer customer) {

    }

    // TODO (Week 3-4): Methode implementeren (wordt gebruikt om data beschikbaar te stellen)
    public void addResto(Restaurant restaurant) {

    }

    // TODO (Week 3-4): Methode implementeren (wordt gebruikt om data beschikbaar te stellen
    public Collection<Courier> getCouriers() {
        return null;
    }

    // TODO (Week 3-5): Methode implementeren (wordt gebruikt in een test)
    public int getDeliveryPointsTotal(Courier c) {
        return 0;
    }

           /*
    (EINDE INITIALISATIEMETHODEN)
    #####################################################################################################
     */




        /*
    DE METHODEN HIERONDER ZIJN DEGENE DIE JE UIT DIENT TE WERKEN VOOR HET PROJECT (ZIE SSD EN CONTRACTEN).
    #####################################################################################################
     */

    // TODO (Week 3-4): Dit is DE methode die in bij de eerste oplevering moest uitgewerkt worden comform de interactiediagrammen die ook worden uitgewerkt.
    // TODO (Week 4-5): In de definitieve  moet de implementatie van deze methode aangepast worden (zie beschrijving)
    public Collection<Order> getAvailableDeliveries() {

        return null;
    }

    // TODO (Week 4-5): Deze methode moet ontworpen worden voor de de definitieve oplevering. Code en diagrammen moet consistent zijn.
    public Order selectDelivery(int orderId) {
        return null;
    }
               /*
    (EINDE UIT TE WERKEN METHODEn)
    #####################################################################################################
     */

            /*
    DE METHODEN HIERONDER KAN JE OPTIONEEL NOG UITWERKEN.
    ######################################################

    // TODO (Week 4-5): Optioneel: Deze methode kan ontworpen worden voor de definitieve oplevering.
    public Order registerDeliveryPickup(int orderId) {
        return null;
    }

    // TODO (Week 4-5): Optioneel: Deze methode kan ontworpen worden voor de definitieve oplevering.
    public Order registerSuccesfullDelivery(int orderId) {
        return null;
    }
*/


}
