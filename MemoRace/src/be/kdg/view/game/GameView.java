package be.kdg.view.game;

import be.kdg.model.board.Dice;
import be.kdg.model.board.Spel;
import be.kdg.model.player.Player;
import be.kdg.view.start.StartPresenter;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class GameView extends GridPane {
    private Spel model;
    private Image achtergrond;
    private HashMap<ImageView, Integer> kaartMap;
    int rij = 0;
    int kolom = 0;
    private HBox hbox;
    private Button rollButton;
    private ImageView diceImage;
    private Random random;
    private VBox scoreboardPanel;
    private Label[] nameLabel;
    private Label[] scoreLabel;
    private ImageView[] avatarLabel;
    private StartPresenter startPresenter;
    private int numPlayers;


    public Button getRollButton() {
        return rollButton;
    }

    public ImageView getDiceImage() {
        return diceImage;
    }

    public GameView(int numPlayers) {
        this.initialiseNodes();
        this.layoutNodes();
        updateScoreboard(startPresenter.getPlayers());
        this.numPlayers = numPlayers;

    }

    public void updateScoreboard(ArrayList<Player> players) {
        // update scoreboard with player info
        for (int i = 0; i < players.size(); i++) {
            nameLabel[i].setText(players.get(i).getNaam());
            scoreLabel[i].setText(Integer.toString(players.get(i).getScore()));
            Image avatarImage = players.get(i).getAvatar().getImage();
            ImageView avatarView = new ImageView(avatarImage);
            avatarView.setFitHeight(30);
            avatarView.setFitWidth(30);
            avatarLabel[i].setImage(avatarImage);
        }

    }

    public void roll(ActionEvent actionEvent) {
        rollButton.setDisable(true);
        Thread thread = new Thread() {
            public void run() {
                try {
                    for (int i = 0; i < 15; i++) {
                        File file = new File("MemoRace/Resources/dice/" + (random.nextInt(6) + 1) + ".png");
                        diceImage.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(50);
                    }
                    rollButton.setDisable(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }

    public void initialiseNodes() {
        this.achtergrond = new Image("/Background.jpg", true);
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        kaartMap = new HashMap<>();
        HBox hbox = new HBox();
        rollButton = new Button("Roll");
        diceImage = new ImageView();
        random = new Random();
        JFXPanel jfxPanel = new JFXPanel();
        scoreboardPanel = new VBox();
        nameLabel = new Label[numPlayers];
        scoreLabel = new Label[numPlayers];
        avatarLabel = new ImageView[numPlayers];
        model = new Spel();
        for (int i = 0; i < numPlayers; i++) {
            nameLabel[i] = new Label("");
            scoreLabel[i] = new Label("");
            avatarLabel[i] = new ImageView();

            scoreboardPanel.getChildren().addAll(nameLabel[i], scoreLabel[i], avatarLabel[i]);
        }
    }

    public void layoutNodes() {
        setMaxWidth(Double.MAX_VALUE);
        for (int a = 1; a <= model.getSpeelveld().getKaarten().size(); a++) {
            ImageView imagevwAchterkant = new ImageView(model.getSpeelveld().getKaarten().get(a - 1).getAchterkantKaart());
            imagevwAchterkant.setFitHeight(200);
            imagevwAchterkant.setFitWidth(200);

            kaartMap.put(imagevwAchterkant, a - 1);
            add(imagevwAchterkant, kolom, rij);
            kolom = kolom + 1;
            if (a % 4 == 0 && a <= model.getSpeelveld().getKaarten().size()) {
                rij = rij + 1;
                kolom = 0;
            }
        }
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(20));
        diceImage.setFitHeight(200);
        diceImage.setFitWidth(200);
        diceImage.setLayoutY(100);
        diceImage.setLayoutX(100);
        diceImage.isPickOnBounds();
        diceImage.isPreserveRatio();
        rollButton.setMnemonicParsing(false);
        rollButton.setPrefSize(50, 30);
        GridPane.setConstraints(diceImage, 11, 2);
        getChildren().add(diceImage);
        GridPane.setConstraints(rollButton, 12, 2);
        getChildren().add(rollButton);
        GridPane.setConstraints(hbox, 6, 0);
        getChildren().add(hbox);
        getChildren().add(scoreboardPanel);
    }

    public HBox getHbox() {
        return hbox;
    }

    public HashMap<ImageView, Integer> getKaartMap() {
        return kaartMap;
    }
}
