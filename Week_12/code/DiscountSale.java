/*
 * File:	DiscountSale.java
 * Author:	Ken Whitener
 * Date:	4/22/2024
 * 
 * Description: This class represents a sale of an item with a name and price. It contains a bill() method which
 * is responsible for calculating the total cost of the sale. This method is overridden in the subclass to include
 * the discount.
 */

public class DiscountSale extends Sale{

	private double discount;

	/**
	 * No argument constructor
	 */
	public DiscountSale( ){
		// implicit call to superclass no-argument constructor
		// may cause problems if superclass does not have a no-argument constructor
		// of if the superclass no-argument constructor initializes the object in a way
		// that is not appropriate for the subclass
		discount = 0;
	}

	/**
	 * 
	 * @param theName
	 * @param thePrice
	 * @param theDiscount
	 */
	public DiscountSale(String theName, double thePrice, double theDiscount){
		super(theName, thePrice);	// explicit call to superclass constructor
		setDiscount(theDiscount);	// initialize subclass instance variable
	}

	/**
	 * 
	 * @param originalObject
	 */
	public DiscountSale(DiscountSale originalObject){
		super(originalObject);				// explicit call to superclass copy constructor
		discount = originalObject.discount;	// initialize subclass instance variable
	}

	/**
	 * 
	 * @return the dscount amount
	 */
	public double getDiscount( ){
		return discount;
	}

	/**
	 * 
	 * @param newDiscount
	 */
	public void setDiscount(double newDiscount){
		if (newDiscount >= 0)
			discount = newDiscount;
	}

	// override superclass bill method
	@Override
	public double bill( ){
		double fraction = discount/100;			// convert discount to fraction
		return (1 - fraction) * getPrice( );	// call to superclass getPrice() method
	}

	@Override
	public String toString( ){
		return  super.toString()				// call to superclass toString() method
				+ "\n\tDiscount = " + discount + "% "
				+ "Total cost = $" + bill( );
	}

	@Override
	public boolean equals(Object other){
		if (this == other)						return true;	// identity check
		if (other == null)						return false;	// null check
		if (getClass( ) != other.getClass( ))	return false;	// type check
		if (!super.equals(other))				return false;	// superclass check

		DiscountSale otherDiscountSale = (DiscountSale)other;	// cast to subclass
		return	discount == otherDiscountSale.discount;			// compare instance variables
	}

	@Override
	public DiscountSale clone( ){
		return new DiscountSale(this);
	}
}
