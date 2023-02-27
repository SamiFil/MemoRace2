package be.kdg.view.highscore;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Sami Filjak
 * 15/02/2023
 */
public class HighScoreView extends VBox {
    private VBox box1;
    private VBox box2;
    private Button back;
    private Label highScore;
    private Label name;
    private Label matchedCards;
    private HBox box3;

    public HighScoreView() {
        this.initialiseNodes();
        this.layoutNodes();

    }

    private void initialiseNodes() {
        box1 = new VBox();
        box2 = new VBox();
        box3 = new HBox();
        back = new Button("Back");
        name = new Label("Name");
        matchedCards = new Label("Matched Cards");
        highScore = new Label("HIGHSCORE");
    }

    public VBox getBox1() {
        return box1;
    }

    public VBox getBox2() {
        return box2;
    }

    public Label getHighScore() {
        return highScore;
    }

    public HBox getBox3() {
        return box3;
    }

    public Button getBack() {
        return back;
    }

    public Label getName() {
        return name;
    }

    public Label getMatchedCards() {
        return matchedCards;
    }

    private void layoutNodes() {
        back.setPrefSize(50, 30);
        highScore.setFont(Font.font("Verdana", 31));
        name.setFont(Font.font("Verdana", 19));
        matchedCards.setFont(Font.font("Verdana", 19));
        box1.getChildren().addAll(name);
        box2.getChildren().addAll(matchedCards);
        box3.getChildren().addAll(box1, box2);
        getChildren().addAll(highScore, box3 , back);
        setAlignment(Pos.TOP_CENTER);
        box1.setAlignment(Pos.CENTER_LEFT);
        box2.setAlignment(Pos.CENTER_RIGHT);
        box3.setSpacing(185);
        setLayoutY(40);
        setSpacing(20);
                box1.setSpacing(10);
                box2.setSpacing(10);
    }
}
