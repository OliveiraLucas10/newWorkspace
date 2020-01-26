package com.oliveiralucas;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		printArray(sortIntegers(getIntegers(5)));
	}

	public static int[] getIntegers(int number)
	{
		int[] values = new int[number];

		System.out.println("Enter " + number + " integer values: \r");

		for (int i = 0; i < values.length; i++)
		{
			values[i] = scanner.nextInt();
		}

		return values;
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.println("Position: " + i + ", Element: " + array[i]);
		}
	}

	public static int[] sortIntegers(int[] array)
	{
		int[] reverseOrder = new int[array.length];
		Arrays.sort(array);

		for (int i = 0; i < reverseOrder.length; i++)
		{
			reverseOrder[i] = array[(array.length - 1) - i];
		}

		return reverseOrder;
	}

}
