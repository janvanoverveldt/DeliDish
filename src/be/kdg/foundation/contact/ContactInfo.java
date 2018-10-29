package be.kdg.foundation.contact;

import java.io.Serializable;

/**
 * @author Jan de Rijke.
 */
public class ContactInfo implements Serializable {
    private Adress adress;
    private String email;
    private String tel;

    public ContactInfo(Adress adress, String email, String tel) {
        this.adress = adress;
        this.email = email;
        this.tel = tel;
    }

    public Adress getAdress() {
        return adress;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }
}
