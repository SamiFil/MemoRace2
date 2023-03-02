package be.kdg.model.player;

import be.kdg.model.board.Card;

/**
 * Sami Filjak
 * 23/12/2022
 */
public class Player {
    private String naam;
    private Card avatar;
    private int amountOfWonCards;

    public Player(String naam, Card avatar) {
        this.naam = naam;
        this.avatar = avatar;
    }

    public void createPlayer(String naam, Card avatar) {

    }
}
