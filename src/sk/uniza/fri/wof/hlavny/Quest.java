/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.hlavny;

import sk.uniza.fri.wof.prostredie.IPredmet;

/**
 *
 * @author Basic
 */
abstract class Quest{
    
    abstract String getNazov();
    
    abstract String getPopis();
    
    abstract boolean jeSplneny();
    
}
