package ee.itcollege.llaidna.audio;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;



/**
 * TinySound is the main class of the TinySound system.  In order to use the
 * TinySound system, it must be initialized.  After that, Music and Sound
 * objects can be loaded and used.  When finished with the TinySound system, it
 * must be shutdown.
 * 
 * @author (original) Finn Kuusisto
 * @author lauri
 */
public class Audio {

	public static void music(int length, boolean loop) {
		//initialize TinySound
		TinySound.init();
		//load a sound and music
		//note: you can also load with Files, URLs and InputStreams
		Music song = TinySound.loadMusic("167849.wav");
		Sound coin = TinySound.loadSound("silence.wav");
		if (loop == true) {
			//start playing the music on loop
			song.play(true);
			System.out.println("music on loop");
			while (loop) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		}
		if (loop == false) {
			//start playing the music on loop
			song.play(true);
			System.out.println("music playtime " + length +"s");
			//play the sound a few times in a loop
			for (int i = 0; i < length; i++) {
				coin.play();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		}
		//be sure to shutdown TinySound when done
		TinySound.shutdown();
		
	}
	
	// lets test audio stuff!
	public static void main(String[] args) {
		music(3, true);
	}
	
}





















//package ee.itcollege.llaidna.audio;
//
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//
//public class Audio {
//
////	private Clip clip;
//	
//	public Audio(String s) {
//		
//		String bip = "s";
//		Media hit = new Media(bip);
//		MediaPlayer mediaPlayer = new MediaPlayer(hit);
//		mediaPlayer.play();
//		
//	}
//}
//		
//		
//		
		
		
//		try {
//			
//		AudioInputStream audioin;
//			audioin = AudioSystem.getAudioInputStream(
//					getClass().getResourceAsStream(s));
//			AudioFormat baseFormat = audioin.getFormat();
//			AudioFormat decodeFormat = new AudioFormat(
//				
//				AudioFormat.Encoding.PCM_SIGNED, 
//				baseFormat.getSampleRate(), 
//				16, 
//				baseFormat.getChannels(), 
//				baseFormat.getChannels() * 2, 
//				baseFormat.getSampleRate(), 
//				false
//				);
//		AudioInputStream dais = AudioSystem.getAudioInputStream(
//				decodeFormat, audioin);
//		clip = AudioSystem.getClip();
//		clip.open(dais);
//
//		} catch (UnsupportedAudioFileException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//		
//	public void play() {
//		if (clip == null) return;
//		stop();
//		clip.setFramePosition(0);
//		clip.start();
//	}
//	
//	public void stop() {
//		if(clip.isRunning()) clip.stop();
//	}
//	
//	public void close() {
//		stop();
//		clip.close();

