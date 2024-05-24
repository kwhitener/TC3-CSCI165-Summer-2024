/*
 * File: SpellingBee.java
 * ----------------------
 * This program contains the starter file for the SpellingBee application.
 * 
 * Your work will all go here
 * 
 * BE SURE TO CHANGE THIS COMMENT WHEN YOU COMPLETE YOUR SOLUTION.
 * 
 * to run this app, at the terminal, type:
 * 	javac SpellingBee.java
 * 	java SpellingBee
 */

import java.awt.Color;	// import the Color class

public class SpellingBee {
	
	public void run() {
		// create a new SpellingBeeGraphics object. Use this to call methods to add fields and buttons
		sbg = new SpellingBeeGraphics();

		/*
		 * 	WORKFLOW:
		 *  ========
		 * 1. Add a field or button depending on the need: sbg.addField or sbg.addButton
		 * 2. Define the action that should be taken when the field or button is used
		 * 3. The action will then be defined as a method with the same name
		 * 4. Add the action to the field or button
		 * 
		 * Below are two examples of how to add a field and a button
		 */

		// add a new text field with the name "Puzzle" and the action "puzzleAction"
		// "puzzleAction" should be defined as a method that takes a string as a parameter
		sbg.addField("Puzzle", (s) -> puzzleAction(s));

		// add a new Button with the name "Solve" and the action "solveAction"
		// "solveAction" should be defined as a method that takes no parameters
		sbg.addButton("Solve", (s) -> solveAction());
	}

	// define the puzzleAction method that will execute when 
	// you hit "ENTER" after clicking in the "Puzzle" field
	// The contents of the field will be automatically passed to the method as a string
	private void puzzleAction(String s) {
		sbg.showMessage("puzzleAction is not yet implemented", Color.RED);
	}

	// define the solveAction method that will execute when
	// you click the "Solve" button. It does not get the contents of the PUZZLE field
	// but you can change this if you'd like
	private void solveAction() {
		sbg.showMessage("solveAction is not yet implemented", Color.RED);
	}

	/* Constants */
	// The name of the file containing the puzzle dictionary
	private static final String ENGLISH_DICTIONARY = "EnglishWords.txt";

	/* Private instance variables */
	private SpellingBeeGraphics sbg;	// no instance created yet, just scoped the reference variable

	/* Startup code */
	public static void main(String[] args) {	// application starts here
		SpellingBee sb = new SpellingBee();
		sb.run();// call the run method (defined below)
	}
}
