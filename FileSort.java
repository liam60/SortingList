//Name: Liam Barclay
//ID: 1268723

import java.io.File;
import java.util.Scanner;

//Filesort class
class FileSort
{
	//The main routine for the filesort
	//returns void and takes the arguments given
	public static void main(String [] args)
	{
		//Creates a new LineList to add lines to.
		LineList list = new LineList();

		//Give an error message if not the appropriate number of arguments.
		if(args.length != 2)
		{
	      		System.err.println("Usage:  java TestRead <filename>");
	      		return;
	    	}
	
	
	    	try
		{
			//Creates the scanner to read in the file
	      		Scanner sc = new Scanner(new File(args[1]));
			sc.useDelimiter(System.getProperty("line.separator"));
			String s;
			
			//While the file has more lines
			//Add the lines to the LineList
	      		while(sc.hasNext())
			{
				s=sc.next();
				list.addNewLine(s);
	      		}
			
			//Removes any null (empty string) lines from the list.
			list.removeNullLines();

			//If the user want to use insertion sort
			if(args[0].equals("i"))
			{	
				//Sort the list by insertion sort
				list.iSort();
				//Print the list and the number of comparisons.
				list.printList();
				System.err.println("COUNT: " + list.getCount());
			}
			//Else if the user wants to use quick sort.
			else if(args[0].equals("q"))
			{
				//Sort the list by quick sort
				list.qSort();
				//Print the list and the number of comparisons.
				list.printList();
				System.err.println("COUNT: " + list.getCount());
			}
			//Otherwise print an error
			else
			{
				System.err.println("Sorting method can be called by either \"i\" or \"q\"");
			}
			

			
	    	}
		//Print the error message if the program fails.
		catch(Exception e)
		{
			System.err.println("error: " + e.getMessage());
	    	}
		  
	}
}

