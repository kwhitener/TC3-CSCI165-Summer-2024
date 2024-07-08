/* 
	Purpose:	Define a Staff class that is a sub-class Person
				Staff will inherit all of the Person class fields and methods
				and add fields for school, pay, and date hired

				Staff exhibits an "is-a" relationship with Person (inheritance)
				Staff exhibits a "has-a" relationship with Date (composition)

	Author:		Ken Whtener
	Date:		Spring 2024
*/
public class Staff extends Person{

	private String school;	// immutable object
	private double pay;		// primitive
	private Date hired;		// mutable object

	/**
	 * Construct a Staff object
	 * 
	 * @param name
	 * @param address
	 * @param school
	 * @param pay
	 */
	public Staff(String name, String address, Date dob, String school, Date hired, double pay) {
		super(name, address, dob);		// pass super class fields up the hierarchy
		this.school = school;			// subclass fields stay here
		this.pay	= pay;				// subclass field
		this.hired	= new Date(hired);	// protect privacy for mutable composition objects
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param person
	 * @param school
	 * @param pay
	 */
	public Staff(Person person, String school, Date hired, double pay){
		// invoke overloaded constructor via "this"
		this(person.getName(), person.getAddress(), person.getDob(), school, hired, pay);
	}

	/**
	 * Copy constructor
	 * 
	 * @param staff
	 */
	public Staff(Staff staff){
		super(staff);					// invoke super class copy constructor
		this.school = staff.school;		// sub class field stays here
		this.pay 	= staff.pay;		// sub class field
		this.hired 	= new Date(staff.hired);// protect privacy for mutable composition objects
	}

	/**
	 * get the Staff member's date of hire
	 * 
	 * @return
	 */
	public Date getDateHired(){
		return new Date(hired);		// protect privacy for mutable composition objects
	}

	/**
	 * 
	 * @return The Staff member's assignment
	 */
	public String getSchool() {
		return school;				// immutable object, no privacy leak
	}

	/**
	 * Change the staff member's assignment
	 * 
	 * @param school The staff member's assignment
	 */
	public void setSchool(String school) {
		this.school = school;		// immutable object, no privacy leak
	}

	/**
	 * 
	 * @return Staff member's pay
	 */
	public double getPay() {
		return pay;					// primitive, no privacy leak
	}

	/**
	 * Change the staff member's pay
	 * 
	 * @param pay
	 */
	public void setPay(double pay) {
		this.pay = pay;				// primitive, no privacy leak
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true; // identity
		if (!super.equals(obj))				return false;// super class checks (inheritance)
		if (getClass() != obj.getClass())	return false;// origin

		Staff other = (Staff) obj;				// downcast
		
		if (school == null) {					// check for null
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		if (pay != other.pay)
			return false;
		if (hired == null){						// check for null
			if (other.hired != null)
				return false;
		} else if (!hired.equals(other.hired))	// compare dates with Date equals (composition)
			return false;
		return true;
	}

	@Override
	public String toString(){
		// super.toString() calls the super class toString method
		return super.toString() + ", " + school;
	}
}
