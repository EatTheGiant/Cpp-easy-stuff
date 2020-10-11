/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.prostredie;

import sk.uniza.fri.wof.hlavny.QuestDonesNohy;
import sk.uniza.fri.wof.hlavny.QuestDonesBagetu;
import sk.uniza.fri.wof.hlavny.Hrac;
import sk.uniza.fri.wof.hlavny.QuestPrechadzaniaMiestnostami;


/**
 *
 * Kedze nemame zatial ziadne postavy okrem hraca
 * Stary dezo, ktory bude davat quest bude predmet.
 */
public class Dezo implements IPredmet {

    private boolean dalQuesty;
    private int cisloQuestu;

    public Dezo() {
        this.dalQuesty = false;
        this.cisloQuestu = 0;
    }
    
    @Override
    public String getNazov() {
        return "dezo";
    }

    @Override
    public void pouziSa(Hrac hrac) {
        if (this.dalQuesty) {
            System.out.println("Dezo uz s tebou nic nechce mat");
        } else if(this.cisloQuestu == 0){
            System.out.println("Dezo chce, aby si presiel 5 miestnostami");
            hrac.getQuestbook().pridajQuest(new QuestPrechadzaniaMiestnostami(5, hrac));
            this.cisloQuestu++;
        }else if (this.cisloQuestu == 1){
            System.out.println("Dezo chce bagetu. Zozen mu bagetu");
            hrac.getQuestbook().pridajQuest(new QuestDonesBagetu(hrac));
            this.cisloQuestu++;
        }else if(this.cisloQuestu == 2){
            System.out.println("Dezo ma bolave nohy zozen mu nove.");
            hrac.getQuestbook().pridajQuest(new QuestDonesNohy(hrac));
        }
    }

    @Override
    public boolean daSaPolozit() {
        return true;
    }
    
}
