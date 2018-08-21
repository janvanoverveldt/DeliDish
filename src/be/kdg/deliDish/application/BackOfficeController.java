package be.kdg.deliDish.application;


import be.kdg.deliDish.domain.business.ContractCatalog;
import be.kdg.deliDish.domain.business.ReceptCatalog;
import be.kdg.deliDish.domain.business.WeekAanbodCatalog;
import be.kdg.deliDish.domain.leverancier.Contract;
import be.kdg.deliDish.domain.recept.Recept;
import be.kdg.deliDish.domain.recept.WeekAanbod;
import be.kdg.foundation.operatie.Operatie;
import be.kdg.foundation.operatie.Sort;

import java.util.List;
import java.util.Map;

/**
 * @author Jan de Rijke.
 */
// Dit is de controllerklasse van het BackOffice subsysteem
public class BackOfficeController {

    private static int WEEK_PAGE_SIZE = 2;    // Constante die vastlegt hoeveel weken weekaanbod wordt teruggegeven.
    private ContractCatalog contractCatalog;
    private ReceptCatalog receptCatalog;
    private WeekAanbodCatalog weekAanbodCatalog;

    public BackOfficeController() {
        contractCatalog = new ContractCatalog();
        receptCatalog = new ReceptCatalog();
        weekAanbodCatalog = new WeekAanbodCatalog();
    } //TODO0 indien nodig

    public List<WeekAanbod> getLijstWeekaanbod() {
        // TODO0
        return weekAanbodCatalog.getWeekData(WEEK_PAGE_SIZE);
        //return null; //placeholder om compileerbaar te maken
    }

    public Map<Recept, Double> zoekRecepten(int jaar, int week, List<Operatie> filter, List<Sort> sorter) {
        // TODO
        // enkel testen op filter en sorter moeten werken
        return receptCatalog.findRecipe(jaar, week, filter, sorter);
        //return null; //placeholder om compileerbaar te maken
    }


    //Add Test Values Code
    public void addContract(Contract contract) {
        contractCatalog.addContract(contract);
    }

    public void addRecept(Recept recept) {

        receptCatalog.addRecept(recept);
        berekenPrijsRecepten(recept);
    }

    public void addWeekToAanbod(WeekAanbod week) {
        weekAanbodCatalog.addWeekAanbod(week);
    }

    private Double berekenPrijsRecepten(Recept recept) {
        return recept.berekenPrijsPerPersoon(contractCatalog);
    }
}
