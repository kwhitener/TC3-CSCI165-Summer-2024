/*
 * This program will read a file containing the number of black bear sightings in 7 regions over 12 months.
 * The program will then display the average number of sightings per region and the average number of sightings per month.
 * 
 * The file should be formatted as follows:
 * 		One line represents sighting data for one region.
 * 		Each line will contain 12 comma separated integers representing the number of sightings for each month.
 * 
 * This program illustrates the use of a 2D array (matrix) and the use of row major and column major order.
 * Also illustrated is the ability to pass arrays by reference to void methods.
 */

import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

public class BlackBears{
	final static int NUM_REGIONS	= 7;	// constant for the number of regions
	final static int NUM_MONTHS		= 12;	// constant for the number of months
	public static void main(String[] args){
		// check if the user provided a file name
		if(args.length == 0){
			System.out.println("No arguments provided. ABORTING");
			return;
		}

		String	fileName	= "";								// name of the file
		int[][]	sightings	= new int[NUM_REGIONS][NUM_MONTHS];	// array to hold the sightings
		String[]months		= { 								// array to hold the months
								"January", "February", "March",
								"April", "May", "June", "July", 
								"August", "September", "October",
								"November", "December"
							 };
		
		fileName = args[0];							// get the file name from the command line
		fillArray(sightings, fileName);				// fill the array with the data from the file
		showRegionAverages(sightings);				// show the average sightings per region
		System.out.println("\n");					// add a blank line
		showMonthlyAverages(sightings, months);		// show the average sightings per month
 
	}// end of main

	/**
	 * This method will fill the array with the data from the file
	 * @param array		- the array to be filled
	 * @param fileName	- the name of the file
	 */
	public static void fillArray(int[][] array, String fileName){
		try{
			FileReader fr   = new FileReader(fileName);			// create a file reader
			Scanner scanner = new Scanner(fr);					// create a scanner

			// load the table with the sightings data
			for(int i = 0; i < NUM_REGIONS; i++){				// loop through the rows
				String line		= scanner.nextLine();			// read a line from the file
				String[] values = line.split(",");				// split the line into an array of strings
				for(int j = 0; j < NUM_MONTHS; ++j){			// loop through the columns
					array[i][j] = Integer.parseInt(values[j]);	// convert the string to an integer and store it in the array
				} // end inner for
			} // end outer for
			fr.close();											// close the file
			scanner.close();									// close the scanner
		} // end try
		catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}

	/**
	 * This method will display the average sightings per region
	 * @param array	- the array to be processed
	 */
	public static void showRegionAverages(int[][] array){
		// one row == one region
		// row major order
		for(int i = 0; i < NUM_REGIONS; ++i){	// loop through the rows
			double sum = 0;						// variable to hold the sum of the sightings per region
			for(int j = 0; j < NUM_MONTHS; ++j)	// loop through the columns (months	)
				sum += array[i][j];				// add the monthly sightings to the sum

			// display the average sightings per region	
			System.out.printf("Average for Region %d:\t %.2f \n", i+1, sum / NUM_MONTHS);
		}
	}

	/**
	 * This method will display the average sightings per month
	 * @param array		- the array to be processed
	 * @param months	- the array of months (for display purposes only)
	 */
	public static void showMonthlyAverages(int[][] array, String[] months){
		// one column == one month
		// column major order
		for(int i = 0; i < NUM_MONTHS; ++i){	// loop through the rows
			double sum = 0.0;					// variable to hold the sum of the sightings per month
			for(int j = 0; j < NUM_REGIONS; ++j)// loop through the columns (regions)
				sum += array[j][i];				// notice that the indices are reversed for column major order

			// display the average sightings per month	
			System.out.printf("Average for %s:\t %.2f \n", months[i], sum / NUM_REGIONS);
		}
	}
} // end of class