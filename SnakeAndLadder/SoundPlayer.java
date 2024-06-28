import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class SoundPlayer {

    private Clip loadClip(String audioFilePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(audioFilePath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);
        Clip audioClip = AudioSystem.getClip();
        audioClip.open(audioStream);
        return audioClip;
    }

    public void playSound(String audioFilePath) {
        try {
            Clip clip = loadClip(audioFilePath);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
