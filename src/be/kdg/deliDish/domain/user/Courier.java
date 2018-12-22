package be.kdg.deliDish.domain.user;


import be.kdg.deliDish.domain.user.DeliveryPointEvent.DeliveryPointEventType;
import be.kdg.foundation.contact.ContactInfo;
import be.kdg.foundation.contact.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Courier extends User {

    private Position currentPosition;
		private int currentDeliveryPointsTotal=0;

	private boolean isAvailable;
    private List<DeliveryPointEvent> pointEvents = new ArrayList<>();
    private Partner partner;

    public Courier(String firstName, String lastName, ContactInfo contactInfo, Position currentPosition, Partner partner) {
        super(firstName, lastName, contactInfo);
        this.currentPosition = currentPosition;
        this.partner = partner;
        this.isAvailable = true;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public boolean switchAvailability() {
        isAvailable = !isAvailable;
        return isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
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

	public int getDeliveryPointsTotal() {
	    return currentDeliveryPointsTotal;
	}

	public void addPointEvent(DeliveryPointEventType event) {
    	pointEvents.add(new DeliveryPointEvent(event));
			currentDeliveryPointsTotal += event.getPoints();
	}
}
