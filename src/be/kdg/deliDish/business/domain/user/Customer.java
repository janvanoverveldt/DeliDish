package be.kdg.deliDish.business.domain.user;

import be.kdg.foundation.contact.Adress;
import be.kdg.foundation.contact.ContactInfo;

import java.util.List;

//TODO Je mag zaken toevoegen aan deze klasse. Bestaande attributen en methodes wijzigen doe je beter niet.
public class Customer extends User {
    private List<Adress> deliveryAdresses;

    public Customer(ContactInfo primaryContactInfo, String firstName, String lastName, List<Adress> deliveryAdresses) {
        super(firstName, lastName, primaryContactInfo);
        this.deliveryAdresses = deliveryAdresses;

    }

    public List<Adress> getDeliveryAdresses() {
        return deliveryAdresses;
    }
}
