package com.oliveiralucas;

import java.util.ArrayList;

public class GroceryList
{

	private ArrayList<String> groceryList = new ArrayList<String>();

	public void addGroceryItem(String item)
	{
		groceryList.add(item);
	}

	public void printGroceryList()
	{
		System.out.println("You have " + groceryList.size() + " items in your grocery list.");
		for (int i = 0; i < groceryList.size(); i++)
		{
			System.out.println((i + 1) + ". " + groceryList.get(i));
		}
	}

	public void modifyGroceryItem(int position, String newItem)
	{
		groceryList.set(position, newItem);
		System.out.println("Grocery item " + (position + 1) + " has been modified");
	}

	public void modifyGroceryItem(String newItem)
	{
		int position = groceryList.indexOf(newItem);
		if (position > -1)
		{
			this.modifyGroceryItem(position, newItem);
		}
		else
		{
			System.out.println("This item couldn't to be find.");
		}
	}

	public void removeGroceryItem(String item)
	{
		int position = groceryList.indexOf(item);
		if (position > -1)
		{
			this.removeGroceryItem(position);
		}
		else
		{
			System.out.println("This item couldn't to be find.");
		}
	}

	public void removeGroceryItem(int position)
	{
		String theItem = groceryList.get(position);
		groceryList.remove(position);
		System.out.println(theItem + " was removed.");
	}

	public String findItem(String searchItem)
	{
		// boolean contains = groceryList.contains(searchItem);
		int indexOf = groceryList.indexOf(searchItem);
		if (indexOf > -1)
			return groceryList.get(indexOf);

		return null;

	}
}
