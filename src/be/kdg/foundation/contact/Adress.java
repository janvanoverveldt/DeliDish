package be.kdg.foundation.contact;

import java.util.logging.Logger;

/**
 * @author Jan de Rijke.
 */
public class Adress {
    private static Logger logger = Logger.getLogger("be.kdg.foundation.contact.Adres");
    private final Gemeente gemeente;
    private final String nummer;
    private final String straat;
    private final Position position;

    public Adress(String straat, String nr, Gemeente gemeente, Position position) {
        this.straat = straat;
        this.nummer = nr;
        this.gemeente = gemeente;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
