package be.kdg.hiFresh.domain.recept;

import org.threeten.extra.YearWeek;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jan de Rijke.
 * Weekaanbod met geordende recepten
 * Het eerste recept staat op plaats 1
 */


public class WeekAanbod {
    // TODO0: implementeer klasse

    public static final int SIZE = 10;
    private YearWeek week;
    private double prijs;
    private Map<Integer, Recept> featuredRecepts;


    public WeekAanbod(YearWeek week, double prijs) {
        // TODO0
        this.week = week;
        this.prijs = prijs;
        featuredRecepts = new HashMap<>(SIZE);
    }

    /**
     * @param recept recept dat toegevoegd moet worden
     * @param plaats plaats in de lijst. Eventueel bestaande recepten worden naar onder geshift
     * @return Indien een recept uit de lijst valt omdat het voorbij de maximum size geshift wordt,
     * wordt dit gereturned, anders returns null
     */
    public Recept voegToe(Recept recept, int plaats) {
        // TODO0
        // check if recept already added
        return featuredRecepts.put(plaats, recept);
    }

    public Map<Integer, Recept> getRecepten() {
        return featuredRecepts;
    }
}
