import javax.swing.JFrame;	// My "top level" GUI container 

public class Driver{

	private JFrame window;	// JFrame to hold the JPanel

	public Driver() {									
		window = new JFrame();										// JFrame instance
		window.setSize(840, 500);									// how big?
		window.setLocationRelativeTo(null);							// put in center
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// how to close
		window.setTitle("When Will It Hit The Corner Perfectly?");	// Title Bar text
		window.add(new BallPanel());								// and the custom JPanel to the container
		window.setVisible(true);									// make it visible
	}
	
	public static void main(String[] args) {
		new Driver();	// create an anonymous instance of the Driver class
	}
}
