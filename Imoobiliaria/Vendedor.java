/**
 * Classe destinada a designar um Vendedor na Imoobiliária.
 *
 * @author Grupo 60
 * @version (a version number or a date)
 */

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Vendedor extends Utilizador {

    private Set<Imovel> portfolio, vendidos;

    /**
     * Cria uma instância de um Vendedor.
     */
    public Vendedor(){
        super("","","","","");
        this.portfolio = new TreeSet<Imovel>();
        this.vendidos = new TreeSet<Imovel>();
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
    public Vendedor(String email, String nome, String password, String morada, String data_nascimento, Set<Imovel> p, Set<Imovel> v){
        super(email, nome, password, morada, data_nascimento);
        this.portfolio = new TreeSet<Imovel>();
        setPortfolio(p);
        this.vendidos = new TreeSet<Imovel>();
        setVendidos(v);
    }


    public Set<Imovel> getPortfolio(){
        return this.portfolio.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }


    public Set<Imovel> getVendidos(){
        return this.vendidos.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }


    public void setPortfolio(Set<Imovel> imoveis){
        this.portfolio = imoveis.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }


    public void setVendidos(Set<Imovel> imoveis){
        this.vendidos = imoveis.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
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

}
