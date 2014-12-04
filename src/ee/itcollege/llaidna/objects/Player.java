package ee.itcollege.llaidna.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

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
 */
public class Player extends GameObject {

	Random random = new Random();							// Construct a Random object
	Handler handler;										// create instance of Handler class
	
	public Player(int x, int y, ID id, Handler handler) {	// constructor
		super(x, y, id);
		this.handler = handler;								// handler into Player
		
//		// start state players still
//		velX = 0;
//		velY = 0;
//		
		// start direction of player moving randomly
		int rm = random.nextInt((4 - 0)+ 0);
		System.out.println("random for direction: " + rm);
		if (rm == 0) {
			velX =  2; velY =  0;			
		}
		if (rm == 1) {
			velX =  0; velY =  2;
		}
		if (rm == 2) {
			velX = -2; velY =  0;
		}
		if (rm == 3) {
			velX =  0; velY = -2;
		}
		
		
	}

	







	/**
	 * Object bounds (rectangle size) to determine collisions.
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 10);
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
		
		// move Player around each tick by amount of velX, velY
		x += velX;
		y += velY;

		
		// Teleport to other side
		if (x <= 3) {					//keep smaller!
			x = (Game.WIDTH - 13);		//keep smaller!
		}
		
		if (x >= (Game.WIDTH - 12)) {	//keep bigger!
			x = 4;						//keep bigger!
		}
		
		if (y <= 3) {					//keep smaller!
			y = (Game.HEIGHT - 33);		//keep smaller!
		}
		
		if (y >= (Game.HEIGHT - 32)) {	//keep bigger!
			y = 4; 						//keep bigger!
		}
		
		collision();					//check collision
	}

	/**
	 * Collision detection.
	 * Loops through all objects (handler).
	 * @author someone - of the logic
	 */
	private void collision() {
		
			for (int i = 0; i < handler.object.size(); i++) {				// for loop through all objects in game
				GameObject tempObject = handler.object.get(i);				// create tempObject
				if (tempObject.getId() == ID.BasicEnemy) {					// is tempObject valid to cause damage?
					if (getBounds().intersects(tempObject.getBounds())) {	// use intersect method between getBounds & enemy
						// what happens when collision occurs
						Overlay.SCORE += 1;
						handler.removeObject(tempObject);
						handler.addObject(new BasicEnemy((random.nextInt(Game.WIDTH-30)),(random.nextInt(Game.HEIGHT-30)), ID.BasicEnemy));	// addObject to handler, create
						handler.addObject(new Tail(this.x - this.velX*5, this.y - this.velY*5, ID.Tail, handler));	// addObject to handler, create
//						handler.addObject(new Tail(this.x - this.velX*5, this.y - this.velY*5, ID.Tail, handler));	// addObject to handler, create
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
		g.fillOval(x, y, 10, 10);					// create oval
		
	}



}
