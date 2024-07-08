public class Employee {

	private String 	firstName;		// composition: using a String object
	private String 	lastName;		// composition: using a String object
	private String 	ssn;			// composition: using a String object
	private String 	title;			// composition: using a String object
	private double 	salary;			// NO COMPOSITION: primitive
	private Date 	hireDate;		// composition: using a Date object
	private Date 	dateTerminated; // composition: using a Date object

	public Employee(){}

	public Employee(String firstName, String lastName, Date hireDate){
		this.firstName 	= firstName;
		this.lastName 	= lastName;
		this.hireDate 	= hireDate;	// privacy leak
	}

	public Employee(String firstName, String lastName, String ssn,
					String title, double salary, Date hireDate) {
		this.firstName 		= firstName;
		this.lastName 		= lastName;
		this.ssn 			= ssn;
		this.title 			= title;
		this.salary 		= salary;
		this.hireDate 		= hireDate;			// privacy leak
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;	// privacy leak
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;	// privacy leak
	}

	public Date getDateTerminated() {
		return dateTerminated;	// privacy leak
	}

	public void setDateTerminated(Date dateTerminated) {
		// do some validation testing on the argument
		// Policy: the date terminated must be greater than the hire date
		if (dateTerminated != null && this.hireDate.compareTo(dateTerminated) < 0)
			this.dateTerminated = dateTerminated;
	}

	public boolean equals(Employee otherEmployee){
		return 	this.firstName.equals(otherEmployee.firstName)	&&
				this.lastName.equals(otherEmployee.lastName)	&&
				this.ssn.equals(otherEmployee.ssn)				&&
				this.title.equals(otherEmployee.title)			&&
				this.salary == otherEmployee.salary				&&
				this.hireDate.equals(otherEmployee.hireDate);
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", hireDate=" + hireDate +
				", lastName=" + lastName + ", salary=" + salary + ", ssn=" + ssn + 
				", dateTerminated=" + dateTerminated + ", title=" + title + "]";
	}
}
