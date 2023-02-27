package be.kdg.view.mainmenu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Sami Filjak
 * 30/01/2023
 */
public class MainMenuView extends VBox {
    private Button start;
    private Button settings;
    private Button HighScore;
    private Label MemoryGame;
    private Label MadeBy;
    private Label Sami;
    private Label Haron;

    public MainMenuView() {
        this.initialiseNodes();
        this.layoutNodes();

    }

    private void initialiseNodes() {
        start = new Button("Start");
        settings = new Button("Settings");
        MemoryGame = new Label();
        MadeBy = new Label();
        Sami = new Label();
        Haron = new Label();
        HighScore = new Button("Highscore");

    }

    public Button getStart() {
        return start;
    }

    public Button getSettings() {
        return settings;
    }

    public Button getHighScore() {
        return HighScore;
    }

    private void layoutNodes() {
        setSpacing(10);
        start.setPrefSize(160, 40);
        settings.setPrefSize(160, 40);
        MemoryGame.setFont(Font.font("Verdana", 31));
        MemoryGame.setText("MEMORACE");
        MadeBy.setFont(Font.font("Verdana", 15));
        MadeBy.setText("Made by:");
        Sami.setFont(Font.font("Verdana", 15));
        Sami.setText("Sami Filjak");
        Haron.setFont(Font.font("Verdana", 15));
        Haron.setText("Haron Badaoui");
        HighScore.setPrefSize(160,40);
        setAlignment(Pos.CENTER);
        getChildren().addAll(MemoryGame, MadeBy, Sami, Haron, start, HighScore, settings);
    }
}
