package adikshin;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound {
    
    public static synchronized void play(final String url) {
        new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Clip clip = AudioSystem.getClip();
                InputStream bufferedIn = new BufferedInputStream(getClass().getResourceAsStream(url));
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(bufferedIn);
                clip.open(inputStream);
                clip.start(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
     }).start();
   }
    
}
