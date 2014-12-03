package Main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

// create a window class
public class Window extends Canvas {

//	private static final long serialVersionUID = 7883803474888262873L;	//??
	
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title); 								// create a frame (JFrame library)
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// close program thread when windows is closed
		frame.setResizable(false);										// disable window resize
		frame.setLocationRelativeTo(null);								// window default location on screen (not corner)
		frame.add(game);												// add Game class into frame, important (why?)
		frame.setVisible(true);											// make frame visible
		frame.pack();													// Causes this Window to be sized to fit the preferred size and layouts of its subcomponents. 
		game.start();													// run start method from Game class
	}
	
	

}
