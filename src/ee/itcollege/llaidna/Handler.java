package ee.itcollege.llaidna;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Loops through all game objects inside LinkedList... updates them, renders
 * them to the screen
 * 
 * @author someone
 */

public class Handler { // loops through all game objects, updates them, renders them to the screen

	// LinkedList<GameObject> object = new LinkedList<GameObject>();
	// set public, cause Player in different package.
	// List of all objects in the game.
	// Alternative to use public setter, getter and not make this LL public.
	public LinkedList<GameObject> object = new LinkedList<GameObject>();

	public void tick() {
		// loops through ALL game objects
		for (int i = 0; i < object.size(); i++) {
			// sets tempObject to currently looped object
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}

	// loops through all game objects and renders them
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}

	// +ADD object to LinkedList
	public void addObject(GameObject object) {
		this.object.add(object);
	}

	// -REMOVE object from LinkedList
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

}