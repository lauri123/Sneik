package ee.itcollege.llaidna.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;

import ee.itcollege.llaidna.Game;
import ee.itcollege.llaidna.GameObject;
import ee.itcollege.llaidna.Handler;
import ee.itcollege.llaidna.ID;
import ee.itcollege.llaidna.Overlay;


/**
 * Player class extends GameObjects:
 * - Handler
 * - public Player constructor
 * - Rectangle getBounds
 * - tick
 * - collisions
 * - render
 * blablatest12
 */
public class Player extends GameObject {

	Random r = new Random();
	Handler handler;										// create instance of Handler class
	
	public Player(int x, int y, ID id, Handler handler) {	// constructor
		super(x, y, id);
		this.handler = handler;								// handler into Player
		
//		// start state players still
//		velX = 0;
//		velY = 0;
//		
		// start state player moving randomly
		if (r.nextInt((1)+1) > 0) {
			velX = 1;
			velY = 0;			
		}
		else {
			velX = 0;
			velY = 1;
		}
	}

	/**
	 * Get Object bounds (rectangle size) to determine collisions.
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	public void tick() {							// implemented methods
		
//		// bumps from border of window
//		if (x <= 0 || x >= (Game.WIDTH - 32)) {		// manual clamping with if
//			velX *= -1;
//		}
//		
//		if (y <= 0 || y >= (Game.HEIGHT - 52)) {
//			velY *= -1;
//		}
		
		// Teleport to other side
		if (x == -16) {
			x = Game.WIDTH - 16;
		}
		
		if (x > (Game.WIDTH - 16)) {				// manual clamping with if
			x = 0;
		}
		
		if (y == -16) {
			y = Game.HEIGHT - 16;
		}
		
		if (y > (Game.HEIGHT - 16)) {
			y = 0;
		}
		
		x += velX;
		y += velY;
		
		collision();
	}

	private void collision() {
		
			for (int i = 0; i < handler.object.size(); i++) {				// for loop through all objects in game
				GameObject tempObject = handler.object.get(i);				// create tempObject
				if (tempObject.getId() == ID.BasicEnemy) {					// is tempObject valid to cause damage?
					if (getBounds().intersects(tempObject.getBounds())) {	// use intersect method between getBounds & enemy
						// what happens when collision occurs
						Overlay.LIFE -=2;
					}
				}
			}
			
	}
	
	public void render(Graphics g) {				// implemented methods
		if (id == ID.Player) {
			g.setColor(Color.red);					// set color
		} else {
			g.setColor(Color.green);				// set color
		}
		g.fillOval(x, y, 32, 32);					// create oval
		
	}



}
