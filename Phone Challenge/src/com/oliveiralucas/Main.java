package com.oliveiralucas;

import java.util.Scanner;

public class Main
{

	private static Scanner scanner = new Scanner(System.in);

	private static MobilePhone mobilePhone = new MobilePhone();

	public static void main(String[] args)
	{

		System.out.println("Welcome to iLucas: ");

		boolean quit = false;
		int choice = 0;
		printOptions();

		while (!quit)
		{
			System.out.print("\nEnter your choice: ");
			choice = scanner.nextInt();
			System.out.print("\n");
			scanner.nextLine();

			switch (choice)
			{
				case 0:
					printOptions();
					break;
				case 1:
					addNewContact();
					break;
				case 2:
					modifyContact();
					break;
				case 3:
					removeContact();
					break;
				case 4:
					searchContactName();
					break;
				case 5:
					mobilePhone.listContactsNames();
					break;
				case 6:
					quit = true;
					break;
			}
		}

	}

	private static void printOptions()
	{
		System.out.println("\nPress: ");
		System.out.println("\t 0 - To print choice options.");
		System.out.println("\t 1 - To add a new contact.");
		System.out.println("\t 2 - To modify a contact by name.");
		System.out.println("\t 3 - To remove a contact by name.");
		System.out.println("\t 4 - To search a contact by name.");
		System.out.println("\t 5 - To list all contacts names.");
		System.out.println("\t 6 - To quit the aplication.");

	}

	private static void addNewContact()
	{
		System.out.print("Please enter the name:");
		String name = scanner.nextLine();
		System.out.print("Please enter the number: ");
		String number = scanner.nextLine();
		while (!mobilePhone.addNewContact(name, number))
		{
			System.out.print("This name already exist in the list, please enter a new name: ");
			name = scanner.nextLine();
		}
		System.out.println("Contact add successfuly");

	}

	private static void modifyContact()
	{
		System.out.print("Enter the contact to be modified: ");
		String name = scanner.nextLine();
		int hasContact = mobilePhone.hasContact(name);
		if (hasContact > -1)
		{
			System.out.print("Please enter the new name: ");
			name = scanner.nextLine();
			System.out.print("Please enter the new number: ");
			String number = scanner.nextLine();
			mobilePhone.modifyContact(name, number, hasContact);
			System.out.println("Contact modified successfully");
		}
		else
		{
			System.out.println(name + " couldn't be found in the contact list.");
		}
	}

	private static void removeContact()
	{
		System.out.print("Enter the contact to be removed: ");
		String name = scanner.nextLine();
		int hasContact = mobilePhone.hasContact(name);
		if (hasContact > -1)
		{
			mobilePhone.remove(hasContact);
			System.out.println("Contact removed successfully");
		}
		else
		{
			System.out.println(name + " couldn't be found in the contact list.");
		}

	}

	private static void searchContactName()
	{
		System.out.print("Enter the contact name to get all information: ");
		String name = scanner.nextLine();
		int hasContact = mobilePhone.hasContact(name);
		if (hasContact > -1)
		{
			String[] allInformation = mobilePhone.getAllInformation(hasContact);
			System.out.println("Contact name: " + allInformation[0]);
			System.out.println("Contact number: " + allInformation[1]);
		}
		else
		{
			System.out.println(name + " couldn't be found in the contact list.");
		}
	}

}
