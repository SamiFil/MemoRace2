package be.kdg.view.game;

import be.kdg.model.board.Dice;
import be.kdg.model.board.Spel;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
    private Image achtergrond;
    private Dice dice;
    private HashMap<ImageView,Integer> kaartMap;
    int rij = 0;
    int kolom = 0;
    private HBox hbox;
    private Button rollButton;
    private ImageView diceImage;
    private HBox hbox2;

    public Button getRollButton() {
        return rollButton;
    }

    public ImageView getDiceImage() {
        return diceImage;
    }

    public GameView (Spel model) {
        this.model = model;
//        updatePlayers(model.getPlayers());
        this.initialiseNodes();
        this.layoutNodes();

    }

    public void initialiseNodes() {
        grid = new GridPane();
        this.achtergrond = new Image("/Background.jpg");
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        kaartMap = new HashMap<>();
        HBox hbox = new HBox(); // maak een HBox om alle VBoxes in te plaatsen
        rollButton = new Button("Roll");
        hbox2 = new HBox();
        dice = new Dice();
    }
//    public void updatePlayers(List<Player> players) {
//        hbox.getChildren().clear(); // verwijder alle bestaande nodes uit de hbox
//        VBox vbox = new VBox();
//        for (Player player : players) { // itereren over alle spelers
//            ImageView avatar = new ImageView("avatars/" + player.getAvatar() + ".jpg"); // maak een ImageView voor de avatar van de speler
//            avatar.setFitHeight(50); // stel de hoogte van de ImageView in op 50 pixels
//            avatar.setFitWidth(50); // stel de breedte van de ImageView in op 50 pixels
//            Label naam = new Label(player.getNaam()); // maak een Label voor de naam van de speler
//            vbox.getChildren().addAll(avatar, naam); // voeg de avatar en naam toe aan de VBox
//            hbox.getChildren().add(hbox); // voeg de VBox toe aan de HBox
//        }
//    }
    public void layoutNodes() {
        dice.setFitHeight(200);
        dice.setFitWidth(200);
        dice.setLayoutY(100);
        dice.setLayoutX(100);
        dice.isPickOnBounds();
        dice.isPreserveRatio();
        rollButton.setMnemonicParsing(false);
        rollButton.setPrefSize(100,30);
        hbox2.getChildren().addAll(dice, rollButton);
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



        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        getChildren().add(grid);
        setMargin(grid, new Insets(10, 10, 10, 10));
//        getChildren().add(hbox);
//        hbox.setAlignment(Pos.CENTER_RIGHT);
    }
    public HashMap<ImageView,Integer> getKaartMap() {
        return kaartMap;
    }

    public GridPane getGrid() {
        return grid;
    }
}
