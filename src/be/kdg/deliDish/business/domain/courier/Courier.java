package be.kdg.deliDish.business.domain.courier;


import be.kdg.foundation.contact.ContactInfo;
import be.kdg.foundation.contact.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Courier {
    private String firstName;
    private String lastName;
    private ContactInfo contactInfo;
    private Position currentPosition;
    private boolean isAvailable;
    private List<DeliveryPointEvent> pointEvents = new ArrayList<>();

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

    public void addPointEvent(DeliveryPointEvent e) {
        pointEvents.add(e);
    }

    public Collection<DeliveryPointEvent> getDeliveryPointEvents() {
        return pointEvents;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setAvailable(boolean available) {

        isAvailable = available;
    }
}
