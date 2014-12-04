package ee.itcollege.llaidna;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;

	public KeyInput(Handler handler) {												// constructor. put to private Handler handler
		this.handler = handler;
	}
	
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();													// variable key - gets number value of pressed key
//    	int lastpressed = 0;															// records last pressed key
    	
    	for (int i = 0; i < handler.object.size(); i++) {							// loop through all the objects
			GameObject tempObject = handler.object.get(i);
			// Player1 KeyEvents when Score < 1
			if (Overlay.SCORE < 1 && tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_LEFT) {					// if KeyEvent = "Left" key
					tempObject.setVelY(0); 						// sets other axis vel to 0
					tempObject.setVelX(-2);						// sets desired axis vel to ...
				}
				if(key == KeyEvent.VK_UP) {						// if KeyEvent = "Up" key
					tempObject.setVelX(0);
					tempObject.setVelY(-2);
				}
				if(key == KeyEvent.VK_RIGHT) {					// if KeyEvent = "Right" key
					tempObject.setVelY(0); 
					tempObject.setVelX(2);
				}
				if(key == KeyEvent.VK_DOWN) {					// if KeyEvent = "Down" key
					tempObject.setVelX(0); 
					tempObject.setVelY(2);
				}
			}
			// Player1 KeyEvents when Score >= 1 - not allowed to get directly opposite direction!
			else if (Overlay.SCORE >= 1 && tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_LEFT && tempObject.getVelX() != 2) {					// if KeyEvent = "Left" key && current direction is not...
					tempObject.setVelX(-2);						// sets desired axis vel to ...
					tempObject.setVelY(0); 						// sets other axis vel to 0
				}
				if(key == KeyEvent.VK_UP && tempObject.getVelY() != 2) {						// if KeyEvent = "Up" key
					tempObject.setVelX(0);
					tempObject.setVelY(-2);
				}
				if(key == KeyEvent.VK_RIGHT && tempObject.getVelX() != -2) {					// if KeyEvent = "Right" key
					tempObject.setVelX(2);
					tempObject.setVelY(0); 
				}
				if(key == KeyEvent.VK_DOWN && tempObject.getVelY() != -2) {					// if KeyEvent = "Down" key
					tempObject.setVelX(0); 
					tempObject.setVelY(2);
				}
			}

			// Player2 KeyEvents when Score < 1
			if (Overlay.SCORE < 1 && tempObject.getId() == ID.Player2) {
				if(key == KeyEvent.VK_A) {					// if KeyEvent = "Left" key
					tempObject.setVelY(0); 						// sets other axis vel to 0
					tempObject.setVelX(-2);						// sets desired axis vel to ...
				}
				if(key == KeyEvent.VK_W) {						// if KeyEvent = "Up" key
					tempObject.setVelX(0);
					tempObject.setVelY(-2);
				}
				if(key == KeyEvent.VK_D) {					// if KeyEvent = "Right" key
					tempObject.setVelY(0); 
					tempObject.setVelX(2);
				}
				if(key == KeyEvent.VK_S) {					// if KeyEvent = "Down" key
					tempObject.setVelX(0); 
					tempObject.setVelY(2);
				}
			}
			// Player2 KeyEvents when Score >= 1 - not allowed to get directly opposite direction!
			else if (Overlay.SCORE >= 1 && tempObject.getId() == ID.Player2) {
				if(key == KeyEvent.VK_A && tempObject.getVelX() != 2) {					// if KeyEvent = "Left" key && current direction is not...
					tempObject.setVelX(-2);						// sets desired axis vel to ...
					tempObject.setVelY(0); 						// sets other axis vel to 0
				}
				if(key == KeyEvent.VK_W && tempObject.getVelY() != 2) {						// if KeyEvent = "Up" key
					tempObject.setVelX(0);
					tempObject.setVelY(-2);
				}
				if(key == KeyEvent.VK_D && tempObject.getVelX() != -2) {					// if KeyEvent = "Right" key
					tempObject.setVelX(2);
					tempObject.setVelY(0); 
				}
				if(key == KeyEvent.VK_S && tempObject.getVelY() != -2) {					// if KeyEvent = "Down" key
					tempObject.setVelX(0); 
					tempObject.setVelY(2);
				}
			}
    	
    	if(key == KeyEvent.VK_ESCAPE) System.exit(0);			// on ESCAPE keypress exits the game
    	
    	    	System.out.println(key);				// print out keyinput
    }

//    public void keyReleased(KeyEvent e) {
//    	int key = e.getKeyCode();
//    	
//    	for (int i = 0; i < handler.object.size(); i++) {							// loop through all the objects
//			GameObject tempObject = handler.object.get(i);
//// player 1
//			if (tempObject.getId() == ID.Player) {									// find ID.Player2
//				if(key == KeyEvent.VK_LEFT) tempObject.setVelY(0);					// if KeyEvent = "Left" key
//				if(key == KeyEvent.VK_UP) tempObject.setVelX(0);					// if KeyEvent = "Up" key
//				if(key == KeyEvent.VK_RIGHT) tempObject.setVelY(0);					// if KeyEvent = "Right" key
//				if(key == KeyEvent.VK_DOWN) tempObject.setVelX(0);					// if KeyEvent = "Down" key
//			}
//
//// player 2
//			if (tempObject.getId() == ID.Player2) {									// find ID.Player
//				if(key == KeyEvent.VK_A) tempObject.setVelY(0);						// if KeyEvent = "A" key
//				if(key == KeyEvent.VK_W) tempObject.setVelX(0);						// if KeyEvent = "W" key
//				if(key == KeyEvent.VK_D) tempObject.setVelY(0);						// if KeyEvent = "D" key
//				if(key == KeyEvent.VK_S) tempObject.setVelX(0);						// if KeyEvent = "S" key
//			}    	
//   
//    }
//	
//
//}
}
}