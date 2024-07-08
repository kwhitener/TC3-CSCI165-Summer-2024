/*
  	Purpose:	Define the base class Person that defines basic attributes for a person
				including name, address and date of birth

	Author:		Ken Whtener
	Date:		Spring 2024
 */

public class Person{

	private String name;
	private String address;
	private Date dob;

	/**
	 * Overloaded constructor
	 * 
	 * @param name
	 * @param address
	 */
	public Person(String name, String address, Date dob) {
		this.name	= name;				// immutable object. no need to clone
		this.address= address;			// immutable object. no need to clone
		this.dob	= new Date(dob);	// mutable object. clone to protect privacy
	}

	/**
	 * Copy constructor
	 * 
	 * @param person
	 */
	public Person(Person person){
		this.name	 = person.name;		// immutable object. no need to clone
		this.address = person.address;	// immutable object. no need to clone
		this.dob	 = new Date(person.dob);// mutable object. clone to protect privacy
	}

	/**
	 * 
	 * @return The Person's name
	 */
	public String getName() {
		return name;					// immutable object. no privacy leak
	}

	/**
	 * 
	 * @return The Person's address
	 */
	public String getAddress() {
		return address;					// immutable object. no privacy leak
	}

	/**
	 * Sets the Person's address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;			// immutable object. no need to clone
	}

	/**
	 * 
	 * @return The Person's date of birth
	 */
	public Date getDob() {
		return new Date(dob);			// mutable object. clone to protect privacy
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true; // identity check
		if (obj == null)					return false;// null check
		if (getClass() != obj.getClass())	return false;// origin check

		Person other = (Person) obj;	// downcast to appropriate type
		
		// test all fields
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))	// compare strings with equals
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))		// compare dates with Date equals
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + ", " + address + ", " + dob;
	}
}