package be.kdg.view.game;

import be.kdg.model.board.Dice;
import be.kdg.model.board.Spel;
import be.kdg.model.player.Player;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
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
    private HashMap<ImageView,Integer> kaartMap;
    int rij = 0;
    int kolom = 0;
    private HBox hbox;
    private Button rollButton;
    private ImageView diceImage;
    private Random random;
    public Button getRollButton() {
        return rollButton;
    }

    public ImageView getDiceImage() {
        return diceImage;
    }

    public GameView (Spel model) {
        this.model = model;
    updatePlayers(model.getPlayers());
        this.initialiseNodes();
        this.layoutNodes();

    }
    public void roll(ActionEvent actionEvent) {
        rollButton.setDisable(true);
        Thread thread = new Thread() {
            public void run() {
                try {
                    for (int i = 0; i < 15; i++) {
                        File file = new File("MemoRace/Resources/dice/" + (random.nextInt(6)+1) +".png");
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
        HBox hbox = new HBox(); // maak een HBox om alle VBoxes in te plaatsen
        rollButton = new Button("Roll");
        diceImage = new ImageView();
        random = new Random();
    }
    public void updatePlayers(List<Player> players) {
        VBox vbox = new VBox();
        for (Player player : players) { // itereren over alle spelers
            ImageView avatar = new ImageView("avatars/" + player.getAvatar() + ".jpg"); // maak een ImageView voor de avatar van de speler
            avatar.setFitHeight(50); // stel de hoogte van de ImageView in op 50 pixels
            avatar.setFitWidth(50); // stel de breedte van de ImageView in op 50 pixels
            Label naam = new Label(player.getNaam()); // maak een Label voor de naam van de speler
            vbox.getChildren().addAll(avatar, naam); // voeg de avatar en naam toe aan de VBox
            hbox.getChildren().add(hbox); // voeg de VBox toe aan de HBox
        }
    }
    public void layoutNodes() {
        setMaxWidth(Double.MAX_VALUE);
        for (int a=1;a<=model.getSpeelveld().getKaarten().size();a++) {
            ImageView imagevwAchterkant = new ImageView(model.getSpeelveld().getKaarten().get(a-1).getAchterkantKaart());
            imagevwAchterkant.setFitHeight(200);
            imagevwAchterkant.setFitWidth(200);

            kaartMap.put(imagevwAchterkant,a-1);
            add(imagevwAchterkant,kolom,rij);
            kolom=kolom+1;
            if(a%4 == 0 && a<=model.getSpeelveld().getKaarten().size()){
                rij = rij+1;
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
        rollButton.setPrefSize(50,30);
        GridPane.setConstraints(diceImage,11,2);
        getChildren().add(diceImage);
        GridPane.setConstraints(rollButton, 12, 2);
        getChildren().add(rollButton);
        GridPane.setConstraints(hbox, 6,0);
        getChildren().add(hbox);
    }
    public HashMap<ImageView,Integer> getKaartMap() {
        return kaartMap;
    }
}
