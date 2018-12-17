package be.kdg.deliDish.domain.user;

import be.kdg.foundation.contact.Adress;
import be.kdg.foundation.contact.ContactInfo;

import java.util.List;

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
