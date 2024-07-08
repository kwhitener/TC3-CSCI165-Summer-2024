public class Employee {

	private String 	firstName;		// composition: using a String object
	private String 	lastName;		// composition: using a String object
	private String 	ssn;
	private String 	title;
	private double 	salary;
	private Date 	hireDate;		// composition: using a Date object
	private Date 	dateTerminated; // composition: using a Date object

	public Employee(){}

	public Employee(String firstName, String lastName, Date hireDate){
		this.firstName 	= firstName;
		this.lastName 	= lastName;
		this.hireDate 	= new Date(hireDate);	// privacy leak fixed
	}

	public Employee(String firstName, String lastName, String ssn,
					String title, double salary, Date hireDate) {
		this.firstName 		= firstName;
		this.lastName 		= lastName;
		this.ssn 			= ssn;
		this.title 			= title;
		this.salary 		= salary;
		this.hireDate 		= new Date(hireDate);	    // privacy leak fixed
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
		return new Date(hireDate);	// privacy leak fixed
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = new Date(hireDate);	// privacy leak fixed
	}

	public Date getDateTerminated() {
		return new Date(dateTerminated);	// privacy leak fixed
	}

	public void setDateTerminated(Date dateTerminated) {
		// do some validation testing on the argument
		// Policy: the date terminated must be greater than the hire date
		if (dateTerminated != null && this.hireDate.compareTo(dateTerminated) < 0)
			this.dateTerminated = new Date(dateTerminated); // privacy leak fixed
	}

	@Override
	public String toString() {
		return "Employee [dateTerminated=" + dateTerminated + ", firstName=" + firstName + ", hireDate=" + hireDate
				+ ", lastName=" + lastName + ", salary=" + salary + ", ssn=" + ssn + ", title=" + title + "]";
	}

	public boolean equals(Employee otherEmployee){
		return 	this.firstName.equals(otherEmployee.firstName)	&&
				this.lastName.equals(otherEmployee.lastName)	&&
				this.ssn.equals(otherEmployee.ssn)				&&
				this.title.equals(otherEmployee.title)			&&
				this.salary == otherEmployee.salary				&&
				this.hireDate.equals(otherEmployee.hireDate);
	}
}
