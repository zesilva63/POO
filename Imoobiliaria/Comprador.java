/**
 * Write a description of class Comprador here.
 * 
 * @author Grupo 60 
 * @version (a version number or a date)
 */

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Comprador extends Utilizador {

    // Variaveis de instância

	private Set<Imovel> favoritos;
    


    public Comprador(){
        super("","","","","");
        favoritos = new TreeSet<Imovel>();
    }
    

    public Comprador(Comprador v){
        super(v);
        this.favoritos = v.getFavoritos();
    }
    
    public Comprador(String email, String nome, String password, String morada, String data_nascimento, Set<Imovel> f){
        super(email, nome, password, morada, data_nascimento);
        favoritos = new TreeSet<Imovel>();
        setFavoritos(f);
    }
    

    
    public Set<Imovel> getFavoritos(){
        return this.favoritos.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }
   

    public void setFavoritos(Set<Imovel> imoveis){
        this.favoritos = imoveis.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }
   

    public Comprador clone(){
        return new Comprador(this);
    }


    

}
