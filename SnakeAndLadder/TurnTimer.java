import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class TurnTimer {
    private Timer timer;
    private boolean timeUp;
    private SoundPlayer soundPlayer;
    public TurnTimer(SoundPlayer soundPlayer) {
        this.timer = new Timer();
        this.timeUp = false;
        this.soundPlayer = soundPlayer;
    }

    public void startTimer(int seconds) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                soundPlayer.playSound("timesUp.wav"); // Mainkan suara ketika waktu habis
                System.out.println("Time is up!");
            }
        }, seconds * 1000);
    }

    public void stopTimer() {
        timer.cancel();
    }

    public boolean isTimeUp() {
        return timeUp;
    }

    public void reset() {
        timer = new Timer();
        timeUp = false;
    }
}
