package be.kdg.view.game;

import be.kdg.model.board.Dice;
import be.kdg.model.board.Spel;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

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
    private Button rollButton;
    private ImageView diceImage;
    private HBox hbox2;private Random random;
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
    public void roll(ActionEvent actionEvent) {
        rollButton.setDisable(true);
        Thread thread = new Thread() {
            public void run() {
                try {
                    for (int i = 0; i < 15; i++) {
                        File file = new File("dice/" + (random.nextInt(6)+1)+".png");
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
        grid = new GridPane();
        this.achtergrond = new Image("/Background.jpg", true);
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        kaartMap = new HashMap<>();
        HBox hbox = new HBox(); // maak een HBox om alle VBoxes in te plaatsen
        rollButton = new Button("Roll");
        hbox2 = new HBox();
        diceImage = new ImageView();
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
        setMargin(grid, new Insets(10, 10, 10, 10));
        diceImage.setFitHeight(200);
        diceImage.setFitWidth(200);
        diceImage.setLayoutY(100);
        diceImage.setLayoutX(100);
        diceImage.isPickOnBounds();
        diceImage.isPreserveRatio();
        rollButton.setMnemonicParsing(false);
        rollButton.setPrefSize(100,30);
        hbox2.getChildren().addAll(diceImage, rollButton);
        getChildren().add(hbox2);
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
