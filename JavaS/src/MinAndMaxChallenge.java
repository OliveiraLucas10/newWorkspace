import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinAndMaxChallenge
{

	public static void challenge()
	{
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> values = new ArrayList<Integer>();

		while (true)
		{
			System.out.println("Enter a number: ");

			if (scanner.hasNextInt())
			{
				values.add(scanner.nextInt());
				scanner.nextLine();
			}
			else
			{
				if (values.size() > 0)
				{
					Collections.sort(values);
					System.out.println("========= RESULT =========");
					System.out.println("Minimum value is: " + values.get(0));
					System.out.println("Maximum value is: " + values.get(values.size() - 1));
				}
				else
				{
					System.out.println("There is no value");
				}
				break;
			}
		}

		scanner.close();
	}

}
