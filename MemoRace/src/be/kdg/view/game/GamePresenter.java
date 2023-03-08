package be.kdg.view.game;

import be.kdg.model.board.Spel;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class GamePresenter {
    private GameView gameView;
    private Spel model;
    private Boolean disableKeys = false;

    public GamePresenter(Spel model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        this.addEventHandlers();
    }

    public void addEventHandlers() {
        gameView.getRollButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
              gameView.roll(actionEvent);
            }
        });
        gameView.getGrid().getChildren().forEach(item -> {
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ImageView currentImage = (ImageView) mouseEvent.getSource();
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                        model.setMouseclicks();
                        model.getSpeelveld().getKaarten().get(gameView.getKaartMap().get(currentImage)).setIsOmgedraaid(true);
                        currentImage.setImage(model.getSpeelveld().getKaarten().get(gameView.getKaartMap().get(currentImage)).getVoorkantKaart());
                        new Thread(() -> {
                            if (model.getKeuze1() == 0) {
                                model.setKeuze1(gameView.getKaartMap().get(currentImage) + 1);
                            } else {
                                model.setKeuze2(gameView.getKaartMap().get(currentImage) + 1);
                                if (!model.paarGevonden()) {
                                    gameView.getGrid().setDisable(true);
                                    disableKeys = true;
                                    long startTime = System.currentTimeMillis();
                                    long elapsedTime;
                                    do {
                                        elapsedTime = System.currentTimeMillis() - startTime;
                                    } while (elapsedTime < 1000);
                                    ImageView eersteKeuzeImage = (ImageView) gameView.getGrid().getChildren().get(model.getKeuze1() - 1);
                                    eersteKeuzeImage.setImage(model.getSpeelveld().getKaarten().get(model.getKeuze1() - 1).getAchterkantKaart());
                                    model.getSpeelveld().getKaarten().get(model.getKeuze1() - 1).setIsOmgedraaid(false);
                                    eersteKeuzeImage.setMouseTransparent(false);
                                    currentImage.setImage(model.getSpeelveld().getKaarten().get(gameView.getKaartMap().get(currentImage)).getAchterkantKaart());
                                    model.getSpeelveld().getKaarten().get(gameView.getKaartMap().get(currentImage)).setIsOmgedraaid(false);
                                    currentImage.setMouseTransparent(false);
                                    gameView.getGrid().setDisable(false);
                                    disableKeys = false;
                                } else {
                                    gameView.getGrid().setDisable(true);
                                    disableKeys = true;
                                    gameView.getGrid().setDisable(false);
                                    disableKeys = false;
                                }
                                model.setKeuze2(0);
                                model.setKeuze1(0);
                            }
                        }).start();
                    }
                }
            });
        });
    }}
