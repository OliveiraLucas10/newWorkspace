package com.oliveiralucas;

import java.util.Scanner;

public class Main
{

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		int[] myIntegers = getIntegers(5);
		for (int i = 0; i < myIntegers.length; i++)
		{
			System.out.println("Element " + i + ", typed value was " + myIntegers[i]);
		}

		System.out.println("The average is " + getAverage(myIntegers));
	}

	private static double getAverage(int[] myIntegers)
	{
		double sum = 0;
		for (int i = 0; i < myIntegers.length; i++)
		{
			sum += myIntegers[i];
		}

		return sum / myIntegers.length;
	}

	private static int[] getIntegers(int number)
	{
		int[] values = new int[number];

		System.out.println("Enter " + number + " integer values. \r");
		for (int i = 0; i < values.length; i++)
		{
			values[i] = scanner.nextInt();
		}

		return values;
	}

}
