package be.kdg.foundation.contact;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * @author Jan de Rijke.
 */
public class City implements Serializable {
    private static Logger logger = Logger.getLogger("be.kdg.foundation.contact.Gemeente");
    private final String postal;
    private final String name;
    private final String country;

    public City(String postal, String name, String country) {
        this.postal = postal;
        this.name = name;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
