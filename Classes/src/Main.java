
public class Main
{

	public static void main(String[] args)
	{
		Car porsche = new Car(3, 4, "Carrera", "BMW", "red");

		System.out.println(porsche.getDoors());
		System.out.println(porsche.getWheels());
		System.out.println(porsche.getModel());
		System.out.println(porsche.getEngine());
		System.out.println(porsche.getColour());

	}

}
