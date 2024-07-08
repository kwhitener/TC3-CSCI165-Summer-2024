public class LateBindingDemo{
	public static void main(String[] args)
	{
		/*
		Sale simple = new Sale("floor mat", 10.00);
		DiscountSale discount = new DiscountSale("floor mat", 11.00, 10);

		System.out.println(simple);
		System.out.println(discount);

		if (discount.compareTo(simple) < 0)
			System.out.println("\nDiscounted item is cheaper.\n");
		else
			System.out.println("\nDiscounted item is not cheaper.\n");

		Sale regularPrice = new Sale("cup holder", 9.90);
		DiscountSale specialPrice = new DiscountSale("cup holder", 11.00, 10);

		System.out.println(regularPrice);
		System.out.println(specialPrice);

		if (specialPrice.compareTo(regularPrice) == 0)
			System.out.println("\nDeals are equal.\n");
		else
			System.out.println("\nDeals are not equal.\n");
		*/
		Sale[] sales = new Sale[5];
		sales[0] = new Sale("Inner tube", 6.50);
		sales[1] = new DiscountSale("Inner tube", 6.50, 7);
		sales[2] = new CreditCardSale("Inner tube", 6.50, .50);
		sales[3] = new Sale("Bicycle", 1700);
		sales[4] = new DiscountSale("Bicycle", 1700, 10);

		System.out.println("ORIGINALS");
		printSalesTypes(sales);

		Sale[] copies1 = copySales_INCORRECTLY(sales);
		System.out.println("\nINCORRECT CLONING");
		printSalesTypes(copies1);

		Sale[] copies2 = copySales_CORRECTLY(sales);
		System.out.println("\nCORRECT CLONING");
		printSalesTypes(copies2);
	}

	public static Sale lowestSale(Sale[] sales){
		Sale lowestSale = sales[0];
		for(Sale s : sales){
			System.out.println(s);
			if (s.compareTo(lowestSale) < 1)
			  lowestSale = s;
		}
		return lowestSale;
	}

	public static Sale[] copySales_INCORRECTLY(Sale[] sales){
		Sale[] copy = new Sale[sales.length];
		for(int index = 0; index < sales.length; ++index)
			copy[index] = new Sale(sales[index]);// only creates Sales instances
												 // what if there are subclass instances here?
		return copy;
	}

	public static Sale[] copySales_CORRECTLY(Sale[] sales){
		Sale[] copy = new Sale[sales.length];
		for(int index = 0; index < sales.length; ++index)
			copy[index] = sales[index].clone();	// call polymorphic clone method to dynamically
												// invoke the correct constructor
		return copy;
	}

	public static void printSalesTypes(Sale[] sales){
		System.out.println("BEGIN PRINTING");
		for(Sale s: sales){
			System.out.println("\n" + s); 		// toString
			System.out.println(s.getClass());	// origin
		}
		System.out.println("END PRINTING");
	}
}
