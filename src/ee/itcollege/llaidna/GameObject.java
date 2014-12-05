package ee.itcollege.llaidna;

import java.awt.Graphics;
import java.awt.Rectangle;

// all game objects considered this GameObject. Inheriting functions from here! Initializes variables etc. 
// Other objects will extend this GameObject


/**
 * 
 * @author someone - most of logic and code
 */
public abstract class GameObject {
	protected int x, y;							// xy coordinates
	protected Id id;							// enum
	protected int velX, velY;					// velocity aka speed
	protected int tailX, tailY;					// xy coordinates
	protected int tailVelX, tailVelY;			// tail velocity aka speed
	
	public GameObject(int x, int y, Id id){		// constructor for GameObject. Sets automatically GameObject variables
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();		// Collision detection method, false = no collision, true = collision
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setId(Id id){
		this.id = id;
	}
	
	public Id getId() {
		return id;
	}
	// ------------------------------------------------ tail
	
	public void setTailVelX(int tailVelX) {
		this.tailVelX = tailVelX;
	}
	
	public void setTailVelY(int tailVelY) {
		this.tailVelY = tailVelY;
	}
	
	public int getTailVelX() {
		return tailVelX;
	}
	
	public int getTailVelY() {
		return tailVelY;
	}
	// ------------------------------------------------
	public void setVelX(int velX) {
		this.velX = velX;
	}
	
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public int getVelY() {
		return velY;
	}

}