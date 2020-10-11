/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.hlavny;

import sk.uniza.fri.wof.hlavny.Hrac;
import sk.uniza.fri.wof.hlavny.Quest;
import sk.uniza.fri.wof.prostredie.IPredmet;
import sk.uniza.fri.wof.prostredie.ZbytocnyPredmet;

/**
 *
 * @author Basic
 */
public class QuestDonesNohy extends Quest implements IReakciaNaChodenie, IReakciaNaPredmety{
    Hrac hrac;
    public QuestDonesNohy(Hrac hrac) {
        this.hrac = hrac;
    }
    
    @Override
    public String getNazov(){
       
        return "donesnohy";
    }
    
    @Override
    public String getPopis(){
        return "Dezo ma chybne nohy najdi mu nove. A neopi sa cestou z tej koniferky.";
    }
    
    @Override
    public void hracSaPohol() {
        if(hrac.getAktualnaMiestnost().getPredmety().containsKey("nohalava") && hrac.getAktualnaMiestnost().getPredmety().containsKey("nohaprava")){
            
            System.out.println("Pozor pozor mas tu obe Dezove nohy");
                    
        }else if(hrac.getAktualnaMiestnost().getPredmety().containsKey("nohaprava")){
        
            System.out.println("Pozor pozor mas tu Dezovu pravu nohu!!!");
            
        }else if(hrac.getAktualnaMiestnost().getPredmety().containsKey("nohalava")){
            
            System.out.println("Pozor pozor mas tu Dezovu lavu nohu!!!");
        }
    }
    @Override
    public void hracZdviholPredmet(IPredmet predmet){ // bageta
        
        if(predmet.getNazov() == "nohaprava"){
            System.out.println("Dvihol si pravu nohu pre Deza");
        }else if (predmet.getNazov() == "nohalava"){
            System.out.println("Dvihol si lavu nohu pre Deza");
        }
    }
    
    @Override
    public boolean jeSplneny(){
        
        if(
            this.hrac.zobrazZoznamPredmetov().containsKey("dezo")   && 
            this.hrac.zobrazZoznamPredmetov().containsKey("nohalava") &&
            this.hrac.zobrazZoznamPredmetov().containsKey("nohaprava"))    
            {
                System.out.println("Dezo ma obe nohy");
                System.out.println("Je stastny ze moze opat chodit");
                System.out.println("Ani ti nepodakoval a uz so svojimi nohami uteka aby ti nemusel nic dat. ");
                System.out.println("Legenda hovori ze uteka ako Forest Gump a len tak neprestane.");
                hrac.odstranPredmet("nohalava");
                hrac.odstranPredmet("nohaprava");
                hrac.odstranPredmet("dezo");
                //Tu ju vymazat???
               return true; 
            }
        return false;
    }
    
}
