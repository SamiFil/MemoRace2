package be.kdg.model.board;

import javafx.scene.image.Image;

/**
 * Sami Filjak
 * 23/12/2022
 */
public class Card {
    private String imageURL;
    private String typeCard;
    private boolean isGevonden;
    private boolean isOmgedraaid;
    private Image achterkantKaart;
    private Image voorkantKaart;

    public Card(String typeCard, String imageURL) {
        this.typeCard = typeCard;
        this.imageURL = imageURL;
        achterkantKaart = new Image("cards/back.png");
        voorkantKaart = new Image(imageURL);
        isOmgedraaid = false;
        isGevonden = false;
    }

    public Image getAchterkantKaart() {
        return achterkantKaart;
    }

    public boolean isGevonden() {
        return isGevonden;
    }

    public boolean isOmgedraaid() {
        return isOmgedraaid;
    }

    public Image getVoorkantKaart() {
        return voorkantKaart;
    }

    public String getTypeCard() {

        return typeCard;
    }

    public void setIsGevondenToTrue() {
        isGevonden = true;
    }

    public Boolean getOmgedraaid() {

        return isOmgedraaid;
    }

}
