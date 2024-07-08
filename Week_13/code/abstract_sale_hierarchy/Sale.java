
public class Sale{

	private String name;
	private double price;

	/**
	 * No Argument
	 */
	public Sale( ){
		name = "No name yet";
		price = 0;
	}

	/**
	 * 
	 * @param theName
	 * @param thePrice
	 */
	public Sale(String theName, double thePrice){
		setName(theName);
		setPrice(thePrice);
	}

	/**
	 * 
	 * @param originalObject
	 */
	public Sale(Sale originalObject){
		if (originalObject != null){
			name = originalObject.name;
			price = originalObject.price;
		}
	}

	/**
	 * 
	 * @return price
	 */
	public double getPrice( ){
		return price;
	}

	/**
	 * 
	 * @param newPrice
	 */
	public void setPrice(double newPrice){
		if (newPrice >= 0)
			price = newPrice;
	}

	/**
	 * 
	 * @return name of customer
	 */
	public String getName( ){
		return name;
	}

	/**
	 * 
	 * @param newName
	 */
	public void setName(String newName){
		if (newName != null && newName != "")
			name = newName;
	}

	/**
	 * 
	 * @param otherSale
	 * @return integer specifying order {-1, 0, 1}
	 */
	public int compareTo(Sale otherSale){
		if(this == otherSale)               return  0;
		// call polymorphic bill method
		if(this.bill() < otherSale.bill())  return -1;
		if(this.bill() > otherSale.bill())  return  1;
											return  0;
	}

	// really not much to do here
	// at this level bill() is the same as getPrice()
	// but subclasses can override this to define custom behavior
	/**
	 * 
	 * @return total for the sale
	 */
	public double bill( ){
		return price;
	}

	// polymorphic clone method
	// Constructors are statically bound at compile time
	// public instance methods are dynamically bound at runtime
	// "run-time polymorphism"
	@Override
	public Sale clone( ){
		return new Sale(this );
	}

	@Override
	public String toString( ){
		return  name + " Price and total cost = $" + bill() ;
	}

	@Override
	public boolean equals(Object otherObject){
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass( ) != otherObject.getClass( )) return false;

		Sale otherSale = (Sale)otherObject;
		
		return  name.equals(otherSale.name)
				&& price == otherSale.price;
	}
}
