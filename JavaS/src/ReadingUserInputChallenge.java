import java.util.Scanner;

public class ReadingUserInputChallenge
{

	public static void challenge()
	{
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		int sum = 0;

		while (true)
		{
			System.out.println("Enter number #" + (counter + 1) + ":");

			boolean hasNextInt = scanner.hasNextInt();
			if (hasNextInt)
			{
				int number = scanner.nextInt();
				counter++;
				sum += number;
				if (counter == 10)
				{
					break;
				}
			}
			else
			{
				System.out.println("Invalidnnumber.");
			}
			scanner.nextLine();
		}

		System.out.println("Sum: " + sum);

		scanner.close();
	}

}
