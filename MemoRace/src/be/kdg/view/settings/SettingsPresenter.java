package be.kdg.view.settings;

import be.kdg.view.mainmenu.MainMenuPresenter;
import be.kdg.view.mainmenu.MainMenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class SettingsPresenter {
    private SettingsView settingsView;

    public SettingsPresenter(SettingsView settingsView) {
        this.settingsView = settingsView;
        addEventHandlers();

    }

    private void addEventHandlers() {
        settingsView.getBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MainMenuView mainMenuView = new MainMenuView();
                MainMenuPresenter MainMenuPresenter = new MainMenuPresenter(mainMenuView);
                settingsView.getScene().setRoot(mainMenuView);

            }
        });

    }
}

