import java.util.Random;
import java.util.Scanner;
public class BeyondTheBoundary
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Heads or Tails? (H/T): ");
		int choice = 0;
		String tossC = scanner.nextLine().toUpperCase();
		if(tossC.equals("H"))
		{
			choice=0;
		}
		else if(tossC.equals("T"))
		{
			choice=1;
		}
		Random r = new Random();
		int possibility = r.nextInt(2);
		if(possibility == choice)
		{
			System.out.println("You have won the toss!");
		}
		else
		{
			if(possibility==1)
			{
				tossC = "bat";
			}
			else
			{
				tossC = "bowl";
			}
			System.out.println("You have lost the toss, the opposing team has decided to "+ tossC);
		}
	}
}