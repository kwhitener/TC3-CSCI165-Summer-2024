import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {

	@Test
	public void testDateCloneViaCopyConstructor(){
		Date d1 = new Date(1, 1, 2000);
		Date d2 = new Date(d1);

		assertFalse("Dates have identical references", d1 == d2);	// d1 and d2 are different objects (identity check)
		assertTrue("Dates states are not equal", d1.equals(d2));	// d1 and d2 have the same state
	}

	// do we need to worry about deep copying enumerations?
	@Test
	public void testEnumClone(){
		Date d1 = new Date(1, 1, 2000);	// default format is SHORT_DATE
		Date d2 = new Date(d1);			// d2 will have the same format as d1

		String s1 = d1.toString();		// get the string representation of d1
		String s2 = d2.toString();		// get the string representation of d2

		assertTrue("Date strings are not equal", s1.equals(s2));	// d1 and d2 have the same format

		d1.setFormat(Date.DateFormat.SHORT_DATE);	// change the format of d1
		s1 = d1.toString();				// get the string representation of d1
		s2 = d2.toString();				// get the string representation of d2

		System.out.println(s1);			// print the string representation of d1
		System.out.println(s2);			// print the string representation of d2
		assertFalse("Date strings are equal after changing format", s1.equals(s2));	// d1 and d2 have different formats
	}
	
}
