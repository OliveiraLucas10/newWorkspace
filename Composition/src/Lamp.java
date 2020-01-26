
public class Lamp
{

	private String style;

	private boolean baterry;

	private int globRating;

	public Lamp(String style, boolean baterry, int globRating)
	{
		this.style = style;
		this.baterry = baterry;
		this.globRating = globRating;
	}

	public void turnOn()
	{
		System.out.println("Lamp -> Turning on");
	}

	public String getStyle()
	{
		return style;
	}

	public boolean isBaterry()
	{
		return baterry;
	}

	public int getGlobRating()
	{
		return globRating;
	}

}
