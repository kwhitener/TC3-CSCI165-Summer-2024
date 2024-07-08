
public class Doctor extends Employee{

	private String specialty;
	private String department;

	public Doctor(){}   // no argument constructor

	public Doctor(String specialty, String department) {
		this.specialty = specialty;
		this.department = department;
	}

	public Doctor(Person p, Date hired, int id, String dept, String specialty, String department) {
		super(p, hired, id, dept);  // call superclass constructor
		this.specialty = specialty;
		this.department = department;
	}

	public Doctor(Employee toCopy, String specialty, String department) {
		super(toCopy);  // call superclass constructor
		this.specialty = specialty;
		this.department = department;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public boolean equals(Object obj) { // to satisfy override rules arg must type Object
		if (this == obj)					return true;
		if (!super.equals(obj))				return false;
		if (getClass() != obj.getClass())	return false;

		Doctor other = (Doctor) obj; // type cast argument to appropriate type

		// super class check
		if (!super.equals(other))			return false; 

		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (specialty == null) {
			if (other.specialty != null)
				return false;
		} else if (!specialty.equals(other.specialty))
			return false;
		return true;
	}

	@Override
	public String toString() {
		// invoke super class toString
		return super.toString() + "Doctor [department=" + department + ", specialty=" + specialty + "]";
	} 
}
