
import java.awt.Graphics;				// import the Graphics class
import java.awt.Graphics2D;				// import the Graphics2D class
import java.awt.event.ActionEvent;		// Timer kicks out ActionEvents
import java.awt.event.ActionListener;	// The class needs to listen for ActionEvents
import javax.swing.JPanel;				// A JPanel is a simple container for graphics
import javax.swing.Timer;				// A Timer object kicks out ActionEvents at regular intervals

// Don't worry too much about "extends JPanel" and "implements ActionListener"
// We will cover that in excruciating detail in the future
public class Simple_Graphics extends JPanel implements ActionListener{
	private final int DELAY = 100;	// delay for ActionListener Timer. Change this to change the speed of the simulation
	private Timer timer;			// Timer object to control repainting.

	private World grid; 			// needs a reference to the class that contains the matrix

	/**
	 * Constructor
	 * @param grid - the World object to be rendered
	 */
	public Simple_Graphics(World grid) {
		this.grid = grid;			// store the reference to the grid
		initTimer();				// initialize the timer
	}

	/**
	 * Method to initialize and start the Timer object
	 */
	private void initTimer() {
		timer = new Timer(DELAY, this);	// create a new Timer object with delay and reference to ActionListener class
		timer.start();					// start the timer
	}

	// method to render the world in Java 2D Graphics
	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g; // type cast Graphics object to 2D. DON'T REMOVE

		// TO DO: draw the world as a series of rectangles
		// get the color of the cell and draw a rectangle at the appropriate location
	}

	@Override // method will be called each time timer "ticks"
	public void actionPerformed(ActionEvent arg0) {
		// This method represents a time step
		// TO DO: update the grid by iterating through the cells and updating their state
		// with the transition rules
		// then repaint the grid
		this.repaint();					// call the repaint method, which will call paintComponent
	}

	/*
	 * If you put all your drawing code in doDrawing, you don't need to worry about this method
	 */
	@Override // automatically called by "repaint"
	public void paintComponent(Graphics g){
		super.paintComponent(g);		// call the superclass method. DON'T REMOVE
		doDrawing(g);					// call the doDrawing method. THIS IS YOURS
	}
}