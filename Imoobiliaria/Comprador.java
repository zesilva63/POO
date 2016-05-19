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
        super("Comprador","","","","");
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
        if (f!=null) setFavoritos(f);
    }

    // GETTERS E SETTERS
    /** 
     * Devolve os Imóveis favoritos de um Comprador.
     * @return 
     */
    public Map<String,Imovel> getFavoritos(){
         return this.favoritos.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
    }

    /** 
     * Define os Imóveis favoritos de um Comprador.
     * @param imoveis 
     */
    public void setFavoritos(Map<String,Imovel> imoveis){
         this.favoritos = imoveis.entrySet().stream().collect(toMap(e->e.getKey(), e->e.getValue().clone()));
    }

     // CLONE
    /**
     * Devolve uma cópia do Comprador.
     * @return
     */
    public Comprador clone(){
        return new Comprador(this);
    }


     // EQUALS
    /**
     * Compara a igualdade com outro objecto
     * @param obj
     * @return
     */
     public boolean equals(Object obj){
       if(this == obj)
         return true;
       if ((obj==null) || (this.getClass() != obj.getClass()))
         return false;
       Comprador c = (Comprador) obj;
         return (super.equals(c)); 
    }

     /**
     * Adiciona um Imovel aos Favoritos.
     * @param
     */
     public void adicionaFavorito(Imovel i) {
         this.favoritos.put(i.getId(),i);
     }
}
