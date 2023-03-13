package be.kdg.model.board;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Sami Filjak
 * 9/03/2023
 */
public class Scoreboard {
    private Label nameLabel;
    private Label scoreLabel;
    private ImageView avatarLabel;

    public Scoreboard(Label nameLabel, Label scoreLabel, ImageView avatarLabel) {
        this.nameLabel = nameLabel;
        this.scoreLabel = scoreLabel;
        this.avatarLabel = avatarLabel;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }

    public ImageView getAvatarLabel() {
        return avatarLabel;
    }

    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    public void setScoreLabel(Label scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public void setAvatarLabel(ImageView avatarLabel) {
        this.avatarLabel = avatarLabel;
    }
}
