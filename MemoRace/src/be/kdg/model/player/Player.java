package be.kdg.model.player;

import be.kdg.model.board.Card;
import be.kdg.model.board.Speelveld;
import be.kdg.view.start.StartPresenter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.util.Objects;

/**
 * Sami Filjak
 * 23/12/2022
 */
public class Player {
    private String naam;
    private ImageView avatar;
    private int score;
    private boolean isBeurt;
    private boolean isGewonnen;

    public Player(String naam, ImageView avatar) {
        this.naam = naam;
        this.avatar = avatar;
        this.score = 0;
        isBeurt = false;
        isGewonnen = false;
    }

    public ImageView getAvatar() {
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

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
