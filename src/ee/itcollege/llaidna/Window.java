package ee.itcollege.llaidna;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;



import javax.swing.JFrame;

/**
 * Creates JFrame windows
 * 
 * @author lauri
 *
 */

@SuppressWarnings("serial")
public class Window extends Canvas {

	public Window(int width, int height, String title, Main game) {
		JFrame frame = new JFrame(title); // create a frame (JFrame library)

		game.setPreferredSize(new Dimension(width, height));
		game.setMaximumSize(new Dimension(width, height));
		game.setMinimumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close program thread
		frame.setResizable(false); // disable window resize
		frame.add(game); // add Main class into frame, important
		frame.pack(); // size to fit the canvas
		frame.setLocationRelativeTo(null); // window start location not corner
		frame.setVisible(true); // make frame visible
		game.start(); // run start method from Game class
	}

}