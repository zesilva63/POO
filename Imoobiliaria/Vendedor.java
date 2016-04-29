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
    

    public Vendedor(){
        this("","","","","");
        portfolio = new TreeSet<>();
        vendidos = new TreeSet<>();
    }
    

    public Vendedor(Vendedor v){
        super(v);
        portfolio = new TreeSet<>();
        vendidos = new TreeSet<>();
    }
    
    public Vendedor(String email, String nome, String password, String morada, String data_nascimento){
        super(email, nome, password, morada, data_nascimento);
        portfolio = new TreeSet<>();
        vendidos = new TreeSet<>();
    }
    
    
    public Set<Imovel> getPortfolio(){
        return this.portfolio.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }
   

    public Set<Imovel> getvendidos(){
        return this.vendidos.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }
   

    public void setportfolio(Set<Imovel> imoveis){
        this.portfolio = imoveis.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }
   

    public void setvendidos(Set<Imovel> imoveis){
        this.vendidos = imoveis.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }
   

    public Vendedor clone(){
        return new Vendedor(this);
    }

}
