package be.kdg.model.board;

import be.kdg.view.game.GameView;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;

/**
 * Sami Filjak
 * 8/03/2023
 */
public class Dice extends ImageView {
    Random random = new Random();
    Spel model;
    GameView gameview = new GameView(model);

public void roll(ActionEvent actionEvent) {
gameview.getRollButton().setDisable(true);
Thread thread = new Thread() {
    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                File file = new File("dice/" + (random.nextInt(6)+1)+".png");
                gameview.getDiceImage().setImage(new Image(file.toURI().toString()));
                Thread.sleep(50);
            }
            gameview.getRollButton().setDisable(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};

    thread.start();
}

}
