package com.oliveiralucas;

import java.util.ArrayList;

public class MobilePhone
{

	private ArrayList<Contact> contacts = new ArrayList<>();

	private Contact contact;

	public boolean addNewContact(String name, String number)
	{
		if (hasContact(name) > -1)
		{
			return false;
		}
		else
		{

			Contact contact = new Contact();
			contact.addContact(name, number);
			contacts.add(contact);
			return true;

		}
	}

	public int hasContact(String name)
	{
		for (Contact contact : contacts)
		{
			if (contact.getName().equals(name))
			{
				return contacts.indexOf(contact);
			}
		}

		return -1;
	}

	public void modifyContact(String name, String number, int indesxOf)
	{
		Contact contacToModify = contacts.get(indesxOf);
		contacToModify.setName(name);
		contacToModify.setNumber(number);
	}

	public void listContactsNames()
	{
		if (contacts.size() > 0)
		{
			System.out.print("Contacts names: \n");
			for (Contact contact : contacts)
			{
				System.out.println(contact.getName());
			}
		}
		else
		{
			System.out.println("There isn't any contact in the list.");
		}
	}

	public void remove(int index)
	{
		contacts.remove(index);
	}

	public String[] getAllInformation(int index)
	{
		String[] info = {
			contacts.get(index).getName(),
			contacts.get(index).getNumber()
		};

		return info;
	}

}
