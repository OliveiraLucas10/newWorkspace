package com.oliveiralucas;

public class Hamburger
{

	private String name;

	private String meat;

	private double price;

	private String breadRollType;

	private String addition1Name;

	private double additional1Price;

	private String addition2Name;

	private double additional2Price;

	private String addition3Name;

	private double additional3Price;

	private String addition4Name;

	private double additional4Price;

	public Hamburger(String name, String meat, double price, String breadRollType)
	{
		this.name = name;
		this.meat = meat;
		this.price = price;
		this.breadRollType = breadRollType;
	}

	public void addHamburgerAddition1(String name, double price)
	{
		this.addition1Name = name;
		this.additional1Price = price;
	}

	public void addHamburgerAddition2(String name, double price)
	{
		this.addition2Name = name;
		this.additional2Price = price;
	}

	public void addHamburgerAddition3(String name, double price)
	{
		this.addition3Name = name;
		this.additional3Price = price;
	}

	public void addHamburgerAddition4(String name, double price)
	{
		this.addition4Name = name;
		this.additional4Price = price;
	}

	public double itemizeHamburger()
	{
		double hamburgerPrice = this.price;

		System.out.println(this.name + " hamburger on a " + this.breadRollType + " roll with " + this.meat + " price is " + this.price);

		if (this.addition1Name != null)
		{
			hamburgerPrice += this.additional1Price;
			System.out.println("Added " + this.addition1Name + " for an extra " + this.additional1Price);
		}
		if (this.addition2Name != null)
		{
			hamburgerPrice += this.additional2Price;
			System.out.println("Added " + this.addition2Name + " for an extra " + this.additional2Price);
		}
		if (this.addition3Name != null)
		{
			hamburgerPrice += this.additional3Price;
			System.out.println("Added " + this.addition3Name + " for an extra " + this.additional3Price);
		}
		if (this.addition4Name != null)
		{
			hamburgerPrice += this.additional4Price;
			System.out.println("Added " + this.addition4Name + " for an extra " + this.additional4Price);
		}

		return hamburgerPrice;
	}

}
