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
		Music music = TinySound.loadMusic("167849.wav");
		music = TinySound.loadMusic(("167849.wav"), true); // true straight from file
		music.setVolume(volume);
		System.out.println("Global Volume is: " + volume);
		if (start == true) {
			music.play(loop); // true makes loop
		}
	}
}