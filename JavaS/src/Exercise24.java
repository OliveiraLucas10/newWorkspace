
public class Exercise24
{

	public static boolean canPack(int bigCount, int smallCount, int goal)
	{

		int bigBag = 5, smallBag = 1;

		bigCount = bigCount * bigBag;
		smallCount = smallCount * smallBag;

		if (bigCount < 0 || smallCount < 0 || goal < 0)
		{
			return false;
		}
		else if ((bigCount > goal && (bigCount % goal) > 0) || (bigCount + smallCount) < goal)
		{
			return false;
		}

		return true;
	}

}
