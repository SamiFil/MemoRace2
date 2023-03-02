package be.kdg.model.player;

import be.kdg.model.board.Card;
import be.kdg.model.board.Speelveld;
import be.kdg.view.start.StartPresenter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * Sami Filjak
 * 23/12/2022
 */
public class Player {
    private String naam;
    private String avatar;
    private int amountOfWonCards;
    private boolean isBeurt;
    private boolean isGewonnen;

    public Player(String naam, String avatar) {
        this.naam = naam;
        this.avatar = avatar;
        isBeurt = false;
        isGewonnen = false;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNaam() {
        return naam;
    }

    public void setBeurt(boolean beurt) {
        isBeurt = beurt;
    }

    public void setGewonnen(boolean gewonnen) {
        isGewonnen = gewonnen;
    }



    }
