import java.util.Scanner;

public class Exercise27
{

	public static void inputThenPrintSumAndAverage()
	{
		Scanner scanner = new Scanner(System.in);

		int sum = 0, counter = 0;
		double average = 0d;

		while (true)
		{
			if (scanner.hasNextInt())
			{
				counter++;
				sum += scanner.nextInt();
				scanner.hasNextLine();
			}
			else
			{
				break;
			}
		}


		if (counter > 0)
		{
			average = (double) Math.round((double) sum/counter);
			
		}

		System.out.println("SUM = " + sum + " AVG = " + (int)average);

		scanner.close();
	}
}
