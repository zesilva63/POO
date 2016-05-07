/**
 * Write a description of class ComparatorSalario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Comparator;
import java.io.Serializable;

public class ComparatorLicitacao implements Comparator<Licitacao>, Serializable {
  
   public int compare(Licitacao e1, Licitacao e2) {
     if(e1.getValor() > e2.getValor())
       return 1; 
     if(e1.getValor() < e2.getValor())
       return -1;
     else return 0;
   }
}
