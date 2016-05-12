import java.util.ArrayList;
import java.lang.Double;
import java.util.Comparator;
import java.util.Collections;

public class Leilao {
   
    private ArrayList<Licitacao> licitadores;
    private Imovel imovel;
    private int tempo;

    private Leilao (Imovel im, int horas){
        this.licitadores = new ArrayList<Licitacao>();
        this.imovel = im.clone();
        this.tempo = horas;
    }

    public Leilao iniciaLeilao ( Imovel im , int horas ){
        Leilao leilao = new Leilao(im,horas);
        return leilao;
    }
    //Adicionar comprador ao leilão:
    public void adicionaComprador ( String idComprador , double limite ,  double incrementos , double minutos ) throws LeilaoTerminadoException{
        if(tempo!=0){
            Licitacao l = new Licitacao(idComprador,limite,incrementos,minutos);
        }
        else new LeilaoTerminadoException("Leilão Terminado");

    }
    //Encerrar um leilão:
    public String encerraLeilao (){
        this.imovel=null;
        this.tempo=0;
        Collections.sort(licitadores, new ComparatorLicitacao());
        return licitadores.get(0).getLicitador();
    }
}
