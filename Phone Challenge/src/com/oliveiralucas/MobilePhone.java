package com.oliveiralucas;

import java.util.ArrayList;

public class MobilePhone
{

	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	private Contact contact;

	public void addNewContact(String name, String number)
	{
		Contact contact = new Contact();
		contact.addContact(name, number);
		contacts.add(contact);
	}

	public boolean hasContact(String name)
	{
		int indexOf = -1;
		for (Contact contact : contacts)
		{
			if (contact.getName().equals(name))
				indexOf = contacts.indexOf(contact);

		}

		return indexOf > -1;
	}

}
