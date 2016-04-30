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
     * Construtor de uma Imoobiliaria
     */
    public Imoobiliaria() {
        this.imoveis = new TreeMap<String,Imovel>();
        this.utilizadores = new TreeMap<String,Utilizador>();
    }
}
