public class Driver {

	public static void main(String[] args) {

		// compile time type is Object
		// runtime type is Person
		Object o = new Person(); // Person is subclass of Object

		// compile time type is Person
		// runtime type is Person
		Person p = new Person();

		// compile time type is Person
		// runtime type is Employee
		Person e = new Employee(); // Employee is subclass of Person

		// compile time type is Person
		// runtime type is Doctor
		Person d = new Doctor();  // Doctor is subclass of Employee

		System.out.println(""+o+p+e+d);

		/* 
			composition and inheritance tasks
			=================================
			Person HAS AN Address (composition)
			Person HAS A Date of Birth (composition)
			Employee IS A Person (inheritance)
		*/
		Address address 	= new Address("123 North Street", "Dryden", "NY", 13053);
		Date dob			= new Date(1, 2, 1969);
		Person person		= new Person("Tony", "Iommi", dob, address);
		Employee employee	= new Employee(person, new Date(1, 13, 2020), 12345, "Intensive Care");

		System.out.println(employee);

		// call some of the various methods that exist in the inheritance hierarchy
		String fullName 	= employee.getName(); 		// method exists in the Person class
		Date cakeDay		= employee.getBirthDate(); 	// method exists in the Person class
		System.out.println(fullName + " was born on " + cakeDay);

		// composition
		int year 			= cakeDay.getYear(); // method exists in the Date class
		System.out.println(fullName + " was born in " + year);

		// composition and inheritance
		Address add 		= employee.getAddress(); // method exists in the Person class
		String state		= add.getState(); // method exists in the Address class
		System.out.println(fullName + " lives in " + state);

		// composition
		String dept			= employee.getDepartment(); // method exists in the Employee class
		System.out.println(fullName + " works in the " + dept + " department");

		System.out.println("\n\n"+ employee);
	}
}
