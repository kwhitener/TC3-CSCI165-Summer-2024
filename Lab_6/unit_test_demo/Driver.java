public class Driver {
		
	public static void main(String[] args) {
		// Test the SpongeBob class
		// The output will be different each time you run the program
		// because the SpongeBob.spongeBobify method uses randomization
		// to decide whether to capitalize each character.

		String[] testStrings = {
			"Hello, World from Bikini Bottom",
			"Squidward is annoying",
			"SpongeBob SquarePants is funny",
			"Patrick Star is dumb",
			"Crabby Patty is delicious",
			"Gary the Snail is cute",
			"Plankton is evil and small",
		};
		
		for(String s : testStrings) {
			System.out.println("Original: " + s);
			// Because the spongeBobify method is static you DO NOT need to create an 
			// instance of the SpongeBob class to use it.
			System.out.println("Modified: " + SpongeBob.spongeBobify(s));
			System.out.println();
		}
	}
}
