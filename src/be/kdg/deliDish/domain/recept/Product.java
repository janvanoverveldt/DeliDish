package be.kdg.hiFresh.domain.recept;


import be.kdg.foundation.qualified.Hoeveelheid;

import java.time.MonthDay;

/**
 * @author Jan de Rijke.
 */
public class Product {

    // TODO: implementeer klasse
    private String naam;
    private MonthDay beginHoogseizoen;
    private MonthDay eindHoogseizoen;
    private Hoeveelheid eenheid;


    public Product(String naam, MonthDay startHoogseizoen, MonthDay eindeHoogseizoen, Hoeveelheid
            stdHoeveelheid) {
        // TODO0
        this.naam = naam;
        this.beginHoogseizoen = startHoogseizoen;
        this.eindHoogseizoen = eindeHoogseizoen;
        this.eenheid = stdHoeveelheid;

    }

    public Product(String naam, Hoeveelheid stdHoeveelheid) {
        // TODO0
        this.naam = naam;
        this.eenheid = stdHoeveelheid;
    }

    public Hoeveelheid getStandaardHoeveelheid() {
        // TODO0:
        return eenheid;
    }

    // Getters & Setters
    public String getNaam() {
        return naam;
    }
}
