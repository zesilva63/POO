/**
 * Classe relativa á Imoobiliaria a gerir.
 *
 * @author Grupo 60
 */

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;


public class Imoobiliaria {

   // VARIAVEIS DE INSTANCIA

    private Map<String,Imovel> imoveis;
    private Map<String,Utilizador> utilizadores;
    private Utilizador utilizador;


    // CONSTRUTORES

    /**
     * Construtor vazio de uma Imoobiliaria.
     */
    public Imoobiliaria() {
        this.imoveis = new TreeMap<String,Imovel>();
        this.utilizadores = new TreeMap<String,Utilizador>();
        this.utilizador = null;
    }


   public Imoobiliaria(Vendedor v, TreeMap<String,Utilizador> u, TreeMap<String,Imovel> i) {
      this.utilizador = new Vendedor(v.clone());

      this.imoveis = new TreeMap<String,Imovel>();
      for (Imovel imovel : i.values()) {
         this.imoveis.put("imovel"/*substituir por hash*/, imovel.clone());
      }

      this.utilizadores = new TreeMap<String,Utilizador>();
      for (Utilizador utilizador : u.values()) {
         this.utilizadores.put("imovel"/*substituir por hash*/, utilizador.clone());
      }
   }


   public Imoobiliaria(Comprador c, TreeMap<String,Utilizador> u, TreeMap<String,Imovel> i) {
      this.utilizador = new Comprador(c.clone());

      this.imoveis = new TreeMap<String,Imovel>();
      for (Imovel imovel : i.values()) {
         this.imoveis.put("imovel"/*substituir por hash*/, imovel.clone());
      }

      this.utilizadores = new TreeMap<String,Utilizador>();
      for (Utilizador utilizador : u.values()) {
         this.utilizadores.put("imovel"/*substituir por hash*/, utilizador.clone());
      }
   }

    // FUNCOES REQUERIDAS

    /**
    * Devolve uma lista com os imoveis de um dado Tipo e até um certo Preço.
    * @param classe
    * @param preco
    * @return
    */
    public List<Imovel> getImovel(String classe, int preco) {
        ArrayList<Imovel> l = new ArrayList<Imovel>();
        for(Imovel i: this.imoveis.values()) {
            if((i.getClass().getSimpleName().equals(classe)) && i.getPreco() <= preco) {
                Imovel novo = (Imovel) i;
                l.add(novo);
            }
        }
        return l;
    }

    /**
    * Devolve uma lista com os Imoveis Habitaveis até um dado Preço.
    * @param preco
    * @return
    */
    public List <Habitavel> getHabitaveis ( int preco ) {
        ArrayList<Habitavel> l = new ArrayList<Habitavel>();
        for(Imovel h: this.imoveis.values()) {
            if(((h instanceof Moradia) || (h instanceof Apartamento) || (h instanceof LojaHabitavel)) && h.getPreco() <= preco) {
                Habitavel hab = (Habitavel) h;
                l.add(hab);
            }
        }
        return l;
   }

   public void registarUtilizador ( Utilizador utilizador ) throws UtilizadorExistenteException{

       if( this.utilizadores.containsValue(utilizador) ){
           throw new UtilizadorExistenteException ("Ja existe");
        }
        else {
            this.utilizadores.put(utilizador.getEmail(),utilizador);
        }
   }
  
     public void iniciaSessao(String email, String password) throws SemAutorizacaoException {

        if (this.utilizador == null) {
               
            if(utilizadores.containsKey(email)){
                 Utilizador user = utilizadores.get(email);
                 if (password.equals(user.getPassword())) {
                        utilizador = user.clone();
                 } 
                 else {
                        throw new SemAutorizacaoException("Dados Errados");
                 }
            }
            else throw new SemAutorizacaoException("Dados Errados");
        }    
            /* nenhum registado com estes dados */
        else {
            throw new SemAutorizacaoException("Ja tem uma sessao iniciada");
            /* ja iniciou sessao */
        }

    }
    
    public void fecharSessao(){
        this.utilizador=null;
    }
   }
