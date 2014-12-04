package ee.itcollege.llaidna.audio;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.TinySound;

/**
 * Class for music.
 * @author lauri
 */
public class PlayMusic {

	/**
	 * Play music
	 * @param length	length in seconds (put loop parameter false!)
	 * @param loop		true or false (length parameter doesn't matter!)
	 */
	public static void music(int length, boolean loop) {
		Music music = TinySound.loadMusic("167849.wav");
		music = TinySound.loadMusic(("167849.wav"), true);				// true straight from file
		music.play(loop);												// true makes loop
	}
}
		











// -------------- ignore -------------------------------------------------------


//		// initialize TinySound
//		TinySound.init();
//load music //note: you can also load with Files, URLs and InputStreams
		//start playing the music on loop
//		if (loop == true) {
//			music.play(true);
//			System.out.println("music on loop");
//			while (loop) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {}
//			}
//		}
//		
//		//play music for given "length" of seconds
//		if (loop == false) {
//			music.play(true);
//			System.out.println("music playtime " + length +"s");
//			//play the sound "length" times 1s in a loop
//			for (int i = 0; i < length*100; i++) {
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {}
//			}
//		}
//	}
//	
//	public static void sfx() {
//		//load sfx
//		//note: you can also load with Files, URLs and InputStreams
//		System.out.println("sfx");
//		TinySound.init();
//		Sound sfx = TinySound.loadSound("sfx/238283.wav");
//		sfx.play();
//		TinySound.shutdown();
//		//start playing the music on loop
//			//play the sound "length" times 1s in a loop
////			for (int i = 0; i < 1; i++) {
////				try {
////					Thread.sleep(300);
////				} catch (InterruptedException e) {}
//			}
//	}
//
//	/*
//	// lets test audio stuff!
//	public static void main(String[] args) {
////		music(3, true);
//		//initialize TinySound
//		TinySound.init();
//		music(3, false);
//		sfx();
////		sfx();
////		sfx();
//
//		//shutdown when done
//		TinySound.shutdown();
//	}
//	*/
//}
