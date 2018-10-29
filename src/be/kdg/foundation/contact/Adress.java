package be.kdg.foundation.contact;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * @author Jan de Rijke.
 */
public class Adress implements Serializable {
    private static Logger logger = Logger.getLogger("be.kdg.foundation.contact.Adres");
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
