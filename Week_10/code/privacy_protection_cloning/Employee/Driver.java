public class Driver {

	public static void main(String[] args) {
		
		// create an Employee instance using default constructor
		Employee e = new Employee();
		// print e
		//System.out.println(e);

		Employee e2 = new Employee();

		// are they equal? This throws NullPointerExceptions
		//System.out.println("Are they equal? " + e.equals(e2));

		// first create a Date object
		Date hired = new Date(12, 1, 1969);
		// pass the date object into the Employee Constructor
		Employee e3 = new Employee("Tony", "Iommi", hired);
		// create Employee with an anonymous Date instance
		Employee e4 = new Employee("Geezer", "Butler", new Date(6, 6, 1970));

		// What year was Geezer Butler hired?
		Date geezer_hire = e4.getHireDate(); // returns a reference to e4's hire date
		int year = geezer_hire.getYear();    // use local reference to get the year
		System.out.println("Geezer was hired in " + year);

		// Do it all at once by chaining method calls
		// Because Java returns references, these can be chained to any length
		// It's not a great idea to get too lengthy with these chains
		// as they are difficult to debug
		int y = e4.getHireDate().getYear();
		System.out.println("Geezer was hired in " + y);


		//System.out.println(e3);
		//System.out.println(e4);

		//System.out.println("Are they equal? " + e3.equals(e4));

		Employee e5 = new Employee("Frank", "Stein", new Date(1, 11, 2021));
		Employee e6 = new Employee("Frank", "Stein", new Date(1, 11, 2021));
		//System.out.println("Are they equal? " + e5.equals(e6));

		Date d = new Date(1, 11, 2021);
		Employee e7 = new Employee("Ozzy", "Osborne", "123-45-6789", "jr. developer",
									45000, d);
		Employee e8= new Employee("Bill", "Ward", "567-83-9283", "sr. developer",
									90000, new Date(1, 6, 2020));
		System.out.println(e7);
		System.out.println(e8);
	}
}
