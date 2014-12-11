package ee.itcollege.llaidna.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import ee.itcollege.llaidna.GameObject;
import ee.itcollege.llaidna.Handler;
import ee.itcollege.llaidna.Id;
import ee.itcollege.llaidna.Main;
import ee.itcollege.llaidna.OverlayScores;


/**
 * Tail class extends GameObjects:
 * - Handler
 * - public Player constructor
 * - Rectangle getBounds
 * - tick
 * - collisions
 * - render
 */
public class Tail extends GameObject {

	Random random = new Random(); // Construct a Random object
	Handler handler; // create instance of Handler class

	/**
	 * Tail constructor
	 * 
	 * @param x	x-coordinate
	 * @param y	y-coordinate
	 * @param id name it
	 * @param handler
	 */
	public Tail(int x, int y, Id id, Handler handler) { // constructor
		super(x, y, id);
		this.handler = handler; // handler into Player
	}

	/**
	 * Object bounds (rectangle size) to determine collisions.
	 * 
	 * @author someone
	 * @author lauri edited, added, modified
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 10);
	}

	int counter1 = 0;
	int counter2 = 0;

	public void tick() { // implemented methods
		// this cuts off the tail after counted time. Kills the tail elements
		counter1++;
		counter2++;
		// for loop through all objects in game
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i); // create tempObject
			// is tempObject eaten?
			if (tempObject.getId() == Id.TAIL1
					&& counter1 == OverlayScores.score1 * 7) {
				handler.removeObject(tempObject);
				counter1 = 0;
			}

			if (tempObject.getId() == Id.TAIL2
					&& counter2 == OverlayScores.score2 * 7) {
				handler.removeObject(tempObject);
				counter2 = 0;
			}
		}
		
		// Teleport to other side
		if (x <= 3) { // keep smaller!
			x = (Main.WIDTH - 13); // keep smaller!
		}

		if (x >= (Main.WIDTH - 12)) { // keep bigger!
			x = 4; // keep bigger!
		}

		if (y <= 3) { // keep smaller!
			y = (Main.HEIGHT - 33); // keep smaller!
		}

		if (y >= (Main.HEIGHT - 32)) { // keep bigger!
			y = 4; // keep bigger!
		}

	}

	public void render(Graphics g) { // implemented methods
		if (id == Id.TAIL1) {
			g.setColor(Color.red);
			; // set PLAYER1 TAIL1 color
		}
		if (id == Id.TAIL2) {
			g.setColor(Color.green); // set PLAYER2 TAIL2 color
		}
		g.fillRoundRect(x + 2, y + 2, 5, 5, 1, 1); // create rectangle
	}
}