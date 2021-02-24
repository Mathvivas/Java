package br.maua;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactManagerTest {

    @Test
    public void shouldCreateContact() {
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("Johnny", "Silverhand", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
            .filter(contact -> contact.getFirstName().equals("Johnny") &&
                    contact.getLastName().equals("Silverhand") &&
                    contact.getPhoneNumber().equals("0123456789"))
            .findAny()
            .isPresent());
    }
}
