package ee.itcollege.llaidna;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


/**
 * Overlay class - which includes everything we need to draw on screen as an overlay
 * @author someone
 * @author lauri modified and edited
 */

public class Overlay {
	

//	Random r = new Random();
	public static int LIFE = 100;

//	private int score = 0;
	public static int SCORE1 = 0;
	public static int SCORE2 = 0;
	private int level = 1;
	
	public void tick() {
//		LIFE = r.nextInt(65) + 20;				// wiggly life value
		LIFE = Game.clamp(LIFE, 0, 98);			// clamps life value
//		score++;
	}

	public void render(Graphics g) {
		// health bar
		g.setColor(Color.gray);
		g.fillRect(10, 100, 200, 6);
		g.setColor(Color.green);
		g.fillRect(12, 102, LIFE * 2 , 2);
		
		// draw score and level to upper right corner
		g.setColor(Color.WHITE);

		// P1 score info
		g.drawString("Score P1:", Game.WIDTH - 100, 20);
		g.drawString("" + SCORE1, Game.WIDTH - 35, 20);
		g.setColor(Color.GREEN);							// colored box around score to indicate player color
		g.draw3DRect(7, 7, 97, 16, true);
		
		// P2 score info
		g.drawString("Score P2:", 15, 20);
		g.drawString("" + SCORE2, 80, 20);
		g.setColor(Color.RED);								// colored box around score to indicate player color
		g.draw3DRect((Game.WIDTH - 104), 7, 97, 16, true);

		g.setColor(Color.WHITE);							
		g.drawString("Level: ", Game.WIDTH/2 - 25, 20);
		g.drawString("" + level, Game.WIDTH/2 + 15, 20);

		// draw FPS to lower right corner
		g.drawString("FPS: ", Game.WIDTH - 80, Game.HEIGHT - 30);
		g.drawString("" + Game.FPS, Game.WIDTH - 35, Game.HEIGHT - 30);
		
		// draw author
		g.drawString("Lauri Laidna IA18", 10, Game.HEIGHT - 30);
		
		
		
	}
}
