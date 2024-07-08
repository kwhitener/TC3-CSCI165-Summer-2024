
public class Person {	// implicitly extends the Object class

	private Date		birthDate;
	private Address		addy;
	private String		firstName;
	private String		lastName;

	public Person(){} //no argument constructor

	public Person(String fName, String lName){
		firstName	= fName;
		lastName	= lName;
	}

	public Person(String fName, String lName, Date dob, Address addy){
		this(fName, lName);
		this.birthDate	= new Date(dob); 	// prevent privacy leak
		this.addy		= new Address(addy);// prevent privacy leak
	}

	// copy constructor
	public Person(Person copy){
		// redirect to overloaded constructor containing "sets"
		this(copy.firstName, copy.lastName, copy.birthDate, copy.addy);
	}

	public void setAddress(Address a){
		this.addy = new Address(a);	// prevent privacy leak
	}

	public Address getAddress(){
		return new Address(this.addy);// prevent privacy leak
	}

	public Date getBirthDate(){
		return new Date(this.birthDate);// prevent privacy leak
	}

	public String getName(){
		return this.firstName + " " + this.lastName;
	}

	@Override
	public String toString(){
		return firstName + " " + lastName + "\n" + birthDate + "\n" + addy;
	}

	@Override
	public boolean equals(Object obj) { // to satisfy override rules arg must type Object
		if (this == obj)					return true; // identity check
		if (obj == null)					return false;// null arg check
		if (getClass() != obj.getClass())	return false;// origin check

		Person other = (Person) obj;	// downcast arg to appropriate type
		
		if (addy == null) {
			if (other.addy != null)
				return false;
		} else if (!addy.equals(other.addy))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
