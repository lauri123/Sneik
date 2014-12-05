package ee.itcollege.llaidna.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import ee.itcollege.llaidna.GameObject;
import ee.itcollege.llaidna.Handler;
import ee.itcollege.llaidna.Id;
import ee.itcollege.llaidna.Main;
import ee.itcollege.llaidna.Overlay;
import ee.itcollege.llaidna.audio.PlaySFX;

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
	
	/**
	 * 
	 * @param x			x-coordinate
	 * @param y			y-coordinate
	 * @param id		name
	 * @param handler	
	 */
	
	public Player(int x, int y, Id id, Handler handler) {	// constructor
		super(x, y, id);
		this.handler = handler;								// handler into Player
		
//		// start state players still
//		velX = 0;
//		velY = 0;
//		
//		// start direction of player moving randomly
//		int rm = random.nextInt((4 - 0)+ 0);
//		System.out.println("random for direction: " + rm);
//		if (rm == 0) {
//			velX =  2; velY =  0;			
//		}
//		if (rm == 1) {
//			velX =  0; velY =  2;
//		}
//		if (rm == 2) {
//			velX = -2; velY =  0;
//		}
//		if (rm == 3) {
//			velX =  0; velY = -2;
//		}
		
		
	}

	/**
	 * Object bounds (rectangle size) to determine collisions.
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 10);
	}
	int counter;
	public void tick() {							// implemented methods
		
//		// bumps from border of window
//		if (x <= 0 || x >= (Main.WIDTH - 14)) {		// manual clamping with if
//			velX *= -1;
//		}
//		
//		if (y <= 8 || y >= (Main.HEIGHT - 18)) {
//			velY *= -1;
//		}
		
		// move Player around each tick by amount of velX, velY
		x += velX;
		y += velY;

		
		// Teleport to other side
		if (x <= 3) {					//keep smaller!
			x = (Main.WIDTH - 13);		//keep smaller!
			PlaySFX.teleportfx();		//teleport sfx play
		}
		
		if (x >= (Main.WIDTH - 12)) {	//keep bigger!
			x = 4;						//keep bigger!
			PlaySFX.teleportfx();		//teleport sfx play
		}
		
		if (y <= 3) {					//keep smaller!
			y = (Main.HEIGHT - 33);		//keep smaller!
			PlaySFX.teleportfx();		//teleport sfx play
		}
		
		if (y >= (Main.HEIGHT - 32)) {	//keep bigger!
			y = 4; 						//keep bigger!
			PlaySFX.teleportfx();		//teleport sfx play
		}
		
		collision();					//check collision
		counter ++;
		
		// add tail
		if (Overlay.SCORE1 > 0 && counter >= 7) {
			handler.addObject(new Tail(this.x, this.y, Id.TAIL1, handler));	// addObject to handler, create
			counter = 0;
		}
	}

	/**
	 * Collision detection.
	 * Loops through all objects (handler).
	 * @author someone (of the basic logic)
	 */
	private void collision() {
		
			for (int i = 0; i < handler.object.size(); i++) {				// for loop through all objects in game
				GameObject tempObject = handler.object.get(i);				// create tempObject
				if (tempObject.getId() == Id.FOOD) {					// is tempObject valid to cause damage?
					if (getBounds().intersects(tempObject.getBounds())) {	// use intersect method between getBounds & enemy
						
						// Collision with FOOD
						if (this.getId() == Id.PLAYER1) {
							Overlay.SCORE1 += 1;
							System.out.println(this.getId() + " scored");							
						}
						else {
							Overlay.SCORE2 += 1;
							System.out.println(this.getId() + " scored");
						}
						PlaySFX.scorefx();
						handler.removeObject(tempObject);
						handler.addObject(new Food((Main.clamp(random.nextInt(Main.WIDTH), 10, Main.WIDTH - 40)), Main.clamp((random.nextInt(Main.HEIGHT)), 10, Main.HEIGHT - 50), Id.FOOD));	// addObject to handler, create
						handler.addObject(new Tail(this.x, this.y, Id.TAIL1, handler));	// addObject to handler, create
					}
				}
			}
			
			
			
	}
	
	public void render(Graphics g) {				// implemented methods
		if (id == Id.PLAYER1) {
			g.setColor(Color.red);					// set color
//		if (id == ID.Tail) {
//			g.setColor(Color.white);					// set color
		} else {
			g.setColor(Color.green);				// set color
		}
		g.fillOval(x, y, 10, 10);					// create oval
		
	}

	public int getCounter() {
		return counter;
	}



}
