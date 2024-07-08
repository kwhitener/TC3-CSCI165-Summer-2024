/*
 * File:	CreditCardSale.java
 * Author:	Ken Whitener
 * Date:	4/22/2024
 * 
 * Description: This class represents a sale of an item with a name and price. It contains a bill() method which
 * is responsible for calculating the total cost of the sale. This method is overridden in the subclass to include
 * the credit card fee.
 */

public class CreditCardSale extends Sale{

	private double fee;

	/**
	 * 
	 * @param fee
	 */
	public CreditCardSale(double fee) {
		// implicit call to superclass no-argument constructor
		// may cause problems if superclass does not have a no-argument constructor
		// of if the superclass no-argument constructor initializes the object in a way
		// that is not appropriate for the subclass
		this.fee = fee;
	}

	/**
	 * 
	 * @param theName
	 * @param thePrice
	 * @param fee
	 */
	public CreditCardSale(String theName, double thePrice, double fee) {
		super(theName, thePrice);	// explicit call to superclass constructor
		this.fee = fee;				// initialize subclass instance variable
	}

	/**
	 * 
	 * @param originalObject
	 * @param fee
	 */
	public CreditCardSale(Sale originalObject, double fee) {
		super(originalObject);		// explicit call to superclass copy constructor
		this.fee = fee;				// initialize subclass instance variable
	}

	/**
	 * Copy Constructor
	 * @param other
	 */
	public CreditCardSale(CreditCardSale other){
		this(other, other.fee);		// call to another constructor in the same class via "this"
	}

	/**
	 * 
	 * @return the credit card fee
	 */
	public double getFee() {
		return fee;
	}

	/**
	 * 
	 * @param fee
	 */
	public void setFee(double fee) {
		this.fee = fee;
	}

	// override superclass bill method
	@Override
	public double bill(){
		return getPrice() + getFee();// call to superclass getPrice() method
	}
	
	@Override
	public String toString(){
		return  super.toString() +	// call to superclass toString() method
				" Credit Card fee: $" + fee +
				" Total cost = $" + bill();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true;	// identity check
		if (obj == null)					return false;	// null check
		if (!super.equals(obj))				return false;	// superclass check
		if (getClass() != obj.getClass())	return false;	// type check

		CreditCardSale other = (CreditCardSale) obj;		// down cast

		if (fee != other.fee)								// fee comparison
			return false;
		return true;
	}

	@Override
	public CreditCardSale clone( ){
		return new CreditCardSale(this);	// polymorphic clone
	}
}
