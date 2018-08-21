package be.kdg.deliDish.domain.courier;


import be.kdg.foundation.contact.ContactInfo;
import be.kdg.foundation.contact.Position;

public class Courier {
    private String firstName;
    private String lastName;
    private ContactInfo contactInfo;
    private Position currentPosition;
    private boolean isAvailable;

    public Courier(String firstName, String lastName, ContactInfo contactInfo, Position currentPosition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
        this.currentPosition = currentPosition;
        this.isAvailable = true;
    }

    public boolean switchAvailability() {
        isAvailable = !isAvailable;
        return isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
