import java.util.ArrayList;

public class SpongeBob {

	/**
	 * This method takes a string and capitalizes 50% of the characters.
	 * Based on silly meme where people type in a mocking tone.
	 * 
	 * @param text	The string to be modified
	 * @return		The modified string
	 */
	public static String spongeBobify(String text){
		char[] textArray		= text.toCharArray();				// Convert the string to a character array to allow modification
		int fiftyPercent		= text.length() / 2;				// compute 50% of the length of the string
		ArrayList<Integer> indices = new ArrayList<Integer>();		// create an array list to store the index of modified characters
																		// so we don't modify the same character twice
		while(indices.size() < fiftyPercent){						// loop until 50% of the characters are uppercase
			int randomIndex = (int)(Math.random() * text.length()); // generate a random index between 0 and the length of the string
			char c = text.charAt(randomIndex);						// get the character at the random index
			if(Character.isLetter(c)){								// if the character is a letter, not a number or punctuation
				if(indices.contains(randomIndex))					// if the index is already in the array list of modified characters
					continue;											// skip the rest of the loop and start over
				textArray[ randomIndex ] = Character.toUpperCase(c);// capitalize and replace the character in the array
				indices.add(randomIndex);							// add the index to the array list of modified characters
			} // end if
		} // end while
		return String.valueOf(textArray);							// convert the character array back to a string and return it
	} // end spongeBobify method
	
} // end SpongeBob class
