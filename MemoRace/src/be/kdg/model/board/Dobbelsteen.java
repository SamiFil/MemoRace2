package be.kdg.model.board;

/**
 * Sami Filjak
 * 23/12/2022
 */
public class Dobbelsteen {
    private int maximumValue;
    private int faceValue;

    public Dobbelsteen(int maximumValue, int faceValue) {
        this.maximumValue = maximumValue;
        this.faceValue = faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }
    public void roll() {

    }
}
