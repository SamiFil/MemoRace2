package be.kdg.view.settings;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class SettingsView extends VBox {
    private HBox box1;
    private HBox box2;
    private Button one;
    private Button two;
    private Button timer1;
    private Button timer2;
    private Button back;
    private Label settings;
    private Label players;
    private Label timer;



    public SettingsView() {
        this.initialiseNodes();
        this.layoutNodes();

    }
    private void initialiseNodes() {
        box1 = new HBox();
        box2 = new HBox();
        one = new Button("2");
        two = new Button("3");
        timer1 = new Button("5s");
        timer2 = new Button("10s");
        back = new Button("Back");
        settings = new Label();
        players = new Label();
        timer = new Label();
    }

    public Button getOne() {
        return one;
    }

    public Button getTwo() {
        return two;
    }

    public Button getTimer1() {
        return timer1;
    }

    public Button getTimer2() {
        return timer2;
    }

    public Button getBack() {
        return back;
    }

    private void layoutNodes() {
        one.setPrefSize(30,30);
        two.setPrefSize(30,30);
        timer1.setPrefSize(50,30);
        timer2.setPrefSize(50,30);
        back.setPrefSize(50,30);
        settings.setFont(Font.font("Verdana",31));
        settings.setText("SETTINGS");
        players.setFont(Font.font("Verdana",19));
        players.setText("Players:");
        timer.setFont(Font.font("Verdana",19));
        timer.setText("Timer:");
        box1.getChildren().addAll(players, one, two);
        box2.getChildren().addAll(timer, timer1, timer2);
        getChildren().addAll(settings, box1, box2, back);
        setAlignment(Pos.CENTER);
        box1.setAlignment(Pos.CENTER);
        box2.setAlignment(Pos.CENTER);
        setSpacing(20);
        box1.setSpacing(10);
        box2.setSpacing(10);

    }
}
