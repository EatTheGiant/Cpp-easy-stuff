/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.hlavny;

import sk.uniza.fri.wof.prostredie.IPredmet;
import sk.uniza.fri.wof.prostredie.Navleky;
import sk.uniza.fri.wof.hlavny.Hrac;

/**
 *
 * @author janik
 */
public class QuestPrechadzaniaMiestnostami extends Quest implements IReakciaNaChodenie{

    private final int pocet;
    private int aktualnyStav;
    private Hrac hrac;

    public QuestPrechadzaniaMiestnostami(int pocet, Hrac hrac) {
        this.pocet = pocet;
        this.aktualnyStav = 0;
        this.hrac = hrac;
    }

    public String getNazov() {
        return String.format("Prejdi %d miestnosti", this.pocet);
    }
    
    @Override
    public String getPopis() {
        return String.format("Stary Dezo od teba chce, aby si sa riadne nachodil. Prejdi pre neho aspon %d miestnosti.", this.pocet);
    }
    
    @Override
    public void hracSaPohol() {
        this.aktualnyStav++;
        
        if (this.pocet == this.aktualnyStav) {
            System.out.println("Dezo bude rad, prave si splnil quest");
            System.out.println("Ako odmenu ti dava navleky");
            hrac.pridajPredmet(new Navleky());
        }
    }
    
    
    @Override
    public boolean jeSplneny() {
        return this.aktualnyStav >= this.pocet;
    }
}