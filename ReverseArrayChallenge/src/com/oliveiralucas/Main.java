package com.oliveiralucas;

import java.util.Arrays;

public class Main
{

	public static void main(String[] args)
	{
		int[] myArray = {
			1,
			2,
			3,
			4,
			5
		};

		System.out.println("myArray = " + Arrays.toString(myArray));
		System.out.println("reverse myArray = " + Arrays.toString(reverse(myArray)));

	}

	private static int[] reverse(int[] myArray)
	{
		int[] reverseArray = new int[myArray.length];

		for (int i = 0; i < reverseArray.length; i++)
		{
			reverseArray[i] = myArray[(myArray.length - 1) - i];
		}

		return reverseArray;
	}

}
