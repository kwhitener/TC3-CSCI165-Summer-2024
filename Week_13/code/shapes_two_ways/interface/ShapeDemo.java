public class ShapeDemo {

	public static void main(String[] args) {

		Rectangle r = new Rectangle(10, 10);
		System.out.println(r);
		r.resize(10);
		System.out.println(r);

		Resizable[] shapes = new Resizable[5];
		shapes[0] = new Circle(2);
		shapes[1] = new Rectangle(3, 4);
		shapes[2] = new Circle(6);
		shapes[3] = new Rectangle(13, 7);
		shapes[4] = new Circle(11);

		for(Resizable shape : shapes){
			shape.resize(10);
			// shape.getArea(); ERROR! Not defined in interface Resizable
			System.out.println(shape);
		}
	}

}
