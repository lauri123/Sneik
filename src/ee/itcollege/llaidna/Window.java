package ee.itcollege.llaidna;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

// create a window class

/**
 * @author various
 * @author lauri
 *
 */

@SuppressWarnings("serial")
public class Window extends Canvas {

	public Window(int width, int height, String title, Main game) {
		JFrame frame = new JFrame(title); 								// create a frame (JFrame library)
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		// buttons'n'stuff
//		Container cp = frame.getContentPane();
//		cp.setLayout(new GridLayout(2, 2));
//		cp.add(new JButton("one"));
//		cp.add(new JButton("two"));
//		cp.add(new JButton("three"));
//		cp.add(new JButton("four"));
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// close program thread when windows is closed
		frame.setResizable(true);										// disable window resize
		frame.setLocationRelativeTo(null);								// window default location on screen (not corner)
		frame.add(game);												// add Main class into frame, important
		frame.setVisible(true);											// make frame visible
		frame.pack();													// Causes this Window to be sized to fit the preferred size and layouts of its subcomponents. 
		game.start();													// run start method from Game class
	}

}
