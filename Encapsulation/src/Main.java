
public class Main
{

	public static void main(String[] args)
	{
		Printer printer = new Printer(50, false);
		System.out.println("initial page count = " + printer.getPagesPrinted());
		int printPages = printer.printPages(4);
		System.out.println("Pages printed was " + printPages + " new total print count for printer = " + printer.getPagesPrinted());
		printPages = printer.printPages(2);
		System.out.println("Pages printed was " + printPages + " new total print count for printer = " + printer.getPagesPrinted());

	}

}
