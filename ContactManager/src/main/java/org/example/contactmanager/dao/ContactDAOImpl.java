package org.example.contactmanager.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.example.contactmanager.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private EntityManagerFactory  entityManagerFactory;

	public void addContact(Contact contact) {
		System.out.println("add");
		entityManagerFactory.createEntityManager().persist(contact);
	}

	@SuppressWarnings("unchecked")
	public List<Contact> listContact() {

		return entityManagerFactory.createEntityManager().createQuery("from Contact")
			.getResultList();
	}

	public void removeContact(Integer id) {
		Contact contact = (Contact) entityManagerFactory.createEntityManager().find(
				Contact.class, id);
		if (null != contact) {
			entityManagerFactory.createEntityManager().remove(contact);
		}

	}
}
