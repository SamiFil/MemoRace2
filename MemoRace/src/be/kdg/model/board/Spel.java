package be.kdg.model.board;

import be.kdg.model.player.Player;
import be.kdg.view.game.GamePresenter;
import be.kdg.view.game.GameView;
import be.kdg.view.start.StartPresenter;
import javafx.scene.control.Label;

import java.util.ArrayList;

/**
 * Sami Filjak
 * 16/02/2023
 */
public class Spel {
    private ArrayList<Player> players;
    private int keuze1=0;
    private int keuze2=0;
    private boolean spelBezig;
    private Speelveld speelveld;
    private ArrayList<Integer> geradenKaarten;
    private int mouseclicks=0;
    private int currentPlayerIndex;

    public Spel() {
        this.spelBezig = true;
        this.speelveld = new Speelveld();
        this.geradenKaarten = new ArrayList<>();
        this.players = new ArrayList<Player>();
        this.currentPlayerIndex = 0;}

    public boolean paarGevonden() {
        if (speelveld.getKaarten().get(keuze1 - 1).getTypeCard().equals(speelveld.getKaarten().get(keuze2 - 1).getTypeCard())) {
            speelveld.getKaarten().get(keuze1 - 1).setIsGevondenToTrue();
            geradenKaarten.add(keuze1);
            geradenKaarten.add(keuze2);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkOfSpelBezig(){
        if (geradenKaarten.size() == 16) {
            spelBezig = false;
        }
        return spelBezig;
    }



    public int getMouseclicks() {
        return mouseclicks;
    }

    public void setMouseclicks() {
        mouseclicks = mouseclicks+1;
    }

    public void setKeuze1(int keuze1) {
        this.keuze1 = keuze1;
    }

    public void setKeuze2(int keuze2) {

        this.keuze2 = keuze2;
    }
    public int getKeuze1() {
        return keuze1;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getKeuze2() {
        return keuze2;
    }

    public Speelveld getSpeelveld() {
        return speelveld;
    }

    public void switchPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex >= players.size()) {
            currentPlayerIndex = 0;
        }
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

}
