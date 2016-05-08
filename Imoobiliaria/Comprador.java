/**
 * Classe relativa a um Comprador.
 *
 * @author Grupo 60
 */

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class Comprador extends Utilizador {

    // VARIAVEIS DE INSTÂNCIA
	private Map<String,Imovel> favoritos;


	// CONSTRUTORES

	/**
	 * Cria uma instância de um Comprador.
	 */
    public Comprador(){
        super("","","","","");
        favoritos = new HashMap<String,Imovel>();
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
    public Comprador(String email, String nome, String password, String morada, String data_nascimento, HashMap<String,Imovel> f){
        super(email, nome, password, morada, data_nascimento);
        favoritos = new HashMap<String,Imovel>();
        setFavoritos(f);
    }

	 // GETTERS E SETTERS

    public Map<String,Imovel> getFavoritos(){
		 return this.favoritos.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
	 }


    public void setFavoritos(Map<String,Imovel> imoveis){
		 this.favoritos = imoveis.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
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

	 /**
	 * Adiciona um Imovel aos Favoritos.
	 * @param
	 */
	 public void adicionaFavorito(Imovel i) {
		 this.favoritos.put(i.getId(),i);
	 }
}
