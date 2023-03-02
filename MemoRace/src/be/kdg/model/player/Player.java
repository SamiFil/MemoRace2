package be.kdg.model.player;

import be.kdg.model.board.Card;
import be.kdg.model.board.Speelveld;
import be.kdg.view.start.StartPresenter;
import javafx.scene.image.Image;

/**
 * Sami Filjak
 * 23/12/2022
 */
public class Player {
    private String naam;
    private String avatar;
    private Image avatarFoto;
    private int amountOfWonCards;
    private boolean isBeurt;
    private boolean isGewonnen;

    public Player(String naam, String avatar) {
        this.naam = naam;
        this.avatar = avatar;
        avatarFoto = new Image("avatars/" + avatar + ".jpg");
        isBeurt = false;
        isGewonnen = false;
    }

    public void setBeurt(boolean beurt) {
        isBeurt = beurt;
    }

    public void setGewonnen(boolean gewonnen) {
        isGewonnen = gewonnen;
    }

    public Image getAvatarFoto() {
        return avatarFoto;
    }


    }
