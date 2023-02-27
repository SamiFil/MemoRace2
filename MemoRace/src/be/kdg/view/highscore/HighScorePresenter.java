package be.kdg.view.highscore;
import be.kdg.view.mainmenu.MainMenuPresenter;
import be.kdg.view.mainmenu.MainMenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Sami Filjak
 * 15/02/2023
 */
public class HighScorePresenter {
    private HighScoreView highScoreView;

    public HighScorePresenter(HighScoreView highScoreView) {
        this.highScoreView = highScoreView;
        addEventHandlers();
    }
    private void addEventHandlers() {
        highScoreView.getBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MainMenuView mainMenuView = new MainMenuView();
                MainMenuPresenter MainMenuPresenter = new MainMenuPresenter(mainMenuView);
                highScoreView.getScene().setRoot(mainMenuView);

            }
        });

    }
}