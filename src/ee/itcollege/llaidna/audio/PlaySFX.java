package ee.itcollege.llaidna.audio;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

/**
 * Class for sound effects. TinySound initialization must be done before, in
 * Main class! Same with killing.
 * 
 * @author lauri
 */
public class PlaySFX {

	public static void scorefx1() {
		Sound score = TinySound.loadSound("sfx/213149.wav");
		if (score != null) {
			score.play();
		}
		System.out.println("scorefx1");
	}

	public static void scorefx2() {
		Sound die = TinySound.loadSound("sfx/212977.wav");
		if (die != null) {
			die.play();
		}
		System.out.println("scorefx1");
	}

	public static void teleportfx() {
		Sound teleport = TinySound.loadSound("sfx/238283.wav");
		if (teleport != null) {
			teleport.play();
		}
		System.out.println("teleportfx");
	}

	public static void diefx() {
		Sound diefx = TinySound.loadSound("sfx/147262.wav");
		if (diefx != null) {
			diefx.play();
		}
		System.out.println("diefx");
	}

	public static void player1winsfx() {
		Sound player1wins = TinySound.loadSound("sfx/player1wins.wav");
		if (player1wins != null) {
			player1wins.play();
		}
		System.out.println("player1winsfx");
	}

	public static void player2winsfx() {
		Sound player2wins = TinySound.loadSound("sfx/player2wins.wav");
		if (player2wins != null) {
			player2wins.play();
		}
		System.out.println("player2winsfx");
	}

	public static void tiesfx() {
		Sound tie = TinySound.loadSound("sfx/tie.wav");
		if (tie != null) {
			tie.play();
		}
		System.out.println("tie");
	}

}