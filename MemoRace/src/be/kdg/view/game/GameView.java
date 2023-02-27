package be.kdg.view.game;

import be.kdg.model.board.Spel;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.HashMap;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class GameView extends BorderPane {
    private GridPane grid;
    private Spel model;
    private HBox hBox;
    private VBox vBox;
    private Image achtergrond;
    private HashMap<ImageView,Integer> kaartMap;
    int rij = 0;
    int kolom = 0;

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
        kaartMap = new HashMap<>();
    }

    private void layoutNodes() {
        grid.setHgap(40.0);
        grid.setVgap(20.0);
        grid.setPadding(new Insets(50));
        grid.setMaxWidth(Double.MAX_VALUE);
        for (int a=1;a<=model.getSpeelveld().getKaarten().size();a++) {
            ImageView imagevwAchterkant = new ImageView(model.getSpeelveld().getKaarten().get(a-1).getAchterkantKaart());
            imagevwAchterkant.setFitHeight(220);
            imagevwAchterkant.setFitWidth(160);
            kaartMap.put(imagevwAchterkant,a-1);
            grid.add(imagevwAchterkant,kolom,rij);
            kolom=kolom+1;
            if(a%4 == 0 && a<=model.getSpeelveld().getKaarten().size()){
                rij = rij+1;
                kolom = 0;
            }
        }
        getChildren().add(grid);
    }
    public HashMap<ImageView,Integer> getKaartMap() {
        return kaartMap;
    }

    public GridPane getGrid() {
        return grid;
    }
}

