package personal.sandbox;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Function 
{
	private String[] areaWords = new String[51];
	private int index = 0;
	private int areaCounter = 0;
	
	
	//displays how many areas have been completed
	public int getAreaCounter() 
	{
		return areaCounter;
	}

	//increments the amount of areas completed
	public void incrementAreaCounter() 
	{
		areaCounter++;
	}

	//loads the area names into an array for printing
	public void loadArray (String areaWord)
	{
		areaWords[index] = areaWord;
		index++;
	}
	
	public void outputArray(String file)
	{	
		try 
		{
			PrintWriter printer = new PrintWriter(new FileWriter(file, true));
			
			for(int count = 0; count < index; count++)
			{
				printer.println(areaWords[count]);
			}
			
			printer.println("Areas Completed: " + areaCounter);
			
			printer.close();
			
		}
		
		catch (IOException x)
		{
			x.printStackTrace();
		}
	}
	
	
}
