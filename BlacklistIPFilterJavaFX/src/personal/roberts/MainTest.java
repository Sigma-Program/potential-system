/**
 * @author Richard Roberts
 * 
 * 
 *
 */

package personal.roberts;

import java.util.Scanner;
import personal.roberts.model.IPAddress;

public class MainTest 
{
	
	public static void main(String[] args) 
	{
		String ipList = "";
		String blacklist = "";
		char progRun = ' ';
		
		Scanner input = new Scanner (System.in);
		IPAddress function = new IPAddress();
		
		
		while (progRun != 'n')
		{
			//greeting menu
			progGreeting();
			
			//put the file inputs into a while loop.
			addressPrompt();
			
			ipList = input.next();
			
			//sends the file to a list to compare to.
			function.setIPListArray(ipList);
			System.out.println("");
			
			//here too. the program references this file to see what shows up.
			blacklistPrompt();
			
			blacklist = input.next();
			
			//sends the file to a list for comparison.
			function.setIPBlacklistArray(blacklist);
			System.out.println("");
			
			//ending statement
			if (function.getIPFileStatus() == true && function.getBlacklistStatus() == true)
			{
				function.searchBlacklist();
				progOutputMsg();
			}
			
			else
			{
				fileNotFound();
			}
			
			//either continues or exits program
			//does not have a user input check
			progRun = progCont(input);
			
			System.out.println("");
		}
		
		progFinish();
		
		input.close();

	}
	
	public static void progGreeting()
	{
		System.out.println("Please input the list of IP Addresses in the prompt below.");
		System.out.println("This program works with text files for now,");
		System.out.println("so input the name of the file for now.");
	}
	
	public static void addressPrompt()
	{
		System.out.print("File Name: ");
	}
	
	public static void blacklistPrompt()
	{
		System.out.println("now for the blacklist text file.");
		System.out.print("File name: ");
	}
	
	public static void progOutputMsg()
	{
		System.out.println("The IP addresses that showed up have been written onto");
		System.out.println("a text file called 'Results.txt'.");
	}
	
	public static void fileNotFound()
	{
		System.out.println("Files not Found. Try again.");
	}
	
	public static char progCont(Scanner input)
	{
		char select = ' ';
		
		System.out.println("Would you like to continue?");
		System.out.println("[Y] to continue");
		System.out.println("[N] to exit");
		System.out.print("Selection: ");
		select = Character.toLowerCase(input.next().charAt(0));
		
		return select;
	}
	
	public static void progFinish()
	{
		System.out.println("Program complete.");
		System.out.println("");
	}

}
