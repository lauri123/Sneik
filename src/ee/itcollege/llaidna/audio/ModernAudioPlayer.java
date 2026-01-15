package ee.itcollege.llaidna.audio;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Modern audio player to replace TinySound
 * Uses Java Sound API for better compatibility
 */
public class ModernAudioPlayer {
    
    private static Clip backgroundMusic;
    private static float globalVolume = 1.0f;
    
    /**
     * Initialize the audio system
     */
    public static void init() {
        // Audio system is ready to use
    }
    
    /**
     * Play background music
     * @param loop whether to loop the music
     * @param volume volume level (0.0 to 1.0)
     */
    public static void playMusic(boolean loop, double volume) {
        try {
            // Try to load a music file from the music directory
            URL musicFile = ModernAudioPlayer.class.getResource("/music/background.wav");
            if (musicFile == null) {
                // Create a simple tone if no music file is found
                return; // Silently skip music for now
            }
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioStream);
            
            // Set volume
            setVolume(backgroundMusic, volume);
            
            if (loop) {
                backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                backgroundMusic.start();
            }
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Could not load music: " + e.getMessage());
        }
    }
    
    /**
     * Play a sound effect
     * @param soundFile path to sound file
     */
    public static void playSound(String soundFile) {
        try {
            URL file = ModernAudioPlayer.class.getResource(soundFile);
            if (file == null) return;
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Could not play sound: " + e.getMessage());
        }
    }
    
    /**
     * Set global volume
     * @param volume volume level (0.0 to 1.0)
     */
    public static void setGlobalVolume(double volume) {
        globalVolume = (float) Math.max(0.0, Math.min(1.0, volume));
        if (backgroundMusic != null && backgroundMusic.isOpen()) {
            setVolume(backgroundMusic, globalVolume);
        }
    }
    
    /**
     * Stop all audio
     */
    public static void stop() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
            backgroundMusic.close();
        }
    }
    
    private static void setVolume(Clip clip, double volume) {
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
        }
    }
}