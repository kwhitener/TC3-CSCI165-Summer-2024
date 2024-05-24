import java.awt.Color;					// Color object for the oval
import java.awt.Graphics;				// Graphics object for the paintComponent method
import java.awt.Graphics2D;				// 2D Graphics object for the paintComponent method
import java.awt.RenderingHints;			// tell the JVM to smooth things out
import java.awt.event.ActionEvent;		// The Timer objects ticks these Events out
import java.awt.event.ActionListener;	// We need a class to "listen" for ActionEvents
import javax.swing.JPanel;				// Paintable component
import javax.swing.Timer;				// Timer object gives the ability to do something
 										// repeatedly, on a timed schedule

/*
 * This class illustrates some simple animation by moving an oval around a drawable area (JPanel)
 * 
 * It uses a Timer object to tick off events at a defined interval
 * At each tick of the timer the oval will be moved and the JPanel will be repainted
 * All oval movement code is in the actionPerformed method. This method will be called automatically
 * by the Event Dispatch Thread every time the timer ticks
 */

// this class IS an extended JPanel AND the listener for ActionEvents
public class BallPanel extends JPanel implements ActionListener{

	private int x, y;					// x, y coords of the oval
	private int size = 80;				// size of the oval
	private boolean move_up, move_left;	// directional flags

	// Timer will create ActionEvents with each tick
	// Timer needs to know which class is "listening" for ActionEvnts
	// Because this class implements the ActionListener role, it is "this" class
	private Timer timer = new Timer(10, this); 

	public BallPanel() {// constructor just starts the timer
		timer.start();	// start the timer
	}
	
	// this method will be called by the Event Dispath Thread every time the timer ticks
	// This class is an "ActionListener" and will "listen" for "ActionEvents"
	// When a class announces that it is an ActionListener then it MUST implement this method
	// This method contains logic to move the oval and repaint the JPanel
	// The oval is moved by changing the x, y coords
	// It also checks to see if the oval has reached the boundaries of the JPanel
	// The JPanel is repainted by calling repaint
	@Override
	public void actionPerformed(ActionEvent e) {
		if (x > this.getWidth() - size)		// did I reach the right boundary?
			move_left = true;				// then move left
		
		if (x < 0)							// did I reach the left boundary?
			move_left = false;				// then move right
		
		if (move_left)	x -= 1;				// change horizontal position
		else			x += 1;
			
		if (y > this.getHeight() - size)	// did I reach the bottom boundary?
			move_up = true;					// then move up
		
		if (y < 0) move_up = false;			// did I reach the bottom boundary? then move down

		if (move_up)y -= 1;					// change verticle position
		else		y += 1;
		
		this.repaint();						// call repaint to have the Event Dispatch Thread 
											// invoke paintComponent. paintComponent will draw the oval
	}

	// We do not call paintComponent directly
	// but we can call repaint which will in turn call paintComponent
	public void paintComponent(Graphics g) {						 
		Graphics2D g2d = (Graphics2D) g;	// 2D Graphics only for this project
		super.paintComponent(g2d);			// Tell our parent to paint

		// tell the JVM to smooth things out
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Color.RED);			// set the color of the oval
		g2d.fillOval(x, y, size, size);		// draw the oval
	}
}
