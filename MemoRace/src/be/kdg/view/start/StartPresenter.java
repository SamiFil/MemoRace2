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

/**
 * Sami Filjak
 * 16/02/2023
 */
public class StartPresenter {
    private StartView startView;
    private int counter = 0;
    private Speelveld speelVeld;

    public StartPresenter(StartView startView) throws IOException {

        this.startView = startView;
        addEventHandlers();
    }

    private void addEventHandlers() {
        assert false;
        ComboBox<Card> comboBox = new ComboBox<>(FXCollections.observableList(speelVeld.getKaarten()));
        comboBox.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends Card> observable, Card oldValue, Card newValue) -> {
                });
        startView.getAddPlayers().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HBox hBox = new HBox();
                TextField textField = new TextField();

                textField.setMaxWidth(150);
                textField.setPromptText("Player " + (++counter));
                textField.setOnAction(event -> {
                    String playerName = textField.getText();
                    Card selectedAvatar = comboBox.getSelectionModel().getSelectedItem();
                    Player player = new Player(playerName, selectedAvatar);
                    startView.playerNames.add(player);
                });
                startView.getChildren().add(textField);
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
