package ee.itcollege.llaidna.audio;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.TinySound;

/**
 * Class for music.
 * 
 * @author lauri
 */
public class PlayMusic {

	/**
	 * Method for music.
	 * 
	 * @param loop		boolean true or false, to loop or not to loop?
	 * @param volume	set volume
	 * @param start		start music or not, true or false
	 * @author lauri
	 */
	public static void music(boolean loop, double volume, boolean start) {
		Music music = TinySound.loadMusic("167849.wav", true);
		if (music == null) {
			System.err.println("Music file not found or audio not initialized.");
			return;
		}
		music.setVolume(volume);
		System.out.println("Global Volume is: " + volume);
		if (start) {
			music.play(loop); // true makes loop
		}
	}
}