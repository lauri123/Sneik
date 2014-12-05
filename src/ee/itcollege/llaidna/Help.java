package ee.itcollege.llaidna;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


/**
 * Help overlay
 * @author lauri
 *
 */

public class Help {

	public void tick() {
		Overlay.LIFE = Main.clamp(Overlay.LIFE, 0, 98);			// clamps life value
		
		}

	public void render(Graphics2D g) {
		
//		int type = AlphaComposite.SRC_OVER; 
//		AlphaComposite composite = AlphaComposite.getInstance(type, alpha);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Roboto", Font.PLAIN, 13));
		Color color = new Color(0, 0.2f, 0.6f, 1f); //Red
		g.setPaint(color);
		if (KeyInput.visibility != false) {
			g.fillRect(15, 70, 260, 203);
			g.setPaint(Color.WHITE);
			g.drawString("Sneik game for 2 players:", 25, 95);
			g.drawString("- Player 1 is RED     - use ARROW keys", 25, 110);
			g.drawString("- Player 2 is GREEN - use WASD keys", 25, 125);
			g.drawString("Press ESC to quit", 25, 250);
			g.drawString("Press SPACE to start", 25, 265);
		}		
	}

}

// line
//		g.setColor(Color.black);
//		g.fillRect(10, 50, 200, 6);
//		g.setColor(Color.red);
//		g.fillRect(12, 52, 100 , 2);