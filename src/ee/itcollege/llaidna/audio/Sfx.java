package ee.itcollege.llaidna.audio;

import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

public class Sfx {
	public static void score() {
		Sound score = TinySound.loadSound("sfx/238283.wav");
		score.play();
	}
}