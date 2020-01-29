package com.oliveiralucas;

import java.util.ArrayList;

public class GroceryList
{

	private ArrayList<String> groceryList = new ArrayList<String>();
	

	
	public ArrayList<String> getGroceryList()
	{
		return groceryList;
	}

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

	private void modifyGroceryItem(int position, String newItem)
	{
		groceryList.set(position, newItem);
		System.out.println("Grocery item " + (position + 1) + " has been modified");
	}

	public void modifyGroceryItem(String currentItem, String newItem)
	{
		int position = findItem(currentItem);
		if (position > -1)
		{
			this.modifyGroceryItem(position, newItem);
		}
	}

	public void removeGroceryItem(String item)
	{
		int position = findItem(item);
		if (position > -1)
		{
			this.removeGroceryItem(position);
		}
		else
		{
			System.out.println("This item couldn't to be find.");
		}
	}

	private void removeGroceryItem(int position)
	{
		String theItem = groceryList.get(position);
		groceryList.remove(position);
		System.out.println(theItem + " was removed.");
	}

	private int findItem(String searchItem)
	{
		return groceryList.indexOf(searchItem);
	}
	
	public boolean onFile(String searchItem)
	{
		return findItem(searchItem) > -1;
	}
}
