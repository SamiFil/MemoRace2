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
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Sami Filjak
 * 16/02/2023
 */
public class StartPresenter {
    private StartView startView = new StartView();
    private TextField textField;
    private Player player;
    private ArrayList<Player> players;
    Spel model;
    private int counter = 0;
    private Speelveld speelVeld;
    ComboBox<String> avatarComboBox;
    List<String> avatarNames = Arrays.asList("Michael", "Kobe", "Stephen", "Lebron");
    private final int   MAX_PLAYERS = 4;
    private ComboBox<Integer> numberOfPlayersComboBox;

    public StartPresenter(StartView startView) {
        this.startView = startView;
        addEventHandlers();

    }



    public ArrayList<Player> getPlayers() {
        return players;
    }

    private void addEventHandlers() {
        players = new ArrayList<Player>();
        startView.getAddPlayers().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Aantal spelers");
                dialog.setHeaderText("Hoeveel spelers zullen meespelen?");
                dialog.setContentText("Gelieve een getal in te voeren tussen 1 en 4.");

                Optional<String> resultaat;
                boolean validInput = false;
                int aantalPlayers = 0;
                while (!validInput) {
                    resultaat = dialog.showAndWait();
                    if (resultaat.isPresent()) {
                        try {
                            aantalPlayers = Integer.parseInt(resultaat.get());
                            if (aantalPlayers >= 1 && aantalPlayers <= 4) {
                                validInput = true;
                            } else {
                                throw new NumberFormatException();
                            }
                        } catch (NumberFormatException e) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Ongeldig invoer");
                            alert.setHeaderText("Gelieve een aantal te kiezen tussen 1 en 4 spelers.");
                            alert.showAndWait();
                        }
                    } else {
                        return;
                    }
                }

                for (int i = 0; i < aantalPlayers; i++) {
                    HBox hBox = new HBox();
                    TextField textField = new TextField();
                    ComboBox<String> avatarComboBox = new ComboBox<>(FXCollections.observableList(avatarNames));
                    textField.setMaxWidth(150);
                    textField.setPromptText("Player " + (i + 1));
                    hBox.getChildren().addAll(textField, avatarComboBox);
                    startView.getChildren().add(hBox);
                    avatarComboBox.getSelectionModel().selectedItemProperty().addListener(
                            (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                            });
                    textField.setOnAction(event -> {
                        String playerName = textField.getText();
                        ImageView selectedAvatar = new ImageView("avatars/" + avatarComboBox.getValue().toString() + ".jpg");
                        players.add(new Player(playerName, selectedAvatar));
                        textField.setEditable(false);
                    });

                }
            }
        });

        startView.getStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean emptyFields = false;
                for (Player player : players) {
                    if (player.getNaam().isEmpty()) {
                        emptyFields = true;
                        break;
                    }
                }
                if (emptyFields) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Missing information");
                    alert.setHeaderText(null);
                    alert.setContentText("Gelieve alle speler-info in te vullen.");
                    alert.showAndWait();
                } else {
                    if (players.size() < 2) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Missing information");
                        alert.setHeaderText(null);
                        alert.setContentText("Speler aantal moet minstens 2 zijn!");
                        alert.showAndWait();
                        return;
                    }
                    else {
                        Spel model = new Spel();
                        GameView gameView = new GameView(model);
                        GamePresenter gamePresenter = new GamePresenter(model, gameView);
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
            }
        });

    }
}
