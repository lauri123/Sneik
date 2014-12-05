package ee.itcollege.llaidna.audio;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

/**
 * Class for sound effects.
 * @author lauri
 */
public class PlaySFX {
	
	public static void scorefx1() {
		Sound score = TinySound.loadSound("sfx/213149.wav");
		score.play();
		System.out.println("scorefx1");
	}
	
	
	public static void scorefx2() {
		Sound die = TinySound.loadSound("sfx/212977.wav");
		die.play();
		System.out.println("scorefx1");
	}
	

	public static void teleportfx() {
		Sound teleport = TinySound.loadSound("sfx/238283.wav");
		teleport.play();
		System.out.println("teleportfx");
	}

	public static void diefx() {
		Sound diefx = TinySound.loadSound("sfx/147262.wav");
		diefx.play();
		System.out.println("diefx");
	}
	
	public static void player1winsfx() {
			Sound player1wins = TinySound.loadSound("sfx/player1wins.wav");
			player1wins.play();
			System.out.println("player1winsfx");
//			Sound gameover = TinySound.loadSound("sfx/gameover.wav");
//			gameover.play();
	}
	
	public static void player2winsfx() {
			Sound player2wins = TinySound.loadSound("sfx/player2wins.wav");
			player2wins.play();
			System.out.println("player2winsfx");
//			Sound gameover = TinySound.loadSound("sfx/gameover.wav");
//			gameover.play();
	}
	
	public static void tiesfx() {
		Sound tie = TinySound.loadSound("sfx/tie.wav");
		tie.play();
		System.out.println("tie");
//		Sound gameover = TinySound.loadSound("sfx/gameover.wav");
//		gameover.play();
}

	
}