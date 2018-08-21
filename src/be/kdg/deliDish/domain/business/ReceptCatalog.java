package be.kdg.hiFresh.domain.business;

import be.kdg.foundation.operatie.Operatie;
import be.kdg.foundation.operatie.Sort;
import be.kdg.hiFresh.domain.recept.Recept;
import be.kdg.infra.MemoryRepository;
import be.kdg.infra.ReceptMemoryRepository;

import java.util.*;
import java.util.function.Predicate;

public class ReceptCatalog {
    private final MemoryRepository<Recept> recepten = new ReceptMemoryRepository();

    public void addRecept(Recept recept) {
        recepten.put(recept);
    }

    public Map<Recept, Double> findRecipe(int jaar, int week, List<Operatie> filter, List<Sort> sorter) {
        // Deze functie krijgt een aantal parameters binnen om recepten te vinden op !!jaar, !!week, een lijst van zoekquerry's en een lijst sorteeropties
        // !!parameters mogen genegeerd worden
        Map<Recept, Double> requestedRecipe = new HashMap<>();
        List<Recept> requestedItems = new LinkedList<>();


        //TODO functie werkt nog niet volledig => filter en sorteer opdrachten uitweken (werkt soms na meerdere keren runnen)
        requestedItems.addAll(
                recepten.findWhere(new Predicate<Recept>() {
                    @Override
                    public boolean test(Recept recept) {
                        // System.out.println("Naam: " + recept.getNaam() + "; filter: " + filter.get(0).getValue() + "; compare: " + recept.getNaam().toLowerCase().contains(filter.get(0).getValue().toLowerCase())); // geeft test weer
                        return recept.getNaam().toLowerCase().contains(filter.get(0).getValue().toLowerCase());
                    }
                }, new Comparator<Recept>() {
                    @Override
                    public int compare(Recept o1, Recept o2) {
                        return o1.getNaam().compareTo(o2.getNaam());
                        // TODO sorteren werkt de helft van de tijd
                    }
                }));

        //requestedItems.stream().forEach(recept -> System.out.println(recept.getNaam())); // Geeft gevonden waardes terug
        requestedItems.stream().forEach(recept -> {
            requestedRecipe.put(recept, 5.11);//recept.getPrijsPP()); // TODO Waarde vast geïmplementeerd => code uitschrijven voor prijs te berekenen
        });
        return requestedRecipe;
    }

}

