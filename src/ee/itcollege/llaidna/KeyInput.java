package ee.itcollege.llaidna;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * KeyListener and "driver" - includes all the snake moving logic!
 * 
 * @author lauri - modified a lot! Built it for snake type game
 * @author someone - logic of KeyListener
 *
 */

public class KeyInput extends KeyAdapter {

	public static boolean visibility = true; // visibility for start & help
	private Handler handler;

	// constructor. put to private Handler handler
	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {

		// variable key - gets number value of pressed key
		int key = e.getKeyCode();
		// loop through all the objects
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			// Start the game, remove Help overlay
			if (key == KeyEvent.VK_SPACE) {
				visibility = false;
				System.out.println("visibility set " + key + " and " + visibility);
			}

			// Player1 KeyEvents when Score < 1
			if (visibility == false && OverlayScores.score1 < 1 && tempObject.getId() == Id.PLAYER1) {
				if (key == KeyEvent.VK_LEFT) { // if KeyEvent = "Left" key
					tempObject.setVelY(0); // sets other axis vel to 0
					tempObject.setVelX(-2); // sets desired axis vel to ...
				}
				if (key == KeyEvent.VK_UP) { // if KeyEvent = "Up" key
					tempObject.setVelX(0);
					tempObject.setVelY(-2);
				}
				if (key == KeyEvent.VK_RIGHT) { // if KeyEvent = "Right" key
					tempObject.setVelY(0);
					tempObject.setVelX(2);
				}
				if (key == KeyEvent.VK_DOWN) { // if KeyEvent = "Down" key
					tempObject.setVelX(0);
					tempObject.setVelY(2);
				}
			}
			// Player1 KeyEvents when Score >= 1 - not allowed to go directly opposite direction!
			else if (visibility == false && OverlayScores.score1 >= 1 && tempObject.getId() == Id.PLAYER1) {
				// if KeyEvent = "Left" key && current direction is not...
				if (key == KeyEvent.VK_LEFT && tempObject.getVelX() != 2) {
					tempObject.setVelX(-2); // sets desired axis vel to ...
					tempObject.setVelY(0); // sets other axis vel to 0
				}
				// if KeyEvent = "Up" key
				if (key == KeyEvent.VK_UP && tempObject.getVelY() != 2) {
					tempObject.setVelX(0);
					tempObject.setVelY(-2);
				}
				// if KeyEvent = "Right" key
				if (key == KeyEvent.VK_RIGHT && tempObject.getVelX() != -2) {
					tempObject.setVelX(+2);
					tempObject.setVelY(0);
				}
				// if KeyEvent = "Down" key
				if (key == KeyEvent.VK_DOWN && tempObject.getVelY() != -2) {
					tempObject.setVelX(0);
					tempObject.setVelY(+2);
				}
			}

	// Player2 KeyEvents when Score < 1
			if (visibility == false && OverlayScores.score2 < 1	&& tempObject.getId() == Id.PLAYER2) {
				if (key == KeyEvent.VK_A) { // if KeyEvent = "Left" key
					tempObject.setVelY(0); // sets other axis vel to 0
					tempObject.setVelX(-2); // sets desired axis vel to ...
				}
				if (key == KeyEvent.VK_W) { // if KeyEvent = "Up" key
					tempObject.setVelX(0);
					tempObject.setVelY(-2);
				}
				if (key == KeyEvent.VK_D) { // if KeyEvent = "Right" key
					tempObject.setVelY(0);
					tempObject.setVelX(+2);
				}
				if (key == KeyEvent.VK_S) { // if KeyEvent = "Down" key
					tempObject.setVelX(0);
					tempObject.setVelY(+2);
				}
			}
			// Player2 KeyEvents when Score >= 1 - not allowed to go directly opposite direction!
			else if (visibility == false && OverlayScores.score2 >= 1
					&& tempObject.getId() == Id.PLAYER2) {
				// if KeyEvent = "Left" key && current direction is not...
				if (key == KeyEvent.VK_A && tempObject.getVelX() != 2) {
					tempObject.setVelX(-2); // sets desired axis vel to ...
					tempObject.setVelY(0); // sets other axis vel to 0
				}
				// if KeyEvent = "Up" key
				if (key == KeyEvent.VK_W && tempObject.getVelY() != 2) {
					tempObject.setVelX(0);
					tempObject.setVelY(-2);
				}
				// if KeyEvent = "Right" key
				if (key == KeyEvent.VK_D && tempObject.getVelX() != -2) {
					tempObject.setVelX(+2);
					tempObject.setVelY(0);
				}
				// if KeyEvent = "Down" key
				if (key == KeyEvent.VK_S && tempObject.getVelY() != -2) {
					tempObject.setVelX(0);
					tempObject.setVelY(+2);
				}
			}

			// System.out.println(key); // print out keyinput
			if (key == KeyEvent.VK_ESCAPE)
				System.exit(0); // on ESCAPE keypress exits the game

		}
	}
}