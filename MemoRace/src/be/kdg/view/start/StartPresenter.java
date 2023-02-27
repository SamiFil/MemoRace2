package be.kdg.view.start;

import be.kdg.model.board.Spel;
import be.kdg.view.game.GamePresenter;
import be.kdg.view.game.GameView;
import be.kdg.view.settings.SettingsPresenter;
import be.kdg.view.settings.SettingsView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Sami Filjak
 * 16/02/2023
 */
public class StartPresenter {
    private StartView startView;
    private int counter = 0;

    public StartPresenter(StartView startView) {
        this.startView = startView;
        addEventHandlers();
    }

    private void addEventHandlers() {
        startView.getAddPlayers().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TextField textField = new TextField();
                textField.setMaxWidth(150);
                textField.setPromptText("Player " + (++counter));
                textField.setOnAction(event -> {
                    String playerName = textField.getText();
                    startView.playerNames.add(playerName);
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
