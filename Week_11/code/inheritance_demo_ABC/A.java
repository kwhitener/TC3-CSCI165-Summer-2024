public class A{
	// private features are inherited but not directly accessible
	private String name;

	public A(String name){
		this.name = name;
	}

	public String getName(){
		helper();   // call local private method
		return name;
	}

	// inherited but not directly accessible
	// can only use locally
	private void helper(){
		System.out.println("Do something helpful");
	}

	@Override
	public String toString(){
		return "Class A --> Name is: " + name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)						return true; // identity
		if (obj == null)						return false;// null
		if (this.getClass() != obj.getClass())	return false;// origin

		// We know we have a "non null" instance of class A 
		A other = (A) obj; // down cast Object to A

		// "this" equality
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
} // end of A

class B extends A{

	private double weight;
	
	public B(String name, double weight){
		super(name);			// pass name to superclass A
		this.weight = weight;	// weight stays with "this"
	}

	public double getWeight(){
		return this.weight;
	}

	@Override
	public String toString(){
		// call the super class toString, concatenate to "this" toString
		return super.toString() + " Class B --> weight is: " + weight;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true; // identity
		if (obj == null)					return false;// null
		if (!super.equals(obj))				return false;// super class
		if (getClass() != obj.getClass())	return false;// origin

		B other = (B) obj; // downcast

		// "this" equality
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	
} // end of B

class C extends B{

	private String color;

	public C(String name, double weight, String color){
		super(name, weight);	// pass name and weight to superclass B
		this.color = color;		// color stays with "this"
	}

	public String getColor(){
		return this.color;
	}

	@Override
	public String toString(){
		return super.toString() + " Class C --> color is: " + color;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true; // identity
		if (obj == null)					return false;// null arg
		if (!super.equals(obj))				return false;// super class
		if (getClass() != obj.getClass())	return false;// origin
			
		C other = (C) obj;  // downcast

		// "this" equality
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}
} // end of C

class InheritanceDriver{
	public static void main(String[] args){

		C c = new C("warlock mini", 5, "Red");
		B b = new B("wizard mini", 3);
		A a = new A("halfling mini");

		// C tempC = (C)a; // can't do this a is not an instance of C
		
		System.out.println("Is C an instance of B? " +		(c instanceof B));
		System.out.println("Is C an instance of A? " +		(c instanceof A));
		System.out.println("Is C an instance of Object? " +	(c instanceof Object));

		System.out.println("\nWas the B constructor called? " + (c.getClass() == b.getClass()));
		System.out.println("Was the A constructor called? " + (c.getClass() == a.getClass()));
	
		// organize objects around ancestry
		A[] array = new A[3];	// array of superclass type
		array[0] = a;			// no cast
		array[1] = b;			// implicit "upcast"
		array[2] = c;			// implicit "upcast"

		printArray(array);
	}

	public static void printArray(A[] list){
		// polymorphically call the correct toString
		// can only reference methods available in class A
		for(int i = 0; i < list.length; ++i){
			System.out.println("\n" + list[i]);
			System.out.println("Origin: " + list[i].getClass());
			System.out.println("Instance Of Object? " + (list[i] instanceof Object));
			System.out.println("Instance Of A? " + (list[i] instanceof A));
			System.out.println("Instance Of B? " + (list[i] instanceof B));
			System.out.println("Instance Of C? " + (list[i] instanceof C) + "\n");
		}
	}
}
