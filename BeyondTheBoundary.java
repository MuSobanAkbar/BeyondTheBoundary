import java.util.Random;
import java.util.Scanner;
public class BeyondTheBoundary
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int userRuns = 0;
		int cpuRuns = 0;
		int wicketsUser = 0;
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
		boolean out=false;

		if(tossC.equals("bowl"))
		{
			for(int i=0;i<7&&!out;i++)
			{
				System.out.println("Total Runs by CPU:" + cpuRuns +"\nBalls Left: " + (6-i)+"\nTotal Wickets: ");
				System.out.println("Please throw your ball "+ (i+1) + " (type 'throw')");
				String throwB = scanner.nextLine();
				if(throwB.equals("throw"))
				{
					int runs = r.nextInt(8);
					if(runs==8)
					{
						System.out.print("OUT!");
						out=true;
						wicketsUser++;
					}
					else 
					{
						cpuRuns+=runs;
					}
				}
				else 
				{
					System.out.println("Wide!");
					cpuRuns++;
					i--;
				}
			}
			System.out.println("Over finished.");
		}

	}
}