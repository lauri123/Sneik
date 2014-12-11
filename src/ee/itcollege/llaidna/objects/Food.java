package ee.itcollege.llaidna.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import ee.itcollege.llaidna.GameObject;
import ee.itcollege.llaidna.Id;
import ee.itcollege.llaidna.Main;

/**
 * Class for food creation.
 * 
 * @author lauri
 *
 */
public class Food extends GameObject {

	// Random r = new Random();
	
	/**
	 * Food object
	 * 
	 * @param x		x-coordinate
	 * @param y		y-coordinate
	 * @param id	id
	 */
	public Food(int x, int y, Id id) {
		super(x, y, id);
	}

	/**
	 * Get Object bounds (rectangle size) to determine collisions.
	 * 
	 * @author lauri
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

	public void tick() {
	}

	/**
	 * Draws FOOD
	 */
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 16, 16);
	}

}
