package be.kdg.deliDish.business.domain.user;

import be.kdg.foundation.contact.ContactInfo;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private ContactInfo contactInfo;

    public User(String firstName, String lastName, ContactInfo contactInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(firstName, user.firstName) &&
			Objects.equals(lastName, user.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
