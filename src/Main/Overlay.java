package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Overlay {
	

//	Random r = new Random();
	public static int LIFE = 100;
	
	private int score = 0;
	private int level = 1;
	
	public void tick() {
//		LIFE = r.nextInt(65) + 20;				// wiggly life value
		LIFE = Game.clamp(LIFE, 0, 98);			// clamps life value
		score++;
	}

	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(10, 10, 200, 6);
		g.setColor(Color.green);
		g.fillRect(12, 12, LIFE * 2 , 2);
		
		// draw score and level to upper right corner
		g.setColor(Color.WHITE);
		g.drawString("Score:", Game.WIDTH - 80, 15);
		g.drawString("" + score, Game.WIDTH - 35, 15);
		g.drawString("Level: ", Game.WIDTH - 80 , 30);
		g.drawString("" + level, Game.WIDTH - 35, 30);

		// draw FPS to lower right corner
		g.drawString("FPS: ", Game.WIDTH - 80, Game.HEIGHT - 25);
		g.drawString("" + Game.FPS, Game.WIDTH - 35, Game.HEIGHT - 25);
		
	}
}
