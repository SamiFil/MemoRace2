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
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Sami Filjak
 * 16/02/2023
 */
public class StartPresenter {
    private StartView startView;
    private int counter = 0;
    private Speelveld speelVeld;
    ComboBox<String> avatarComboBox;
    List<String> avatarNames = Arrays.asList("Michael Jordan", "Kobe Bryant", "Stephen Curry", "Lebron James");

    public StartPresenter(StartView startView) throws IOException {
        this.startView = startView;

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
                    String selectedAvatar = avatarComboBox.getSelectionModel().getSelectedItem();
                    Player player = new Player(playerName, selectedAvatar);
                    startView.playerNames.add(player);
                });
                hBox.getChildren().addAll(textField, avatarComboBox);
                startView.getChildren().add(hBox);
            }

        });
        startView.getStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
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
        });
    }
}
