package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject {

	Random r = new Random();
	
	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);
		
//		velX = 0;
//		velY = 5;
//		x = r.nextInt();
//		y = r.nextInt();
		
		
	}

	/**
	 * Get Object bounds (rectangle size) to determine collisions.
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if (y <= 0 || y >= (Game.HEIGHT - 32)) {
			velY *= -1;
		}
		
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 16, 16);
	}
	
	

}
