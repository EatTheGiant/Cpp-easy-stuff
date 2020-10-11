/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.hlavny;

import java.util.ArrayList;
import sk.uniza.fri.wof.prostredie.IPredmet;
import sk.uniza.fri.wof.prostredie.Navleky;

/**
 *
 * @author janik
 */
public class Questbook {

    private final ArrayList<Quest> questy;
    private final RiadicQuestov riadic;

    public Questbook() {
        this.questy = new ArrayList<Quest>();
        this.riadic = new RiadicQuestov(this);
    }
    
    public void pridajQuest(Quest quest) {
        this.questy.add(quest);
    }
    
    public void odoberQuest(Quest quest){
        this.questy.remove(quest);

    }
    
    public void vypisQuesty() {
        if (this.questy.isEmpty()) {
            System.out.println("Nemas questy");
        } else {
            System.out.println("Aktivne questy:");
            for (Quest quest : this.questy) {
                System.out.format("- %s%n", quest.getNazov());
                System.out.format("  %s%n", quest.getPopis());
            }
        }
    }

    public RiadicQuestov getRiadic() {
        return this.riadic;
    }
    
   public void skontrolujStav() {
        ArrayList<Quest> naVymazanie = new ArrayList<Quest>();
        
        for (Quest quest : this.questy) {
            if (quest.jeSplneny()) {
                // nemazeme priamo z this.questy, lebo by nam padol for-each
                naVymazanie.add(quest);
            }
        }
        this.questy.removeAll(naVymazanie);
    }

    ArrayList<Quest> getQuesty() {
        // vraciame kopiu, aby sme neporusili zapuzdrenie
        ArrayList<Quest> ret = new ArrayList<Quest>();
        ret.addAll(this.questy);
        return ret;
    }
    
}
