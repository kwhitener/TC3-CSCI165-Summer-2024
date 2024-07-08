public class Rectangle extends Shape{

	private double width;
	private double length;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param length
	 */
	public Rectangle(int x, int y, double width, double length) {
		super(x, y);
		this.width = width;
		this.length = length;
	}

	/**
	 * 
	 * @param rectangle
	 */
	public Rectangle(Rectangle rectangle){
		super(rectangle);
		this.width = rectangle.width;
		this.length = rectangle.length;
	}

	/**
	 * 
	 * @return
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * 
	 * @param width
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * 
	 * @return
	 */
	public double getLength() {
		return length;
	}

	/**
	 * 
	 * @param length
	 */
	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double getArea() {
		return width * length;
	}

	@Override
	public double getPerimeter() {
		return 2 * (width + length);
	}

	@Override
	public String toString() {
		return super.toString() + ": Rectangle [length=" + length + ", width=" + width + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)		return true;
		if (obj == null)		return false;
		if (!super.equals(obj)) return false;
		if (getClass() != obj.getClass())return false;

		Rectangle other = (Rectangle) obj;
		
		if (length != other.length)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
}
