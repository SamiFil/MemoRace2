package be.kdg.model.board;

import javafx.scene.media.AudioClip;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Sami Filjak
 * 16/02/2023
 */
public class GameTimer {
    private Timer gameTimer;
    private TimerTask task;
    private int secondsPassed;
    private Text timerTekst = new Text();
    private AudioClip secondeGeluid = new AudioClip(this.getClass().getResource("/ticking.wav").toString());

    public GameTimer(){
        timerTekst.setWrappingWidth(300);
        timerTekst.setFont(Font.font("Verdana",25));
        timerTekst.setText("Timer: "+secondsPassed+" Seconden");
        timerTekst.setFill(Paint.valueOf("WHITE"));
        secondsPassed=0;
        gameTimer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                secondsPassed++;
                timerTekst.setText("Timer: "+secondsPassed+" Seconden");
                secondeGeluid.play();
            }
        };
    }
    public void start(){
        gameTimer.scheduleAtFixedRate(task,1000,1000);
    }

    public Text getTimerTekst() {
        return timerTekst;
    }

    public Timer getGameTimer() {
        return gameTimer;
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }
}

