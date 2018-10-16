package be.kdg.foundation.contact;

import java.io.Serializable;

/**
 * @author Jan de Rijke.
 */
public class ContactInfo implements Serializable {
    // TODO0: implementeer klasse
    private Adress adres;
    private String email;
    private String tel;

    public ContactInfo(Adress adres, String email, String tel) {
        this.adres = adres;
        this.email = email;
        this.tel = tel;
    }
}
