import java.util.Calendar;
import java.util.Scanner;

public class ReadingUserInput
{

	public static void scann()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your year of birth:");
		int yearOfBirth = scanner.nextInt();
		scanner.nextLine(); // handle next line character (enter key)

		System.out.println("Enter your name: ");
		String name = scanner.nextLine();

		int age = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth;

		System.out.println("Your name is " + name);
		System.out.println("And you are " + age + " years old.");
		scanner.close();
	}

}
