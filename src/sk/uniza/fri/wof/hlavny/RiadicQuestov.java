/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.hlavny;

import java.util.ArrayList;
import sk.uniza.fri.wof.prostredie.Bageta;
import sk.uniza.fri.wof.prostredie.IPredmet;

/**
 *
 * Trieda riadic questov ma za ulohu riadit stav questov. Preposiela im
 * vsetky akcie, ktore hrac v hre spravi - posun medzi miestnostami,
 * manipulacia s predmetmi, atd...
 */
public class RiadicQuestov{

    private final Questbook questbook;

    RiadicQuestov(Questbook questbook) {
        this.questbook = questbook;
    }
    
    public void hracSaPohol() {
        for (Quest quest : this.questbook.getQuesty()) {
            if(quest instanceof IReakciaNaChodenie){
                ((IReakciaNaChodenie) quest).hracSaPohol();
                
            }
        }
        questbook.skontrolujStav();
    }

    public void hracDviholPredmet(IPredmet predmet) {
        //for (Quest quest : this.questbook.getQuesty()) {
        // quest.hracZdviholPredmet(predmet);
        //}
        
        for (Quest quest : this.questbook.getQuesty()) {
            if(quest instanceof IReakciaNaPredmety){
                ((IReakciaNaPredmety) quest).hracZdviholPredmet(predmet);
                
            }
        }
        questbook.skontrolujStav();
    }
}