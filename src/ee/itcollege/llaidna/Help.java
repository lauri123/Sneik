package ee.itcollege.llaidna;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Help overlay shown at start of game until SPACE is pressed.
 * 
 * @author lauri
 *
 */

public class Help {

	public void render(Graphics2D g) {

		g.setFont(new Font("Roboto", Font.PLAIN, 13)); // Set font and size
		Color color = new Color(0, 0.2f, 0.6f, 1f); // dark blue
		g.setPaint(color);
		if (KeyInput.visibility != false) { // Disappears after pressing Space
			g.fillRect(15, 70, 260, 203); // Draw rectangle for text bacround
			g.setPaint(Color.WHITE); // Set color for text
			g.drawString("\"Sneik!\"", 25, 95);
			g.drawString("- Player 1 is RED     - use ARROW keys", 25, 120);
			g.drawString("- Player 2 is GREEN - use WASD keys", 25, 135);

			g.drawString("The story goes:", 25, 160);
			g.drawString("Find food and grow your tail", 38, 178);
			g.drawString("Touch your own tail - no probs", 38, 193);
			g.drawString("Touch opponent's tail - Game Over", 38, 208);
			g.drawString("Wins the one who has more points!", 38, 222);

			g.drawString("Press ESC to quit", 25, 250);
			g.drawString("Press SPACE to start!", 25, 265);

			g.setFont(new Font("Roboto", Font.PLAIN, 7));
			g.drawString("Most of the back-end code has been written by", 15, Main.HEIGHT - 50);
			g.drawString("others, even if not so clearly marked in the code!", 15, Main.HEIGHT - 40);
			g.drawString("Lauri Laidna, IA18, Dec 2014", 15, Main.HEIGHT - 30);
		}
	}

}