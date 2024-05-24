/*
 * This class is the driver class for the Food Truck application.
 * 
 * You have been provided with a bit of starter code to help you get started.
 * You are only responsible for completing one single order.
 * If you'd like to process multiple orders, you can do so in the main method.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver{

	public static void main(String[] args) {
		// TO DO: call the loadMenuItems method and store the returned ArrayList in a variable

		// TO DO: Insantiate a Date object to store the Date of the order
		//		  Use techniques from an earlier lab to get the current date and time

		// TO DO: Create a simple system to process an order. Decompose the problem into smaller steps/methods
		// You can use the following steps as a guide:
		//		1. Print a welcome message
		//		2. Prompt the user to enter their information (should be a method that returns a Customer object)
		//		3. Prompt the user to enter the items they'd like to order (should be a method that returns an ArrayList of MenuItems)
		//			a. Create an ArrayList to store the items the user has ordered (shopping cart)
		//			b. The shopping cart should hold MenuItems
		//		4. Print the order (should be a method that takes the Customer object, the ArrayList of MenuItems, and the Date object)

	}

	public static ArrayList<MenuItem> loadMenuItems(String filename){
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();	// Create an ArrayList to store the menu items
	
		try{
			File file		= new File(filename);	// Create a File object
			Scanner scanner	= new Scanner(file);	// Create a Scanner object to read the file
			while(scanner.hasNextLine()){			// Loop through the file
				// TO DO:
				// 	Read the line and split into tokens
				// 	Instantiate a MenuItem object using the line data
				// 	add it to the ArrayList
			}
			scanner.close();// Close the Scanner object (lots of folks NOT DOING THIS)
		}
		catch(FileNotFoundException e){	// Catch the FileNotFoundException
			System.out.println("File not found: " + filename);	// Print an error message
		}
		return menuItems;	// Return the ArrayList
	}

	public static void printMenu(ArrayList<MenuItem> menuItems){
		// TO DO:
		// 	Loop through the ArrayList and print each MenuItem object
		// 	If you have a toString method in the MenuItem class, you can use it here
		// 	Otherwise, you can print the individual attributes of the MenuItem object
	}

	public static void printOrder(ArrayList<MenuItem> order, Customer customer, Date today){
		// TO DO:
		// 	output a nest receipt
		// 	Use the getInvoiceNumber method to generate a unique invoice number (modify if you want)
	}

	/**
	 * Creates a (mostly) unique invoice number from the Customer data and the Date
	 * 
	 * @param customer	The customer object
	 * @param today		The date object
	 * @return			the invoice number
	 */
	public static String getInvoiceNumber(Customer customer, Date today){
		/*
			first two initials of the customer’s first name, converted to uppercase
			first two initials of the customer’s last name, converted to uppercase
			Unicode value of the first character of the first name
			Unicode value of the first character of the last name
			Add them together and multiply by the length of the full name
			Concatenate this ID to the initials described above
			Concatenate the day, month, hour and minute with no punctuation
		*/
		String invoiceNumber = "";										// Create a variable to store the invoice number
		String[] name = customer.getName().split(" ");					// Get the first name
		String firstInitials= name[0].substring(0, 2).toUpperCase();	// Get the first two initials of the first name
		String lastInitials = name[1].substring(0, 2).toUpperCase();	// Get the first two initials of the last name
		int firstUnicode 	= (int)name[0].charAt(0);					// Get the Unicode value of the first character of the first name
		int lastUnicode 	= (int)name[1].charAt(0);					// Get the Unicode value of the first character of the last name
		int id = (firstUnicode + lastUnicode) * customer.getName().length();// Calculate the ID
		invoiceNumber = firstInitials + lastInitials + id;				// Concatenate the initials and ID
		invoiceNumber += today.getDay() + today.getMonth();				// Concatenate the date (add the time in if you want)
		return invoiceNumber;											// Return the invoice number
	}
}