/**
 * Write a description of class Imoobiliaria here.
 * 
 * @author Grupo 60
 * @version (a version number or a date)
 */


import java.util.Map;
import java.util.TreeMap;

public class Imoobiliaria {
   
    private Map<String,Imovel> imoveis;
    private Map<String,Utilizador> utilizadores;
    
    
    /**
     * Construtor de um Imovel
     */
    public Imoobiliaria() {
        this.imoveis = new TreeMap<>();
        this.utilizadores = new TreeMap<>();
    }
}