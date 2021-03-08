/**
 * @author Richard Roberts
 * 
 * 
 *
 */

package personal.roberts.model;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;


public class IPAddress 
{
	private int match = 0;
	private boolean IPFileFound = false;
	private boolean blacklistIPFileFound = false;
	private ArrayList <String> ipList = new ArrayList<String>();
	private ArrayList <String> ipBlackList = new ArrayList<String>();
	
	
	public int getMatch()
	{
		return match;
	}
	
	public boolean getIPFileStatus()
	{
		return IPFileFound;
	}
	
	public boolean getBlacklistStatus()
	{
		return blacklistIPFileFound;
	}
	
	
	//this brings in the IP address file into the program's array
	public void setIPListArray(String file)
	{
		try
		{
			Scanner infile = new Scanner(new FileInputStream(file));
			
			while (infile.hasNext())
			{
				ipList.add(infile.next());
			}
			
			IPFileFound = true;
			infile.close();
		}
		
		catch(IOException e)
		{
			IPFileFound = false;
		}
		
	}
	
	
	//this brings the blacklisted IP address file into the program's array
	public void setIPBlacklistArray(String file)
	{
		try
		{
			Scanner infile = new Scanner(new FileInputStream(file));
			
			while (infile.hasNext())
			{
				ipBlackList.add(infile.next());
			}
			
			blacklistIPFileFound = true;
			infile.close();
		}
		
		catch(IOException e)
		{
			blacklistIPFileFound = false;
		}
	}
	
	//this automatically searches the blacklisted array for anything in the IP address array
	//uses sequential searching technique
	public void searchBlacklist()
	{
		
		//comparison
		for (int x = 0; x < ipBlackList.size(); x++)
		{
			for (int y = 0; y < ipList.size(); y++)
			{
				if (ipList.get(y).equals(ipBlackList.get(x)))
				{
					setResultsToFile(y);
					match++;
				}
			}
		}
	}
	
	public void setResultsToFile(int index)
	{
		final String FILE = "Results.txt";
		
		try
		{
			PrintWriter print = new PrintWriter(new FileWriter(FILE, true));
			
			print.println(ipList.get(index));
			
			print.close();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
