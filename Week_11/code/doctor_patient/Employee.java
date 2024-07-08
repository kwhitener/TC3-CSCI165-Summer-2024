public class Employee extends Person {

	private Date	hireDate; // protect privacy!
	private int		id;
	private String	department;

	// no argument
	public Employee() {}

	// overloaded constructor
	public Employee(Person p, Date hired, int id, String dept) {
		super(p);			// call to super class copy constructor
		setHireDate(hired);
		setId(id);
		setDepartment(dept);
	}

	// copy constructor
	public Employee(Employee toCopy){
		super(toCopy);  // up cast the Employee object to a Person object
		setHireDate(toCopy.hireDate);
		setId(toCopy.id);
		setDepartment(toCopy.department);
	}

	public Date getHireDate() {
		// prevent privacy leak by returning copy
		return new Date(hireDate);
	}

	public void setHireDate(Date hireDate) {
		// prevent privacy leak by setting a copy of the argument
		this.hireDate = new Date(hireDate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		// call super class version of toString
		return super.toString() + "\nHired: " + hireDate + "\nID: " + id + "\nDept: " + department;
	}

	@Override
	public boolean equals(Object obj) { // to satisfy override rules arg must type Object
		if (this == obj)					return true;	// idenitity check
		if (obj == null)					return false;	// null check
		if (getClass() != obj.getClass())	return false;	// origin check

		Employee other = (Employee) obj;					// downcast

		if (!super.equals(obj))				return false;	// super class check

		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
