package be.kdg.view.game;

import be.kdg.model.board.Spel;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class GamePresenter  {
    private GameView gameView;
    private Spel model;

    public GamePresenter(Spel model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {

    }
    private void updateView() {

    }
}
