
public class Floor
{

	private double width;

	private double length;

	public Floor(double with, double length)
	{
		super();
		this.width = with < 0 ? 0 : with;
		this.length = length < 0 ? 0 : length;
	}
	
	public double getArea()
	{
		return this.width * this.length;
	}

}
