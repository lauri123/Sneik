package ee.itcollege.llaidna.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Audio {

//	private Clip clip;
	
	public Audio(String s) {
		
		String bip = "s";
		Media hit = new Media(bip);
		MediaPlayer mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
		
	}
}
		
		
		
		
		
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

