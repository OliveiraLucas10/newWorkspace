package com.oliveiralucas;

public class Main
{

	public static void main(String[] args)
	{
		Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");
		System.out.println("Total Burger price is " + hamburger.itemizeHamburger());
		hamburger.addHamburgerAddition1("Tomato", 0.27);
		hamburger.addHamburgerAddition2("Lettuce", 0.75);
		hamburger.addHamburgerAddition3("Cheese", 1.12);
		System.out.println("Total Burger price is " + hamburger.itemizeHamburger());

		HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
		healthyBurger.addHamburgerAddition1("Egg", 5.43);
		healthyBurger.addHealthAdditional1("Lentils", 3.41);
		System.out.println("Total Healthy Burger price is " + healthyBurger.itemizeHamburger());

		DeluxBurger deluxBurger = new DeluxBurger();
		deluxBurger.addHamburgerAddition3("Extra Bacon", 5.55);
		deluxBurger.itemizeHamburger();
	}

}
