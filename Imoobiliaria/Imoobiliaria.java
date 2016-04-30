/**
 * Classe relativa á Imoobiliaria a gerir.
 *
 * @author Grupo 60
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
