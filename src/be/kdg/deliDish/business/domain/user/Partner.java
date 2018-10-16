package be.kdg.deliDish.business.domain.user;

import be.kdg.foundation.financial.RekeningNummer;

import java.io.Serializable;

public class Partner implements Serializable {
    private RekeningNummer rekeningNummer;

    public Partner(RekeningNummer rekeningNummer) {
        this.rekeningNummer = rekeningNummer;
    }

    public RekeningNummer getRekeningNummer() {
        return rekeningNummer;
    }

    public void setRekeningNummer(RekeningNummer rekeningNummer) {
        this.rekeningNummer = rekeningNummer;
    }
}
