package be.kdg.view.start;

import be.kdg.model.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

/**
 * Sami Filjak
 * 16/02/2023
 */
public class StartView extends VBox {
    private Button addPlayers;
    private Label naam;
    private Button start;
    private HBox hBox;
    public List<Player> playerNames;

    public StartView() {
        this.initialiseNodes();
        this.layoutNodes();

    }

    public List<Player> getPlayerNames() {
        return playerNames;
    }

    private void initialiseNodes() {
        addPlayers = new Button("Add Players");
        naam = new Label("Voer namen in: ");
        start = new Button("Start");
        hBox = new HBox();
        playerNames = new ArrayList<Player>();

    }
    private void layoutNodes() {
        addPlayers.setPrefSize(100, 30);
        start.setPrefSize(100,30);
        naam.setFont(Font.font("Verdana", 31));
        hBox.getChildren().addAll(addPlayers, start);
        getChildren().addAll(naam, hBox);
        setSpacing(40);
        setAlignment(Pos.CENTER);
    }

    public Button getAddPlayers() {
        return addPlayers;
    }

    public Label getNaam() {
        return naam;
    }

    public Button getStart() {
        return start;
    }
}
