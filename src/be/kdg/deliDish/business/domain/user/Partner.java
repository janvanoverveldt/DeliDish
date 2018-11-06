package be.kdg.deliDish.business.domain.user;

import be.kdg.foundation.financial.RekeningNummer;

import java.io.Serializable;

//TODO Je mag zaken toevoegen aan deze klasse. Bestaande attributen en methodes wijzigen doe je beter niet.
public class Partner implements Serializable {
    private RekeningNummer rekeningNummer;

    public Partner(RekeningNummer rekeningNummer) {
        this.rekeningNummer = rekeningNummer;
    }


}
