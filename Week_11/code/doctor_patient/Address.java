public class Address{

	private String 	street;
	private String 	city;
	private String 	state;
	private int 	zip;

	public Address(){}

	public Address(String s, String c, String state, int z){
		this.street = s;
		this.city 	= c;
		this.state 	= state;
		this.zip 	= z;
	}

	public Address(Address copy){
		this.street = copy.street;
		this.city 	= copy.city;
		this.state 	= copy.state;
		this.zip 	= copy.zip;
	}

	public String getStreet(){
		return street;
	}

	public String getCity(){
		return city;
	}

	public String getState(){
		return state;
	}

	public int getZip(){
		return zip;
	}

	@Override
	public String toString(){
		return street + " " + city + " " + state + ", " + zip;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true;
		if (obj == null)					return false;
		if (getClass() != obj.getClass())	return false;

		Address other = (Address) obj;		// downcast

		// perform null checks on fields that are objects.
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zip != other.zip)
			return false;
		// all "not equal" tests fail, therefore the two are equal
		return true;
	}
}
