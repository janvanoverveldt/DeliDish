package be.kdg.foundation.contact;

import java.io.Serializable;

/**
 * @author Jan de Rijke.
 */
public class Adress implements Serializable {
    private final City city;
    private final String straat;
    private final Position position;
    private final String number;

    public Adress(String straat, String nr, City city, Position position) {
        this.straat = straat;
        this.number = nr;
        this.city = city;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public City getCity() {
        return city;
    }
}
