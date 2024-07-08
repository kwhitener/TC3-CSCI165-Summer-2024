public class DummyDriver {

	public static void main(String[] args) {

		// create a Dummy instance
		Dummy d = new Dummy();
		Dummy e = new Dummy();

		// call a bunch of inherited methods
		System.out.println(d.toString());
		System.out.println(d.getClass());
		System.out.println(d.hashCode());
		System.out.println("Does e equal d? " + e.equals(d));

	}

}
