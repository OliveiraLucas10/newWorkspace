package com.oliveiralucas;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		System.out.println("Enter count: \r");
		int count = scanner.nextInt();
		scanner.nextLine();
		System.out.println("The minimun value is " + findMin(readIntegers(count)));
		scanner.close();
	}

	private static int[] readIntegers(int count)
	{
		int[] array = new int[count];

		System.out.println("Enter " + count + " integer values: \r");
		for (int i = 0; i < array.length; i++)
		{
			int number = scanner.nextInt();
			scanner.hasNextLine();
			array[i] = number;
		}

		return array;
	}

	private static int findMin(int[] array)
	{
		Arrays.sort(array);
		return array[0];
	}

}
