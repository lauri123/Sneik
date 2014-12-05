package ee.itcollege.llaidna;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


/**
 * Rolling help
 * @author lauri
 *
 */

public class Help {
	

	private float timerf = 1.0f;
//	private int timeri = 1;
	
	
	public void tick() {
		Overlay.LIFE = Main.clamp(Overlay.LIFE, 0, 98);			// clamps life value
		timerf -= timerf*0.002f;
//		System.out.println(Main.timeri);
		
		}
		
		
		
		
		
		
		
		
		

	public void render(Graphics2D g) {
		// health bar
		g.setColor(Color.gray);
		g.fillRect(10, 50, 200, 6);
		g.setColor(Color.green);
		g.fillRect(12, 52, Overlay.LIFE * 2 , 2);
		
		// draw score and level to upper right corner
		g.setColor(Color.WHITE);
		g.setFont(new Font("Roboto", Font.PLAIN, 13));
//		g.drawString("P1 score:", 100, 100);

		//float alpha = timerf;
//		int type = AlphaComposite.SRC_OVER; 
//		AlphaComposite composite = AlphaComposite.getInstance(type, alpha);
		Color color = new Color(1, 1, 1, 1f); //Red
		g.setPaint(color);
		if (KeyInput.visibility != false) {
			g.drawString("Sneik game for 2 players:", 25, 95);
			g.drawString("- Player 1 is RED     - use arrow keys", 25, 110);
			g.drawString("- Player 2 is GREEN - use WASD keys", 25, 125);
			g.drawString("Press ESC to quit.", 25, 150);
			g.drawString("Press SPACE to start!", 25, 165);
		}
		
		
		
	}

}

