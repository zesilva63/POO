/**
 * Classe relativa á Imoobiliaria a gerir.
 *
 * @author Grupo 60
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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


    public Imoobiliaria(TreeMap<String,Utilizador> u, TreeMap<String,Imovel> i) {

       this.utilizador = null;

       this.imoveis = new TreeMap<String,Imovel>();
       for (Imovel imovel : i.values()) {
          this.imoveis.put(imovel.getId(), imovel.clone());
       }

       this.utilizadores = new TreeMap<String,Utilizador>();
       for (Utilizador utilizador : u.values()) {
          this.utilizadores.put(utilizador.getEmail(), utilizador.clone());
       }
    }


    // REGISTOS DO PROGRAMA

    public void registarUtilizador ( Utilizador utilizador ) throws UtilizadorExistenteException{

       if(this.utilizadores.containsValue(utilizador)){
           throw new UtilizadorExistenteException ("Ja existe este Utilizador");
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
                        utilizador = user;
                 }
                 else {
                        throw new SemAutorizacaoException("Dados Errados");
                 }
            }
            else throw new SemAutorizacaoException("Dados Errados");
        }
        else {
            throw new SemAutorizacaoException("Ja tem uma sessão iniciada");
        }

    }


    public void fechaSessao(){
        this.utilizador = null;
    }


    // VENDEDORES


    public void registaImovel(Imovel im) throws ImovelExisteException , SemAutorizacaoException {
        if(this.utilizador.getClass().getSimpleName().equals("Vendedor")){
            if(this.imoveis.containsValue(im) == false) {
                this.imoveis.put(im.getId(),im);
                Vendedor v1 = (Vendedor) this.utilizador;
                v1.adicionaPortfolio(im);
            }
            else throw new ImovelExisteException("Imovel já existe.");
        }
        else throw new SemAutorizacaoException("Apenas Vendedores estão autorizados.");
    }



    public void setEstado(String idImovel , String estado) throws ImovelInexistenteException , SemAutorizacaoException , EstadoInvalidoException {

      if(this.utilizador.getClass().getSimpleName().equals("Vendedor"))  {
         Imovel i = this.imoveis.get(idImovel);
         if(i != null) { // imovel existe
            if(estado.equals("em venda") || estado.equals("vendido") || estado.equals("reservado")) {
               i.setEstado(estado);
            } else {
               throw new EstadoInvalidoException("Estado Inválido.");
            }
         } else {
            throw new ImovelInexistenteException("Imóvel Inexistente.");
         }
      }
      else {
           throw new SemAutorizacaoException("Sem autorização para efectuar tal ação.");
      }
    }



    public Set<String> getTopImoveis (int n) {
      Set<String> lista = new HashSet<String>();
      Vendedor v = (Vendedor) this.utilizador;
      for(Imovel im : v.getPortfolio().values()){
         if(n < im.getConsultas().size()){
            lista.add(im.getId());
         }
      }
      return lista;
   }


    // TODOS OS UTILIZADORES

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
                GregorianCalendar data = new GregorianCalendar();
                if(this.utilizador != null) i.adicionaConsulta(this.utilizador.getEmail(),data);
                else i.adicionaConsulta("N/A",data);
                l.add(novo.clone());
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
                GregorianCalendar data = new GregorianCalendar();
                if(this.utilizador != null) h.adicionaConsulta(this.utilizador.getEmail(),data);
                else h.adicionaConsulta("N/A",data);
                l.add(hab);
            }
        }
        return l;
    }

    // COMPRADORES


    public void setFavorito(String idImovel) throws SemAutorizacaoException, ImovelInexistenteException {
        if(this.utilizador.getClass().getSimpleName().equals("Comprador")){
            if(this.imoveis.containsKey(idImovel)) {
                Comprador c = (Comprador) this.utilizador;
                c.adicionaFavorito(this.imoveis.get(idImovel));
            }
            else throw new ImovelInexistenteException("O Imovel não existe.");
        }
        else throw new SemAutorizacaoException("Apenas Compradores registados estão autorizados.");
    }



}
