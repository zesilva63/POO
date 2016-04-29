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

	private Set<Imovel> favoritos;
    

    public Comprador(){
        this("","","","","");
        favoritos = new TreeSet<>();
    }
    

    public Comprador(Comprador v){
        super(v);
        favoritos = new TreeSet<>();
    }
    
    public Comprador(String email, String nome, String password, String morada, String data_nascimento){
        super(email, nome, password, morada, data_nascimento);
        favoritos = new TreeSet<>();
    }
    
    
    public Set<Imovel> getfavoritos(){
        return this.favoritos.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }
   

    public void setfavoritos(Set<Imovel> imoveis){
        this.favoritos = imoveis.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }
   

    public Comprador clone(){
        return new Comprador(this);
    }


}
