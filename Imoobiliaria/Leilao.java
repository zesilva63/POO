import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Double;
import java.util.Comparator;
import java.util.Collections;
import java.io.Serializable;

public class Leilao implements Serializable {
   
    private ArrayList<Licitacao> licitadores;
    private Licitacao vencedora = null;
    private Imovel imovel;
    private int horas;
    private int montante;

    public Leilao (Imovel im, int horas){
        this.licitadores = new ArrayList<Licitacao>(); 
        this.imovel = im;
        this.horas = horas;
    }
    
    //Adicionar comprador ao leilão:
    public void adicionaComprador ( String idComprador , double limite ,  double incrementos , double minutos ) throws LeilaoTerminadoException{
        
        if(horas!=0){
            Licitacao l = new Licitacao(idComprador,limite,incrementos,minutos);
            this.licitadores.add(l); 
        }
        else new LeilaoTerminadoException("Leilão Terminado");

    }
    
    public void arrancaLeilao(){
        long inicio = System.currentTimeMillis();
        this.montante = 0;
        System.out.println("Início do LEILÃO!");
        long tempo = System.currentTimeMillis();
        while(((tempo-inicio)/1000) < horas){
            for(Licitacao l: licitadores){
                if(montante > l.getLimite()){}
                else if(vencedora == l){}
                else if(montante + l.getIncremento() < l.getLimite() && ((tempo-l.getTempo())/1000)>= l.getMinutos()){
                    l.setTempo(tempo);
                    montante += l.getIncremento();
                    vencedora = l;
                    System.out.println("Licitador: " + l.getLicitador() + "  | Licitação: " + montante + "!");
                }
            }
            tempo = System.currentTimeMillis();
        }
        if(montante < this.imovel.getPreco_Minimo()){
            vencedora = null;
        }
    }
    
    public Licitacao encerraLeilao(){
        return this.vencedora;
    }
    
    public Imovel getImovel(){
        return this.imovel;
    }
    
    public int getHoras(){
        return this.horas;
    }
    
}
