/**
 * Classe destinada a designar um Vendedor na Imoobiliária.
 *
 * @author Grupo 60
 */

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;


public class Vendedor extends Utilizador {

    private Map<String,Imovel> portfolio, vendidos;

    /**
     * Cria uma instância de um Vendedor.
     */
    public Vendedor(){
        super("","","","","");
        this.portfolio = new HashMap<String,Imovel>();
        this.vendidos = new HashMap<String,Imovel>();
    }

    /**
     * Construtor por cópia.
     * @param v
     */
    public Vendedor(Vendedor v){
        super(v);
        this.portfolio = v.getPortfolio();
        this.vendidos = v.getVendidos();
    }

    /**
     * Construtor por parametro
     * @param email
     * @param nome
     * @param password
     * @param morada
     * @param data_nascimento
     * @param p
     * @param v
     */
    public Vendedor(String email, String nome, String password, String morada, String data_nascimento, HashMap<String,Imovel> p, HashMap<String,Imovel> v){
        super(email, nome, password, morada, data_nascimento);
        this.portfolio = new HashMap<String,Imovel>();
        if(p!= null) this.setPortfolio(p);
        this.vendidos = new HashMap<String,Imovel>();
        if(p!=null) this.setVendidos(v);
    }


    public Map<String,Imovel> getPortfolio(){
        return this.portfolio.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
    }


    public Map<String,Imovel> getVendidos(){
        return this.vendidos.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
    }


    public void setPortfolio(Map<String,Imovel> imoveis){
        this.portfolio = imoveis.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue()));
    }


    public void setVendidos(Map<String,Imovel> imoveis){
        this.vendidos = imoveis.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue()));
    }


    public Vendedor clone(){
        return new Vendedor(this);
    }


   public boolean equals(Object obj){
      if(this == obj)
        return true;
      if ((obj==null) || (this.getClass() != obj.getClass()))
        return false;
      Vendedor v = (Vendedor) obj;
        return (super.equals(v)); /* falta equals de cada um dos imoveis caso seja necessário */
   }

   public void adicionaPortfolio(Imovel i) {
      this.portfolio.put(i.getId(),i);
   }

   public void adicionaVendidos(Imovel i) {
      this.vendidos.put(i.getId(),i);
   }

}
