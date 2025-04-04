import java.util.Random;
import java.util.Scanner;
/**
 * Next steps:
 * - Add the option to see how many runs have just been added exactly.
 * - Add the option to get a stats screen in the end. 
 * - Add the option to loop and play again.
 * - Add the option for bowling types.
 * - If bowling types is added, then follow with making combinations as to which batsmen 
 * handles which bowler good or bad vice versa.
 * 
 * */
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
				System.out.println("\nTotal Runs by CPU:" + cpuRuns +"\nBalls Left: " + (6-i)+"\nTotal Wickets: ");
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

			// next over beginning 
				for(int i =0;(i<6&&!out)||userRuns>cpuRuns;i++)
				{
					System.out.println("\nTotal Runs by you:" + userRuns +"\nBalls Left: " + (6-i)+"\nRuns left to chase: " + (cpuRuns-userRuns));
					System.out.println("Please pick a batting style for ball "+ (i+1) + " (type 'strong'/'defense'): ");
					String run = scanner.nextLine().toLowerCase();
					if(run.equals("strong"))
					{
						int runsU = r.nextInt(3)+4;
						userRuns+=runsU;
					}
					else if(run.equals("defense"))
					{
						int runsU = r.nextInt(5);
						userRuns+=runsU;
					}
					else
					{
						System.out.println("Oops, you've been bowled.");
						out=true;
					}
				}
				if(userRuns==cpuRuns)
				{
					System.out.println("It's a draw.");
				}
				else if(userRuns>cpuRuns)
				{
					System.out.println("You have won.");
				}
				else
				{
					System.out.println("You lost.");
				}
		}
		else if(tossC.equals("bowl")||userChoice.equals("BAT"))
		{
			for(int i =0;i<6&&!out;i++)
			{
				System.out.println("\nTotal Runs by you:" + userRuns +"\nBalls Left: " + (6-i)+"\nTotal Wickets: ");
				System.out.println("Please pick a batting style for ball "+ (i+1) + " (type 'strong'/'defense'): ");
				String run = scanner.nextLine().toLowerCase();
				if(run.equals("strong"))
				{
					int runsU = r.nextInt(3)+4;
					userRuns+=runsU;
				}
				else if(run.equals("defense"))
				{
					int runsU = r.nextInt(5);
					userRuns+=runsU;
				}
				else
				{
					System.out.println("Oops, you've been bowled.");
					out=true;
				}
			}
			//next over begins
			for(int i=0;(i<6&&!out)||cpuRuns>userRuns;i++)
			{
				System.out.println("\nTotal Runs by CPU:" + cpuRuns +"\nBalls Left: " + (6-i)+"\nTotal needed to chase: " + userRuns);
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
			if(userRuns==cpuRuns)
			{
				System.out.println("It's a draw.");
			}
			else if(cpuRuns>userRuns)
			{
				System.out.println("You have won.");
			}
			else
			{
				System.out.println("You lost.");
			}

		}
		System.out.println("Over finished.");


	}
}