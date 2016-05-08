
import java.util.Comparator;
import java.io.Serializable;

public class ComparatorPreco implements Comparator<Imovel>, Serializable {
  
   public int compare(Imovel e1, Imovel e2) {
     if(e1.getPreco() > e2.getPreco())
       return 1; 
     if(e1.getPreco() < e2.getPreco())
       return -1;
     else return 0;
   }
}