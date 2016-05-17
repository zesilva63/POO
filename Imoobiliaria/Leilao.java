import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Double;
import java.util.Comparator;
import java.util.Collections;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.io.Serializable;

public class Leilao implements Serializable {
   
    private ArrayList<Licitacao> licitadores;
    private Imovel imovel;
    private int tempo;

    public Leilao (Imovel im, int horas){
        this.licitadores = new ArrayList<Licitacao>(); 
        this.imovel = im.clone();
        this.tempo = horas;
    }
    
    //Adicionar comprador ao leilão:
    public void adicionaComprador ( String idComprador , double limite ,  double incrementos , double minutos ) throws LeilaoTerminadoException{
        
        if(tempo!=0){
            Licitacao l = new Licitacao(idComprador,limite,incrementos,minutos);
            this.licitadores.add(l); 
        }
        else new LeilaoTerminadoException("Leilão Terminado");

    }
    
    public void arrancaLeilao(){
        System.out.println("#########COMEÇA O LEILÃO##########");
        LocalTime now1 = LocalTime.now();
        LocalTime now2 = LocalTime.now();
        for(Licitacao l: licitadores){
            l.setTempo(now1);
        }
        long secondsBetween = ChronoUnit.SECONDS.between(now1, now2);
        while((tempo*60) > (int) secondsBetween){ 
            for(Licitacao l : licitadores){
                now2=LocalTime.now();
                l.actualizaValor(now2);
               
                System.out.println(l.getLicitador() + "faz uma licitação de" + l.getValor() + "€");
            }
            now2 = LocalTime.now();
            secondsBetween = ChronoUnit.SECONDS.between(now1, now2);
        }
    }
    
    //Encerrar um leilão:
    public Licitacao encerraLeilao(){
        this.imovel=null; 
        this.tempo=0;
        Collections.sort(licitadores, new ComparatorLicitacao());
        return licitadores.get(0);
    }
    
    public Imovel getImovel(){
        return this.imovel;
    }
    
    public int getTempo(){
        return this.tempo;
    }
    
}
