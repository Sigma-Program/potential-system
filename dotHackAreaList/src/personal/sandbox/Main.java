package personal.sandbox;

import java.util.Scanner;

public class Main 
{

	
	//gathers them up and displays the prompts
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		char prgrmStart = ' ';
		
		Function function = new Function();
		
		
		prgrmStart = welcomeMenu(input);
		
		while (prgrmStart == 'Y')
		{
			System.out.println("Area name with A rank of above.");
			System.out.println("Example: hiddenForbiddenHolyGround");
			System.out.print("area word: ");
			
			function.loadArray(input.next());
			function.incrementAreaCounter();
			System.out.println("");
			
			System.out.println("are there more?");
			System.out.println("Y to continue");
			System.out.println("X to exit");
			System.out.print("input: ");
			
			prgrmStart = Character.toUpperCase(input.next().charAt(0));
			
			System.out.println("");
			
		}
		
		function.outputArray(exitMenu(input));
		
		input.close();

	}
	
	//main menu
	public static Character welcomeMenu(Scanner consoleIn)
	{
		char selection = ' ';
		
		System.out.println("This program'll help keep track of the areas with an A rank or above.");
		System.out.println("Start program?");
		System.out.println("Y to begin");
		System.out.println("X to exit");
		System.out.print("input: ");
		
		selection = Character.toUpperCase(consoleIn.next().charAt(0));
		
		System.out.println("");
		
		//main menu error input
		while (selection != 'Y' && selection != 'X')
		{
			System.out.println("error.");
			System.out.println("Try again.");
			
			System.out.println("Y to begin");
			System.out.println("X to exit");
			System.out.print("input: ");
			
			selection = Character.toUpperCase(consoleIn.next().charAt(0));
			
			System.out.println("");
		}
		
		return selection;
	}
	
	//exit display
	public static String exitMenu(Scanner consoleIn)
	{
		String name = "";
		
		System.out.println("What do you want to name the output file?");
		System.out.println("example: areaWords.txt");
		System.out.print("file name: ");
		
		name = consoleIn.next();
		
		System.out.println("");
		System.out.println("Done.");
		System.out.println("Check the file explorer to see if it's correct.");
		
		return name;
	}

}
