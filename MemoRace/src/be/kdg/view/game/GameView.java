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
import java.util.List;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class GameView extends BorderPane {
    private GridPane grid;
    private Spel model;
    private Image achtergrond;
    private HashMap<ImageView,Integer> kaartMap;
    int rij = 0;
    int kolom = 0;
    private HBox hbox;

    public GameView (Spel model) {
        this.model = model;
        updatePlayers(model.getPlayers());
        this.initialiseNodes();
        this.layoutNodes();

    }

    public void initialiseNodes() {
        grid = new GridPane();
        this.achtergrond = new Image("/Background.jpg");
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        kaartMap = new HashMap<>();
        HBox hbox = new HBox(); // maak een HBox om alle VBoxes in te plaatsen

    }
    public void updatePlayers(List<Player> players) {
        hbox.getChildren().clear(); // verwijder alle bestaande nodes uit de hbox
        for (Player player : players) { // itereren over alle spelers
            ImageView avatar = new ImageView("avatars/" + player.getAvatar() + ".jpg"); // maak een ImageView voor de avatar van de speler
            avatar.setFitHeight(50); // stel de hoogte van de ImageView in op 50 pixels
            avatar.setFitWidth(50); // stel de breedte van de ImageView in op 50 pixels
            Label naam = new Label(player.getNaam()); // maak een Label voor de naam van de speler
            HBox playerBox = new HBox();
            playerBox.getChildren().addAll(avatar, naam); // voeg de avatar en naam toe aan de VBox
            hbox.getChildren().add(playerBox); // voeg de VBox toe aan de HBox
        }
    }
    public void layoutNodes() {
//        grid.setMaxWidth(Double.MAX_VALUE);
//        for (int a=1;a<=model.getSpeelveld().getKaarten().size();a++) {
//            ImageView imagevwAchterkant = new ImageView(model.getSpeelveld().getKaarten().get(a-1).getAchterkantKaart());
//            imagevwAchterkant.setFitHeight(200);
//            imagevwAchterkant.setFitWidth(200);
//
//            kaartMap.put(imagevwAchterkant,a-1);
//            grid.add(imagevwAchterkant,kolom,rij);
//            kolom=kolom+1;
//            if(a%4 == 0 && a<=model.getSpeelveld().getKaarten().size()){
//                rij = rij+1;
//                kolom = 0;
//            }
//        }



//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.setPadding(new Insets(20));
//        borderPane.getChildren().add(grid);
//        BorderPane.setMargin(grid, new Insets(10, 10, 10, 10));
//        setCenter(grid);
        getChildren().add(hbox);
        hbox.setAlignment(Pos.CENTER_RIGHT);
    }
    public HashMap<ImageView,Integer> getKaartMap() {
        return kaartMap;
    }

    public GridPane getGrid() {
        return grid;
    }
}
