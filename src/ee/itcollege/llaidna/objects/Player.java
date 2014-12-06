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

	// Construct a Random object
	Random random = new Random();
	// create instance of Handler class
	Handler handler;
	
	/**
	 * New player constructor
	 * 
	 * @param x	x-coordinate
	 * @param y	y-coordinate
	 * @param idname
	 * @param handler	
	 */
	public Player(int x, int y, Id id, Handler handler) { // constructor method
		super(x, y, id);
		this.handler = handler; // handler into Player
	}
		
//		// start state players still
//		velX = 0;
//		velY = 0;
//		
//		// start direction of player moving randomly ((max-min)+min)
//		int rm = random.nextInt(4);
//		System.out.println("random for direction: " + rm);
//		if (rm == 0) {
//			velX =  2; 
//			velY =  0;			
//		}
//		if (rm == 1) {
//			velX =  0; 
//			velY =  2;
//		}
//		if (rm == 2) {
//			velX = -2; 
//			velY =  0;
//		}
//		if (rm == 3) {
//			velX =  0; 
//			velY = -2;
//		}

	/**
	 * Object bounds (rectangle size) to determine collisions.
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 10);
	}

	int counter1; // counter for player1 tail
	int counter2; // counter for player1 tail

	// implemented methods
	public void tick() {

//		// bumps from border of window
//		if (x <= 0 || x >= (Main.WIDTH - 14)) {		// manual clamping with if
//			velX *= -1;
//		}
//		
//		if (y <= 8 || y >= (Main.HEIGHT - 18)) {
//			velY *= -1;
//		}
//		
//		// move Player around each tick by amount of velX, velY
		
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
		
		collision(); // check collision every tick
		counter1 ++; // counter for TAIL object creation
		counter2 ++; // counter for TAIL object creation

		// add tail Player1
		if (this.getId() == Id.PLAYER1 && Overlay.score1 > 0 && counter1 > 7) {
			// addObject to handler, create
			handler.addObject(new Tail(this.x, this.y, Id.TAIL1, handler));
			counter1 = 0;
		}

		// add tail Player2
		if (this.getId() == Id.PLAYER2 && Overlay.score2 > 0 && counter2 > 7) {
			// addObject to handler, create
			handler.addObject(new Tail(this.x, this.y, Id.TAIL2, handler));
			counter2 = 0;
		}
	}

	/**
	 * Collision detection.
	 * Loops through all objects (handler).
	 * @author someone (of the basic logic)
	 */
	private void collision() {
			
			// Find collision with FOOD = SCORE + GROW TAIL!!!
			for (int i = 0; i < handler.object.size(); i++) { // for loop through all objects in game
				GameObject tempObject = handler.object.get(i); // create tempObject
				if (tempObject.getId() == Id.FOOD) { // is tempObject FOOD?
					if (getBounds().intersects(tempObject.getBounds())) { // use intersect method between getBounds & FOOD
						
						// Collision with FOOD
						if (this.getId() == Id.PLAYER1) {
							Overlay.score1 += 1;
							System.out.println(this.getId() + " scored");
							PlaySFX.scorefx1(); // sfx after scoring for player1
							handler.addObject(new Tail(tempObject.getX(), tempObject.getY(), Id.TAIL1, handler)); // addObject to handler, create
						}
						if (this.getId() == Id.PLAYER2) {
							Overlay.score2 += 1;
							System.out.println(this.getId() + " scored");
							PlaySFX.scorefx2(); // sfx after scoring for player2
							handler.addObject(new Tail(tempObject.getX(), tempObject.getY(), Id.TAIL2, handler)); // addObject to handler, create
						}
						handler.removeObject(tempObject);
						handler.addObject(new Food((Main.clamp(random.nextInt(Main.WIDTH), 25, Main.WIDTH - 40)), Main.clamp((random.nextInt(Main.HEIGHT)), 25, Main.HEIGHT - 50), Id.FOOD));	// addObject to handler, create
					}
				}
			}

			// Find collision with TAIL = DIE!!!
			// for loop through all objects in game
			for (int i = 0; i < handler.object.size(); i++) {
				// create tempObject
				GameObject tempObject = handler.object.get(i);
				// is tempObject TAIL2 and this PLAYER1?
				if (tempObject.getId() == Id.TAIL2 && this.getId() == Id.PLAYER1) {
					// use intersect method between getBounds this & TAIL2
					if (getBounds().intersects(tempObject.getBounds())) {
//						Overlay.score1 = 0;
						System.out.println(this.getId() + " died");
						// sfx after death
						PlaySFX.diefx();
						if (Overlay.score1 > Overlay.score2) {
							PlaySFX.player1winsfx();
						}
						if (Overlay.score1 < Overlay.score2) {
							PlaySFX.player2winsfx();
						}
						if (Overlay.score1 == Overlay.score2) {
							PlaySFX.tiesfx();
						}
						Main.end();
						Main.running = false;
						System.out.println(
								"Game OVER! Player 2 WINS with score of " + Overlay.score1 + " : " + Overlay.score2);
					}
				}
				
				// is tempObject TAIL2 and this PLAYER1?
				if (tempObject.getId() == Id.TAIL1 && this.getId() == Id.PLAYER2) {
					// use intersect method between getBounds this & TAIL2
					if (getBounds().intersects(tempObject.getBounds())) {
//						Overlay.score2 = 0;
						System.out.println(this.getId() + " died");
						// sfx after death
						PlaySFX.diefx();
						if (Overlay.score1 > Overlay.score2) {
							PlaySFX.player1winsfx();
						}
						if (Overlay.score1 < Overlay.score2) {
							PlaySFX.player2winsfx();
						}
						if (Overlay.score1 == Overlay.score2) {
							PlaySFX.tiesfx();
						}
						Main.end();
						Main.running = false;
						System.out.println(
								"Game OVER! Player 1 WINS with score of "+ Overlay.score1 + " : " + Overlay.score2);
					}
				}
			}
	}
	
	// Implemented method
	public void render(Graphics g) {
		if (id == Id.PLAYER1) {
			// Set color PLAYER1
			g.setColor(Color.red);
		} else {
			// Set color PLAYER2
			g.setColor(Color.green);				
		}
		// Draw player object
		g.fillOval(x, y, 10, 10);					
//		g.drawString("x", x, y);
		
	}

}
