/**
 * Classe relativa a um Comprador.
 *
 * @author Grupo 60
 */

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Comprador extends Utilizador {

    // VARIAVEIS DE INSTÂNCIA
	private Set<Imovel> favoritos;


	// CONSTRUTORES

	/**
	 * Cria uma instância de um Comprador.
	 */
    public Comprador(){
        super("","","","","");
        favoritos = new TreeSet<Imovel>();
    }

	 /**
     * Construtor por cópia.
     * @param c
     */
    public Comprador(Comprador c){
        super(c);
        this.favoritos = c.getFavoritos();
    }

	 /**
     * Construtor por parametro
     * @param email
     * @param nome
     * @param password
     * @param morada
     * @param data_nascimento
     * @param f
     */
    public Comprador(String email, String nome, String password, String morada, String data_nascimento, Set<Imovel> f){
        super(email, nome, password, morada, data_nascimento);
        favoritos = new TreeSet<Imovel>();
        setFavoritos(f);
    }

	 // GETTERS E SETTERS

    public Set<Imovel> getFavoritos(){
        return this.favoritos.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }


    public void setFavoritos(Set<Imovel> imoveis){
        this.favoritos = imoveis.stream().map(i -> {return i.clone();}).collect(Collectors.toSet());
    }

	 // CLONE

    public Comprador clone(){
        return new Comprador(this);
    }


	 // EQUALS

	 public boolean equals(Object obj){
       if(this == obj)
         return true;
       if ((obj==null) || (this.getClass() != obj.getClass()))
         return false;
       Comprador c = (Comprador) obj;
         return (super.equals(c)); /* falta equals de cada um dos imoveis caso seja necessário */
    }


}
