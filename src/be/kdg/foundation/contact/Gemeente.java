package be.kdg.foundation.contact;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * @author Jan de Rijke.
 */
public class Gemeente implements Serializable {
    private static Logger logger = Logger.getLogger("be.kdg.foundation.contact.Gemeente");
    private final String postnummer;
    private final String gemeente;

    public Gemeente(String s, String gemeente) {
        postnummer = s;
        this.gemeente = gemeente;
    }
}
