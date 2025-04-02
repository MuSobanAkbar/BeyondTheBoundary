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
		boolean userStarting = false;
		String f ="";
		String userChoice ="";
		System.out.println("Heads or Tails? (H/T): ");
		int choice = 0;
		String tossC = scanner.nextLine().toUpperCase();
		if(tossC.equals("H"))
		{
			choice=0;
			f = "Heads";
		}
		else if(tossC.equals("T"))
		{
			choice=1;
			f="Tails";
		}
		Random r = new Random();
		int possibility = r.nextInt(2);

		if(possibility == choice)
		{

			userStarting=true;
			System.out.println("You have won the toss!");
			System.out.println("What would you like to pick (BAT/BOWL)?: ");
			userChoice = scanner.nextLine().toUpperCase();
		}
		else
		{
			userStarting=false;
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

		if(tossC.equals("bat")||userChoice.equals("BOWL"))
		{
			for(int i=0;i<6&&!out;i++)
			{
				System.out.println("Total Runs by CPU:" + cpuRuns +"\nBalls Left: " + (6-i)+"\nTotal Wickets: ");
				System.out.println("Please throw your ball "+ (i+1) + " (type 'throw'): ");
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
		else if(tossC.equals("bowl")||userChoice.equals("BAT"))
		{
			for(int i =0;i<6&&!out;i++)
			{
				System.out.println("Total Runs by you:" + userRuns +"\nBalls Left: " + (6-i)+"\nTotal Wickets: ");
				System.out.println("Please pick a batting style for ball "+ (i+1) + " (type 'strong'/'defense'): ");
				String run = scanner.nextLine().toLowerCase();
				if(run.equals("strong"))
				{
					int runsU = r.nextInt(4 - 7)+4;
					userRuns+=runsU;
				}
				else if(run.equals("defense"))
				{
					int runsU = r.nextInt(0-5)+5;
					userRuns+=runsU;
				}
				else
				{
					System.out.println("Oops, you've been bowled.");
					out=true;
				}
			}
		}
		System.out.println("Over finished.");

	}
}