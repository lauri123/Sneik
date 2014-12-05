package ee.itcollege.llaidna;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


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
	private float timer = 1.0f;
	
	public void tick() {
//		LIFE = r.nextInt(65) + 20;				// wiggly life value
		LIFE = Main.clamp(LIFE, 0, 98);			// clamps life value
		timer -= timer*0.002f;
//		System.out.println(timer);
//		score++;
	}

	public void render(Graphics2D g) {
//		// health bar
//		g.setColor(Color.gray);
//		g.fillRect(10, 100, 200, 6);
//		g.setColor(Color.green);
//		g.fillRect(12, 102, LIFE * 2 , 2);
		
		// draw score and level to upper right corner
		g.setColor(Color.WHITE);
		g.setFont(new Font("Roboto", Font.PLAIN, 13));
		// P1 score info
		g.drawString("P1 score:", Main.WIDTH - 100, 20);
		g.drawString("" + SCORE1, Main.WIDTH - 20, 20);
		g.setColor(Color.RED);								// colored box around score to indicate player color
		g.draw3DRect((Main.WIDTH - 104), 7, 97, 16, true);
		
		// P2 score info
		g.setColor(Color.GREEN);							// colored box around score to indicate player color
		g.drawString("P2 score:", 15, 20);
		g.drawString("" + SCORE2, 90, 20);
		g.draw3DRect(7, 7, 97, 16, true);

		g.setColor(Color.WHITE);							
		g.drawString("Level: ", Main.WIDTH/2 - 25, 20);
		g.drawString("" + level, Main.WIDTH/2 + 15, 20);

		// draw FPS to lower right corner
		g.setFont(new Font("Roboto", Font.PLAIN, 12));
		g.drawString("FPS: ", Main.WIDTH - 65, Main.HEIGHT - 30);
		g.drawString("" + Main.FPS, Main.WIDTH - 35, Main.HEIGHT - 30);
		
		// draw author with fadeout
		//http://www.informit.com/articles/article.aspx?p=26349&seqNum=5
		float alpha = timer;
//		int type = AlphaComposite.SRC_OVER; 
//		AlphaComposite composite = AlphaComposite.getInstance(type, alpha);
		Color color = new Color(1, 1, 1, alpha); //Red
		g.setPaint(color);
		g.drawString("Lauri Laidna IA18 2014", 10, Main.HEIGHT - 30);
		
		
		
	}
}
