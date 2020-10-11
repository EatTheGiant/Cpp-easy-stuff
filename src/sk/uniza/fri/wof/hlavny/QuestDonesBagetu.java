/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.hlavny;

import java.util.ArrayList;
import sk.uniza.fri.wof.prostredie.IPredmet;
import sk.uniza.fri.wof.prostredie.ZbytocnyPredmet;

/**
 *
 * @author Basic
 */
public class QuestDonesBagetu extends Quest implements IReakciaNaChodenie, IReakciaNaPredmety{
    Hrac hrac;
    
    public QuestDonesBagetu(Hrac hrac) {
        this.hrac = hrac;
    }
    
    @Override
    public String getNazov(){
       
        return "donesbagetu";
    }
    
    @Override
    public String getPopis(){
        return "Dezo je hladny dones mu bagetu";
    }
    
    @Override
    public void hracSaPohol() {
        if(hrac.getAktualnaMiestnost().getPredmety().containsKey("bageta")){
            System.out.println("Pozor pozor mas tu bagetu!!!");
        }
    }
    @Override
    public void hracZdviholPredmet(IPredmet predmet){ // bageta
        if(predmet.getNazov() == "bageta"){
            System.out.println("Dvihol si bagetu");
        }
    }
    
    @Override
    public boolean jeSplneny(){
        
        /*for (Quest quest : hrac.getQuestbook().getQuesty()) {
                if(quest instanceof IReakciaNaPredmety){
                    System.out.println("Pozor pozor mas tu bagetu!!!");
                }
            }*/
        
        if(hrac.zobrazZoznamPredmetov().containsKey("dezo") && this.hrac.zobrazZoznamPredmetov().containsKey("bageta")){
          
                    System.out.println("Dezo ma bagetu");
                    System.out.println("Je s tebou velmi spokojny");
                    System.out.println("Ako odmenu dostavas ploskacku");
                    hrac.odstranPredmet("bageta");
                    hrac.pridajPredmet(new ZbytocnyPredmet("ploskacka s koniferkou"));
                    //Tu ju vymazat???
                   return true; 
                }
        return false;
    }
    
}
