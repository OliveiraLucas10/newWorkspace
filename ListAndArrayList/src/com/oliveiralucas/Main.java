package com.oliveiralucas;

import java.util.Scanner;

public class Main
{

	private static Scanner scanner = new Scanner(System.in);

	private static GroceryList groceryList = new GroceryList();

	public static void main(String[] args)
	{
		boolean quit = false;
		int choice = 0;
		printInstructions();

		while (!quit)
		{
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice)
			{
				case 0:
					printInstructions();
					break;
				case 1:
					groceryList.printGroceryList();
					break;
				case 2:
					addItem();
					break;
				case 3:
					modifyItem();
					break;
				case 4:
					removeItem();
					break;
				case 5:
					searchForItem();
					break;
				case 6:
					quit = true;
					System.out.println("Exite...");
					break;
			}
		}

	}

	private static void searchForItem()
	{
		System.out.println("\nPlease type the item to be finded: ");
		String findItem = groceryList.findItem(scanner.nextLine());
		if (findItem != null)
		{
			System.out.println(findItem + " was finded.");
		}
		else
		{
			System.out.println("This item couldn't to be find.");
		}
		printInstructions();

	}

	private static void removeItem()
	{
		System.out.println("\nPlease type the item to be deleted: ");
		groceryList.removeGroceryItem(scanner.nextLine());
		printInstructions();

	}

	private static void modifyItem()
	{
		System.out.println("\nPlease type the item to be modify: ");
		groceryList.modifyGroceryItem(scanner.nextLine());
		printInstructions();
	}

	private static void addItem()
	{
		System.out.println("\nPlease type the new item: ");
		groceryList.addGroceryItem(scanner.nextLine());
		printInstructions();

	}

	private static void printInstructions()
	{
		System.out.println("\nPress: ");
		System.out.println("\t 0 - To print choice options.");
		System.out.println("\t 1 - To print the list of grocery items.");
		System.out.println("\t 2 - To add an item to the list.");
		System.out.println("\t 3 - To modify an item in the list.");
		System.out.println("\t 4 - To remove an item from the list.");
		System.out.println("\t 5 - To search from an item in the list.");
		System.out.println("\t 6 - To quit the aplication.");

	}

}
