public abstract class Shape{

	private int x;
	private int y;

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @param shape
	 */
	public Shape( Shape shape){
		this.x = shape.x;
		this.y = shape.y;
	}

	/**
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	// ABSTRACT METHODS
	public abstract double getPerimeter();
	
	public abstract double getArea();

	@Override
	public String toString() {
		return "Shape [x=" + x + ", y=" + y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)	return true;
		if (obj == null)	return false;
		if (getClass() != obj.getClass())	return false;

		Shape other = (Shape) obj;
		
		if (x != other.x)	return false;
		if (y != other.y)	return false;
		return true;
	}
}