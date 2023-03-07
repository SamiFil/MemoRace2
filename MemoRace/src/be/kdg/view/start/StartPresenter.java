package be.kdg.view.start;

import be.kdg.model.board.Card;
import be.kdg.model.board.Speelveld;
import be.kdg.model.board.Spel;
import be.kdg.model.player.Player;
import be.kdg.view.game.GamePresenter;
import be.kdg.view.game.GameView;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sami Filjak
 * 16/02/2023
 */
public class StartPresenter {
    private StartView startView = new StartView();
    private Player player;
    Spel spel;
    private int counter = 0;
    private Speelveld speelVeld;
    ComboBox<String> avatarComboBox;
    List<String> avatarNames = Arrays.asList("Michael", "Kobe", "Stephen", "Lebron");

    public StartPresenter(StartView startView) throws IOException {
        this.startView = startView;
        assert false;
        this.spel = new Spel();


        addEventHandlers();
    }

    private void addEventHandlers() {


        startView.getAddPlayers().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HBox hBox = new HBox();
                TextField textField = new TextField();
                avatarComboBox = new ComboBox<>(FXCollections.observableList(avatarNames));
                avatarComboBox.getSelectionModel().selectedItemProperty().addListener(
                        (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                            // Handle the selection change
                        });
                textField.setMaxWidth(150);
                textField.setPromptText("Player " + (++counter));
                textField.setOnAction(event -> {
                    String playerName = textField.getText();
                    String selectedAvatar = avatarComboBox.getValue().toString();
                    if (!playerName.isEmpty()) {
                        spel.addPlayer(playerName, selectedAvatar);
                        textField.setEditable(false);
                    } else {
                        // Show an error message to the user, informing them to enter a name
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setContentText("Gelieve een naam in te voeren voor speler " + counter);
                        alert.showAndWait();
                    }
                });
                hBox.getChildren().addAll(textField, avatarComboBox);
                startView.getChildren().add(hBox);
            }
        });

        startView.getStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean emptyFields = false;
                for (Node node : startView.getChildren()) {
                    if (node instanceof HBox) {
                        HBox hBox = (HBox) node;
                        TextField textField = (TextField) hBox.getChildren().get(0);
                        if (textField.getText().isEmpty()) {
                            emptyFields = true;
                            break;
                        }
                    }
                }
                if (emptyFields) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Missing information");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill in all player names");
                    alert.showAndWait();
                } else {
                    Spel model = new Spel();
                    GameView gameView = new GameView(model);
                    GamePresenter gamePresenter = new GamePresenter(model, gameView);
//                startView.getScene().setRoot(gameView);
                    Stage gameStage = new Stage();
                    Scene gameScene = new Scene(gameView, 1920, 1080);
                    gameStage.setScene(gameScene);
                    gameStage.setFullScreen(true);
                    gameView.getScene().getWindow().sizeToScene();
                    gameView.getScene().getWindow().centerOnScreen();
                    gameScene.setRoot(gameView);
                    gameStage.show();
                }
            }
        });
    }
}
