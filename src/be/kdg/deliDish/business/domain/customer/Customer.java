package be.kdg.deliDish.business.domain.customer;

import be.kdg.foundation.contact.Adress;
import be.kdg.foundation.contact.ContactInfo;

import java.util.List;

public class Customer {
    private ContactInfo primaryContactInfo;
    private String firstName;
    private String lastName;
    private List<Adress> deliveryAdresses;

    public Customer(ContactInfo primaryContactInfo, String firstName, String lastName, List<Adress> deliveryAdresses) {
        this.primaryContactInfo = primaryContactInfo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliveryAdresses = deliveryAdresses;
    }

    public List<Adress> getDeliveryAdresses() {
        return deliveryAdresses;
    }
}
