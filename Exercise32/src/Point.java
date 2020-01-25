public class Point
{

	private int x;

	private int y;

	public Point(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

	public Point()
	{
		super();
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public double distance()
	{
		return distance(0, 0);
	}

	public double distance(int x, int y)
	{
		double xDistance = x - this.x;
		double yDistance = y - this.y;

		return Math.sqrt(((xDistance * xDistance) + (yDistance * yDistance)));
	}

	public double distance(Point p)
	{
		return distance(p.getX(), p.getY());
	}

}