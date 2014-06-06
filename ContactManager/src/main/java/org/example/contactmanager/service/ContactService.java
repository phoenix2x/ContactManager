package org.example.contactmanager.service;

import java.util.List;
import org.example.contactmanager.domain.Contact;

public interface ContactService {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}
