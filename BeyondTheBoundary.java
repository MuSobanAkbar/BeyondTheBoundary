import java.util.Random;
import java.util.Scanner;
public class BeyondTheBoundary
{
	public static void main(String [] args)
	{
		Random r = new Random();
		int possibility = r.nextInt(2);

		if(possibility == 1)
		{
			System.out.println("You are batting");
		}
		else
		{
			System.out.println("You are bowling");
		}
	}
}