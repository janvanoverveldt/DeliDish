package be.kdg.deliDish.application;

import be.kdg.deliDish.domain.leverancier.Contract;
import be.kdg.deliDish.domain.recept.Recept;
import be.kdg.deliDish.domain.recept.WeekAanbod;
import org.junit.Before;

/**
 * In de test methoden van deze klasse mag je niks veranderen
 *
 * @author Jan de Rijke.
 */
public class BackOfficeControllerTest {
    private BackOfficeController ctrl;


    @Before
    public void setUp() {
        // TODO0 initialiseer het systeem
        TestData data = new TestData();
        ctrl = new BackOfficeController();
        // TODO0 Voeg de testdata toe aan het systeem.
        // De TestData zijn beschikbaar in collections via de getter methoden van TestData
        // Na de initialisatie mag de TestData klasse niet meer gebruikt worden.
        // Tijdens de test en in de project code moet al deze data opgezocht worden via het systeem
        // 1. Contracten worden opgesteld.

        for (Contract contract : data.getContracten()) {
            ctrl.addContract(contract);
            // TODO important!! contract Testdata geeft slechts 3 contracten terug met slechts één contractPeriode!!!
        }
        // 2. Producten worden opgesteld en aan contractperiodes gekoppeld.
        // 3. Met behulp van de aangemaakte producten worden recepten opgesteld.


        for (Recept recept : data.getRecepten()) {
            ctrl.addRecept(recept);
        }
        // 4. Weekaanboden worden aangemaakt	}


        for (WeekAanbod week : data.getPlanning()) {
            ctrl.addWeekToAanbod(week);
        }
    }


}