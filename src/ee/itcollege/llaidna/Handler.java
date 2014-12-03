package ee.itcollege.llaidna;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Loops through all game objects inside LinkedList... updates them, renders them to the screen
 */
public class Handler {													// loops through all game objects, updates them, renders them to the screen

//	LinkedList<GameObject> object = new LinkedList<GameObject>();		// list of all objects in the game

	
	// set public, cause Player in different package. list of all objects in the game.
	// alternative to use public setter, getter and not make this LList public. Should?
	public LinkedList<GameObject> object = new LinkedList<GameObject>();		
	
	public void tick() {
		for (int i = 0; i < object.size(); i++) {						// loops through ALL game objects
			GameObject tempObject = object.get(i);						// sets tempObject to currently looped object
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {									// loops through all game objects and renders them
		for (int i = 0; i < object.size(); i++) {						// 
			GameObject tempObject = object.get(i);						// 
			tempObject.render(g);										// 
		}
	}
	
	public void addObject(GameObject object) {							// +ADD object to LinkedList
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {						// -REMOVE object from LinkedList
		this.object.remove(object);
	}
	
}
