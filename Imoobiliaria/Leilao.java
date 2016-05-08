


import java.util.ArrayList;
import java.lang.Double;
import java.util.Comparator;

public class Leilao {
   
    private ArrayList<Licitacao> licitadores;
    private Imovel imovel;
    private int tempo;

    private Leilao (Imovel im, int horas){
        this.licitadores = new ArrayList<Licitacao>();
        this.imovel = im.clone();
        this.tempo = horas;
    }


    /*private Comprador vencedor(ArrayList<Licitacao> list){
        Collections.sort(list,new ComparatorLicitacao());
        return list.get(0);

    }*/

    public void iniciaLeilao ( Imovel im , int horas ) throws SemAutorizacaoException{
        /*nao sei se temos que verificar se o imovel existe*/
        if(im == null){
            Leilao leilao = new Leilao(im,horas);
        }
        else throw new SemAutorizacaoException ("Leilao ja se encontra aberto");/*ou será para ver se so podem ter vendedores a inicar??*/

    }
    //Adicionar comprador ao leilão:
    public void adicionaComprador ( String idComprador , double limite ,  double incrementos , double minutos ) throws LeilaoTerminadoException{
        if(tempo!=0){
            Licitacao l = new Licitacao(idComprador,limite,incrementos,minutos);
        }
        else new LeilaoTerminadoException("Leilão Terminado");

    }
    //Encerrar um leilão:
    public Comprador encerraLeilao (){
        this.imovel=null;
        this.tempo=0;
        return null /*vencedor(licitadores)*/;
    }
}
