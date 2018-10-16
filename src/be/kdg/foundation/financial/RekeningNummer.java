package be.kdg.foundation.financial;

import java.io.Serializable;
import java.util.Objects;


/**
 * DataType class
 */
public class RekeningNummer implements Serializable {
    private final String rekeningnummer;

    public RekeningNummer(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RekeningNummer that = (RekeningNummer) o;
        return Objects.equals(rekeningnummer, that.rekeningnummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rekeningnummer);
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    private boolean validate() {
        return true;
    }
}
