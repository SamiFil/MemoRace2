package be.kdg.view.game;

import be.kdg.model.board.Spel;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class GameView extends BorderPane {
    private ImageView cards;
    private GridPane grid;
    private Spel model;
    private HBox hBox;
    private VBox vBox;
    private Image achtergrond;

public GameView (Spel model) {
this.model = model;
    this.initialiseNodes();
    this.layoutNodes();
}

    public void initialiseNodes() {
        grid = new GridPane();
        vBox = new VBox();
        hBox = new HBox();
        this.achtergrond = new Image("/Background.jpg");
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

    }

    private void layoutNodes() {
    }
}

