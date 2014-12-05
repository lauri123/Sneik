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
//	private float timer = 1.0f;
	
	public void tick() {
//		timer -= timer*0.002f;
		
		if (Main.timeri < 400) {
			level = 0;
		}
		if (Main.timeri >= 800) {
			level = 1;
		}
		if (Main.timeri >= 1200) {
			level = 2;
		}
		if (Main.timeri >= 1500) {
			level = 3;
		}
		if (Main.timeri >= 2000) {
			level = 4;
		}
		if (Main.timeri >= 2500) {
			level = 5;
		}
		if (Main.timeri >= 3000) {
			level = 6;
		}
		if (Main.timeri >= 4000) {
			level = 7;
		}
		if (Main.timeri >= 5000) {
			level = 8;
		}
		if (Main.timeri >= 6000) {
			level = 9;
		}
		if (Main.timeri >= 8000) {
			level = 10;
		}
		
//		level = level + (Main.timeri / 500);
//		System.out.println(timer);
//		score++;
	}
/**
 * @author lauri
 * @param g
 */
	public void render(Graphics2D g) {
		
		// Draw score and level to upper right corner
		g.setColor(Color.WHITE);
		g.setFont(new Font("Roboto", Font.PLAIN, 13));
		
		// Draw P1 score info
		g.drawString("P1 score:", 13, 20);
		g.drawString("" + score1, 81, 20);
		g.setColor(Color.RED);								// colored box around score to indicate player color
		g.draw3DRect(7, 7, 97, 16, true);
		
		// Draw P2 score info
		g.setColor(Color.GREEN);							// colored box around score to indicate player color
		g.drawString("P2 score:", 13, 41);
		g.drawString("" + score2, 81, 41);
		g.draw3DRect(7, 28, 97, 16, true);

		// Draw Level info
		g.setColor(Color.WHITE);
		
		if (level < 10) {
			g.drawString("Level: ", Main.WIDTH - 65, 20);
			g.drawString("" + (level), Main.WIDTH - 21, 20);			
		}
		else {
			g.drawString("Deathmatch!", Main.WIDTH - 90, 20);
		}
		

		// draw FPS to lower right corner
		g.setFont(new Font("Roboto", Font.PLAIN, 12));
		g.drawString("FPS: ", Main.WIDTH - 65, Main.HEIGHT - 30);
		g.drawString("" + Main.FPS, Main.WIDTH - 35, Main.HEIGHT - 30);
		
		// draw author with fadeout
		//http://www.informit.com/articles/article.aspx?p=26349&seqNum=5
//		float alpha = timer;
//		Color color = new Color(1, 1, 1, alpha); //Red
//		g.setPaint(color);
//		g.drawString("Lauri Laidna IA18 2014", 10, Main.HEIGHT - 30);
		
//		Image img1 = Toolkit.getDefaultToolkit().getImage("image.jpg");
//		g.drawImage(img1, 100, 100, this);
//		g.finalize();
//		g.drawImage(img1, 0, 0, Main.HEIGHT, Main.HEIGHT, 0, 0, 600, 600, this);
		
	}
}
