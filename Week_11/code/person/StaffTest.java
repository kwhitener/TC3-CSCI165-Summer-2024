import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class StaffTest {
	@Test
	void testEquals() {
		String name 	= "Tony Iommi";
		String addy 	= "22 Acacia Ave";
		Date dob		= new Date(1, 1, 1948);
		String school	= "Engineering";
		double pay		= 6.66;
		Date hired		= new Date(1, 2, 1234);
		Staff staff 	= new Staff(name, addy, dob, school, hired, pay);

		Staff staff2 	= new Staff("Tony Iommi", "22 Acacia Ave", new Date(1, 1, 1948), 
									"Engineering", new Date(1, 2, 1234), 6.66);
	
		// they are equal
		assertTrue(staff.equals(staff2));

		// name is different
		staff2	= new Staff("Anthony Iommi", "22 Acacia Ave", new Date(1, 1, 1948),
							"Engineering", new Date(1, 2, 1234), 6.66);

		assertFalse(staff.equals(staff2));

		// address is different
		staff2	= new Staff("Tony Iommi", "23 Acacia Ave", new Date(1, 1, 1948), 
							"Engineering", new Date(1, 2, 1234), 6.66);
		assertFalse(staff.equals(staff2));

		// school is different
		staff2	= new Staff("Tony Iommi", "22 Acacia Ave", new Date(1, 1, 1948),
							"Maintenance", new Date(1, 2, 1234), 6.66);
		assertFalse(staff.equals(staff2));

		// hired date is different
		staff2	= new Staff("Tony Iommi", "22 Acacia Ave", new Date(1, 1, 1948), 
							"Engineering", new Date(1, 2, 1235), 6.66);
		assertFalse(staff.equals(staff2));

		// pay is different
		staff2	= new Staff("Tony Iommi", "22 Acacia Ave", new Date(1, 1, 1948), 
							"Engineering", new Date(1, 2, 1234), 7.77);
		assertFalse(staff.equals(staff2));
	}

	@Test
	void testCloning() {
		String name 	= "Tony Iommi";
		String addy 	= "22 Acacia Ave";
		Date dob		= new Date(1, 1, 1948);
		String school	= "Engineering";
		double pay		= 6.66;
		Date hired		= new Date(1, 2, 1234);
		Staff staff 	= new Staff(name, addy, dob, school, hired, pay);

		Staff staffClone = new Staff(staff);
		assertFalse(staffClone == staff);
		assertTrue(staff.equals(staffClone));

		Date d 		= staff.getDateHired();
		Date dClone	= staffClone.getDateHired();
		assertFalse(d == dClone);
		assertTrue(d.equals(dClone));
	}
}
