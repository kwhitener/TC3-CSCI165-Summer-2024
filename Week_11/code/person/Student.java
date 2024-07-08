/* 
	Purpose:	Define a Student class that is a sub-class Person
				Student will inherit all of the Person class fields and methods
				and add fields for program, year, and fee

				Student exhibits an "is-a" relationship with Person (inheritance)

	Author:		Ken Whtener
	Date:		Spring 2024
*/

public class Student extends Person{

	private String program;
	private int year; 
	private double fee;

	/**
	 * Overloaded constructor
	 * 
	 * @param name
	 * @param address
	 * @param program
	 * @param year
	 * @param fee
	 */
	public Student(String name, String address, Date dob, String program, int year, double fee) {
		super(name, address, dob);	// pass super class fields up the hierarchy
		this.program = program;		// subclass fields stay here
		this.setYear(year);
		this.setFee(fee);
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param person
	 * @param program
	 * @param year
	 * @param fee
	 */
	public Student(Person person, String program, int year, double fee){
		// invoke overloaded constructor
		this(person.getName(), person.getAddress(), person.getDob(), program, year, fee);
	}

	/**
	 * Copy constructor
	 * 
	 * @param student
	 */
	public Student(Student student){
		super(student);					// super class copy constructor
		this.program= student.program;	// subclass stuff stays here
		this.year	= student.year;
		this.fee	= student.fee;
	}

	/**
	 * Change the Student's program
	 * 
	 * @param program The Student's program
	 */
	public void setProgram(String program) {
		this.program = program;			// immutable object, no need to clone
	}

	/**
	 * 
	 * @return The Student's program
	 */
	public String getProgram() {
		return program;					// immutable object, no privacy leak
	}

	/**
	 * Change the Student's year
	 * 
	 * @param year The new year
	 */
	public void setYear(int year) {
		if(year >= 1 && year <= 4)
			this.year = year;
	}

	/**
	 * 
	 * @return The Student's year
	 */
	public int getYear() {
			return year;				// primitive, no privacy leak
	}

	/**
	 * Change the Student's fee
	 * 
	 * @param fee The Student's fee
	 */
	public void setFee(double fee) {
		if(fee > 0)
			this.fee = fee;				// primitive, no privacy leak
	}

	/**
	 * 
	 * @return The Student's fee
	 */
	public double getFee() {
		return fee;						// primitive, no privacy leak
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true;	// identity
		if (!super.equals(obj))				return false;	// null check happens at super level
															// as well as super class fields
		if (getClass() != obj.getClass())	return false;	// origin

		Student other = (Student) obj;	// downcast
		
		// check sub class fields only
		if (program == null) {
			if (other.program != null)
				return false;
		} else if (!program.equals(other.program))
			return false;
		if (year != other.year)
			return false;
		if (fee != other.fee)
			return false;
		return true;
	}

	@Override
	public String toString(){
		// invoke super class toString
		return super.toString() + ", " + program + ", " + year;
	}
}
