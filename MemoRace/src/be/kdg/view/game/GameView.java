package be.kdg.view.game;

import be.kdg.model.board.Spel;
import be.kdg.model.player.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private BorderPane borderPane;
    private GridPane grid;
    private Spel model;
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
        this.achtergrond = new Image("/Background.jpg");
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        kaartMap = new HashMap<>();
        borderPane = new BorderPane();

    }

    public void layoutNodes() {
        grid.setMaxWidth(Double.MAX_VALUE);
        for (int a=1;a<=model.getSpeelveld().getKaarten().size();a++) {
            ImageView imagevwAchterkant = new ImageView(model.getSpeelveld().getKaarten().get(a-1).getAchterkantKaart());
            imagevwAchterkant.setFitHeight(200);
            imagevwAchterkant.setFitWidth(200);

            kaartMap.put(imagevwAchterkant,a-1);
            grid.add(imagevwAchterkant,kolom,rij);
            kolom=kolom+1;
            if(a%4 == 0 && a<=model.getSpeelveld().getKaarten().size()){
                rij = rij+1;
                kolom = 0;
            }
        }
        HBox hbox = new HBox(); // maak een HBox om alle VBoxes in te plaatsen
        for (Player player : model.getPlayers()) { // itereren over alle spelers
            ImageView avatar = new ImageView(player.getAvatar()); // maak een ImageView voor de avatar van de speler
            avatar.setFitHeight(50); // stel de hoogte van de ImageView in op 50 pixels
            avatar.setFitWidth(50); // stel de breedte van de ImageView in op 50 pixels
            Label naam = new Label(player.getNaam()); // maak een Label voor de naam van de speler
            VBox vbox = new VBox(); // maak een VBox voor de avatar en de naam van de speler
            vbox.getChildren().addAll(avatar, naam); // voeg de avatar en naam toe aan de VBox
            hbox.getChildren().add(vbox); // voeg de VBox toe aan de HBox
        }

// zet de HBox rechts van de BorderPane
        BorderPane.setMargin(hbox, new Insets(10, 10, 10, 10)); // stel de marge van de HBox in op 10 pixels aan alle kanten
        BorderPane.setAlignment(hbox, Pos.CENTER_RIGHT); // stel de uitlijning van de HBox in op het midden van de rechterkant van de BorderPane
        borderPane.setRight(hbox); // voeg de HBox toe aan de rechterkant van de BorderPane

        borderPane.getChildren().addAll(grid, hbox);
        grid.setPrefSize(600,400);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        getChildren().add(borderPane);
    }
    public HashMap<ImageView,Integer> getKaartMap() {
        return kaartMap;
    }

    public GridPane getGrid() {
        return grid;
    }
}

