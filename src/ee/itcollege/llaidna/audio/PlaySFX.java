package ee.itcollege.llaidna.audio;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

/**
 * Class for sound effects.
 * @author lauri
 */
public class PlaySFX {
	
	public static void scorefx() {
		Sound score = TinySound.loadSound("sfx/213149.wav");
		score.play();
		System.out.println("scorefx");
	}
	
	public static void teleportfx() {
		Sound teleport = TinySound.loadSound("sfx/238283.wav");
		teleport.play();
		System.out.println("teleportfx");
	}
	
	public static void diefx() {
		Sound die = TinySound.loadSound("sfx/147262.wav");
		die.play();
		System.out.println("diefx");
	}
	
	
	
}