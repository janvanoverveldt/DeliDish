package be.kdg.foundation.contact;

import java.io.Serializable;

/**
 * @author Jan de Rijke.
 */
public class City implements Serializable {
    private final String country;
    private final String postal;
    private final String name;



    public City(String postal, String name, String country) {
        this.postal = postal;
        this.name = name;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
