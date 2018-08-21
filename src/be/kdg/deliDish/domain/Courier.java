package be.kdg.hiFresh.domain;

import be.kdg.foundation.contact.Adres;
import be.kdg.foundation.contact.ContactInfo;
import be.kdg.foundation.contact.Position;

import java.util.List;

public class Courier {
    private String firstName;
    private String lastName;
    private ContactInfo contactInfo;
    private List<Adres> deliveryAdresses;
    private Position currentPosition;
}
