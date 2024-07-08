public class Driver {

	public static void main(String[] args) {
		
		Person p  = new Person("Bill Ward", "1234 Nottingham Lane", new Date(1, 1, 1950));
		Student student = new Student(p, "CS", 4, 100);
		//System.out.println(student);

		// call some inherited Person methods from a Student object
		//System.out.println(student.getName() + " majors in " + student.getProgram());

		String name 	= "Tony Iommi";
		String addy 	= "22 Acacia Ave";
		Date dob		= new Date(1, 1, 1948);
		String school	= "Engineering";
		double pay		= 6.66;
		Date hired		= new Date(1, 2, 1234);
		Staff staff 	= new Staff(name, addy, dob, school, hired, pay);
		//System.out.println(staff);
		
		// call some inherited Person methods from a Student object
		//System.out.println(staff.getName() + " works in " + staff.getSchool());

		// create a regular ole Person object
		Person person = new Person("Frank N. Stein", "13 Green Mile", new Date(1, 1, 1900));

		// create and populate an array of Person objects
		Person[] people = {person, student, staff};

		// loop through "people" array and call toString()
		for( Person pers : people )
			System.out.println(pers);
	}
}
