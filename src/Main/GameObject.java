package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

// all game objects considered this GameObject. Inheriting functions from here! Initializes variables etc. 
// Other objects will extend this GameObject

public abstract class GameObject {
	protected int x, y;							// xy coordinates
	protected ID id;							// enum
	protected int velX, velY;					// velocity aka speed
	
	public GameObject(int x, int y, ID id){		// constructor for GameObject. Sets automatically GameObject variables
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
	
	public void setId(ID id){
		this.id = id;
	}
	
	public ID getId() {
		return id;
	}
	
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