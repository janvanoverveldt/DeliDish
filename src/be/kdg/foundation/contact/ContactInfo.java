package be.kdg.foundation.contact;

/**
 * @author Jan de Rijke.
 */
public class ContactInfo {
    // TODO0: implementeer klasse
    private Adres adres;
    private String email;
    private String[] tel;

    public ContactInfo(Adres adres, String email, String... tel) {
        this.adres = adres;
        this.email = email;
        this.tel = tel;
    }
}
