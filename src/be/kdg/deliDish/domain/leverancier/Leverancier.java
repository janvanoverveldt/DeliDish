package be.kdg.hiFresh.domain.leverancier;

import be.kdg.foundation.contact.ContactInfo;

import java.util.logging.Logger;

/**
 * @author Jan de Rijke.
 */
public class Leverancier {
    private static Logger logger = Logger.getLogger("be.kdg.hiFresh.domain.leverancier.Leverancier");
    private final double reputatie;
    private final String btwNummer;
    private final ContactInfo contact;
    private final String naam;

    public Leverancier(String boer, ContactInfo contactInfo, String btw, double reputatie) {
        this.naam = boer;
        this.contact = contactInfo;
        this.btwNummer = btw;
        this.reputatie = reputatie;
    }
}
