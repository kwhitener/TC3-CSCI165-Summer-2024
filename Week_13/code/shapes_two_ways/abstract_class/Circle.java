public class Circle extends Shape{

	private double radius;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param radius
	 */
	public Circle(int x, int y, double radius) {
		super(x, y);
		this.radius = radius;
	}

	/**
	 * 
	 * @param circle
	 */
	public Circle( Circle circle){
		super(circle);
		this.radius = circle.radius;
	}

	/**
	 * 
	 * @return
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * 
	 * @param radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return super.toString() + ": Circle [radius=" + radius + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)					return true;
		if (obj == null)					return false;
		if (!super.equals(obj))				return false;
		if (getClass() != obj.getClass())	return false;

		Circle other = (Circle) obj;
		
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}
}
