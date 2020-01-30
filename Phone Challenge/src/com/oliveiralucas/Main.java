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
			System.out.println("\n");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
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
					// removeContact();
					break;
				case 4:
					// searchContactName();
					break;
				case 5:
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
		System.out.println("\t 5 - To quit the aplication.");

	}

	private static void addNewContact()
	{
		System.out.print("Please enter the name:");
		String name = scanner.nextLine();
		System.out.print("Please enter the number: ");
		String number = scanner.nextLine();
		mobilePhone.addNewContact(name, number);
		System.out.println("Contact add successfuly");
	}

	private static void modifyContact()
	{
		System.out.print("Enter the contact to be modified: ");
		String name = scanner.nextLine();
		if (mobilePhone.hasContact(name))
		{

		}
		else
		{
			System.out.println(name + " couldn't be found in the contact list.");
		}
	}

}
