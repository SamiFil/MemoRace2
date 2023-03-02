package be.kdg.model.board;

import java.util.ArrayList;

/**
 * Sami Filjak
 * 16/02/2023
 */
public class Spel {
    private int keuze1=0;
    private int keuze2=0;
    private boolean spelBezig;
    private Speelveld speelveld;
    private ArrayList<Integer> geradenKaarten;
    private int mouseclicks=0;
    private String spelerNaam;

    public Spel() {
        this.spelBezig = true;
        this.speelveld = new Speelveld();
        this.geradenKaarten = new ArrayList<>();
    }

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

    public String getSpelerNaam() {
        return spelerNaam;
    }

    public void setSpelerNaam(String spelerNaam) {
        this.spelerNaam = spelerNaam;
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

    public Speelveld getSpeelveld() {
        return speelveld;
    }

}
