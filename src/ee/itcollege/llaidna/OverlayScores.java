package ee.itcollege.llaidna;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Calculates scores and includes everything we need to draw on screen
 * 
 * @author someone
 * @author lauri modified and edited
 */

public class OverlayScores {

	public static int level = 0;
	public static int score1 = 0; // Player1 score
	public static int score2 = 0; // Player2 score
	public static int scoresum = 0; // Sum of All Scores

	// Level calculator
	public void tick() {
		scoresum = score1 + score2;
		if (scoresum < 5) level = 0;
		if (scoresum >= 5) level = 1;
		if (scoresum >= 10) level = 2;
		if (scoresum >= 15) level = 3;
		if (scoresum >= 20) level = 4;
		if (scoresum >= 25) level = 5;
		if (scoresum >= 30) level = 6;
		if (scoresum >= 35) level = 7;
		if (scoresum >= 40) level = 8;
		if (scoresum >= 45) level = 9;
		if (scoresum >= 50) level = 10;
	}

	/**
	 * Draws score info + level overlay
	 * 
	 * @author lauri
	 * @param g
	 */

	public void render(Graphics2D g) {

		// Draw score and level to upper right corner
		g.setColor(Color.WHITE);
		g.setFont(new Font("Roboto", Font.PLAIN, 13));

		// Draw P1 score info
		// colored box around score to indicate player color
		g.setColor(Color.RED);
		g.draw3DRect(7, 7, 97, 16, true);
		g.drawString("P1 score:", 13, 20);
		g.drawString("" + score1, 81, 20);

		// Draw P2 score info
		// colored box around score to indicate player color
		g.setColor(Color.GREEN);
		g.drawString("P2 score:", 13, 41);
		g.drawString("" + score2, 81, 41);
		g.draw3DRect(7, 28, 97, 16, true);

		// Draw Level info
		g.setColor(Color.WHITE);
		if (level < 10) {
			g.drawString("Level: ", Main.WIDTH - 65, 20);
			g.drawString("" + (level), Main.WIDTH - 21, 20);
		} else {
			g.drawString("Deathmatch!", Main.WIDTH - 90, 20);
		}

		// draw FPS to lower right corner
		g.setFont(new Font("Roboto", Font.PLAIN, 12));
		g.drawString("FPS: ", Main.WIDTH - 65, Main.HEIGHT - 30);
		g.drawString("" + Main.FPS, Main.WIDTH - 35, Main.HEIGHT - 30);

	}
}