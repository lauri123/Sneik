package ee.itcollege.llaidna;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;


/**
 * Overlay class - which includes everything we need to draw on screen as an overlay
 * @author someone
 * @author lauri modified and edited
 */

//public class Overlay extends JComponent {	//for g.drawimage
public class Overlay {
	

	public static int life = 100;
	public static int level = 0;

	public static int score1 = 0;
	public static int score2 = 0;
//	private int level = 1;
	private float timer = 1.0f;
	
	public void tick() {
//		LIFE = r.nextInt(65) + 20;				// wiggly life value
		life = Main.clamp(life, 0, 98);			// clamps life value
		timer -= timer*0.002f;
		
		if (Main.timeri < 1000) {
			level = 2;
		}
		if (Main.timeri >= 2000) {
			level = 3;
		}
		if (Main.timeri >= 4000) {
			level = 4;
		}
		if (Main.timeri >= 5000) {
			level = 5;
		}
		if (Main.timeri >= 6000) {
			level = 6;
		}
		if (Main.timeri >= 8000) {
			level = 7;
		}
		if (Main.timeri >= 10000) {
			level = 8;
		}
		if (Main.timeri >= 12000) {
			level = 9;
		}
		if (Main.timeri >= 15000) {
			level = 10;
		}
		
//		level = level + (Main.timeri / 500);
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
		g.drawString("P1 score:", Main.WIDTH - 99, 20);
		g.drawString("" + score1, Main.WIDTH - 30, 20);
		g.setColor(Color.RED);								// colored box around score to indicate player color
		g.draw3DRect((Main.WIDTH - 104), 7, 97, 16, true);
		
		// P2 score info
		g.setColor(Color.GREEN);							// colored box around score to indicate player color
		g.drawString("P2 score:", 13, 20);
		g.drawString("" + score2, 81, 20);
		g.draw3DRect(7, 7, 97, 16, true);

		g.setColor(Color.WHITE);							
		g.drawString("Level: ", Main.WIDTH/2 - 25, 20);
		g.drawString("" + (level - 1), Main.WIDTH/2 + 15, 20);

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
		
//		Image img1 = Toolkit.getDefaultToolkit().getImage("image.jpg");
//		g.drawImage(img1, 100, 100, this);
//		g.finalize();
//		g.drawImage(img1, 0, 0, Main.HEIGHT, Main.HEIGHT, 0, 0, 600, 600, this);
		
	}
}
