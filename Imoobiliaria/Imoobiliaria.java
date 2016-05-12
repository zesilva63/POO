/**
 * Classe relativa á Imoobiliaria a gerir.
 *
 * @author Grupo 60
 */

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.*;

public class Imoobiliaria {


   // VARIAVEIS DE INSTANCIA
    /* Map que contem os imoveis todos associados pelo seu ID */
    private Map<String,Imovel> imoveis;
    /* Map que contem os utilizadores todos associados pelo seu Email */
    private Map<String,Utilizador> utilizadores;
    /* Utilizador registado na aplicação */
    private Utilizador utilizador;
    /* Leilão */
    private Leilao leilao;


    // CONSTRUTORES

    /**
     * Construtor vazio de uma Imoobiliaria.
     */
    public Imoobiliaria() {
        this.imoveis = new TreeMap<String,Imovel>();
        this.utilizadores = new TreeMap<String,Utilizador>();
        this.utilizador = null;
    }

    /**
    * Construtor por parametros de uma Imoobiliaria.
    * @param u
    * @param i
    */
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

    /**
    * Inicia o programa com um estado previo para que tenhamos dados suficientes para executar de imediato testes.
    */
    public static Imoobiliaria initApp() throws IOException, ClassNotFoundException {
      String ficheiro = "file.txt";
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheiro));

      Imoobiliaria te= (Imoobiliaria) ois.readObject();

      ois.close();
      return te;
    }

    /**
    * Regista um utilizador na aplicação caso o mesmo não exista.
    * @param utilizador
    */
    public void registarUtilizador ( Utilizador utilizador ) throws UtilizadorExistenteException {

       if(this.utilizadores.containsValue(utilizador)){
           throw new UtilizadorExistenteException ("Ja existe este Utilizador");
        }
        else {
            this.utilizadores.put(utilizador.getEmail(),utilizador);
        }
    }

    /**
    * Inicia a sessão na aplicação de um dado utilizador.
    * @param email
    * @param password
    */
    public void iniciaSessao(String email, String password) throws SemAutorizacaoException {

        if (this.utilizador == null) {

            if(utilizadores.containsKey(email)){
                 Utilizador user = utilizadores.get(email);
                 if (password.equals(user.getPassword())) {
                        utilizador = user;
                 }
                 else {
                        throw new SemAutorizacaoException("A password inserida está incorrecta!");
                 }
            }
            else throw new SemAutorizacaoException("Nome de utilizador inexistente!");
        }
        else {
            throw new SemAutorizacaoException("Já existe uma sessão iniciada");
        }
    }

    /**
    * Termina a sessão.
    */
    public void fechaSessao(){
        this.utilizador = null;
    }


    /**
    * Grava o estado do programa num ficheiro.
    * @param ficheiro
    */
    public void gravaObj(String ficheiro) throws IOException {
       ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheiro));
       oos.writeObject(this);

       oos.flush();
       oos.close();
    }


    // VENDEDORES


    /**
    * Regista um imovel na aplicação.
    * @param im
    */
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


    /**
    * Altera o estado de um imovel.
    * @param idImovel
    * @param estado
    */
    public void setEstado(String idImovel , String estado) throws ImovelInexistenteException , SemAutorizacaoException , EstadoInvalidoException {

      if(this.utilizador.getClass().getSimpleName().equals("Vendedor"))  {
         Imovel i = this.imoveis.get(idImovel);
         if(i != null) {
            if(estado.equals("em venda") || estado.equals("vendido") || estado.equals("reservado")) {
               // falta remover do portfolio e meter nos vendidos caso passe a vendido. e ver que acontece com reservados.
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

    public Set<String> getTopImoveis (int n){
      Set<String> lista = new HashSet<String>();
      Vendedor v = (Vendedor) this.utilizador;
      for(Imovel im : v.getPortfolio().values()){
         if(n < im.getConsultas().size()){
            lista.add(im.getId());
            }
         }
      return lista;
   }
   
   public Map <Imovel,Vendedor> getMapeamentoImoveis (){
        Map<Imovel,Vendedor> imoveis = new HashMap<Imovel,Vendedor>();
        for(Imovel im : this.imoveis.values()){
            for(Utilizador util : this.utilizadores.values()){
                if(util.getClass().getSimpleName().equals("Vendedor")){
                    Vendedor v = (Vendedor) util;
                    if(v.getPortfolio().containsValue(im)){
                        imoveis.put(im,v);
                        break;
                    }
                }
            }
        }
        return imoveis;
    }

   public List <Consulta> getConsultas() throws SemAutorizacaoException {
      ArrayList<Consulta> lista = new ArrayList<Consulta>();
      if(this.utilizador.getClass().getSimpleName().equals("Vendedor")) {
         
      }
      else throw new SemAutorizacaoException("Apenas Vendedores estão autorizados a efectuar esta operação.");
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

    /**
    * Define um imovel como favorito sendo assim adicionado a lista de favoritos de um Comprador.
    * @param idImovel
    */
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


    /**
    * Apresenta os imoveis favoritos ordenados por preço.
    * @return
    */
    public TreeSet<Imovel> getFavoritos() throws SemAutorizacaoException {
        TreeSet<Imovel> lista = null;
        if(this.utilizador.getClass().getSimpleName().equals("Comprador")) {
                lista = new TreeSet<Imovel>(new ComparatorPreco());
                Comprador c = (Comprador) this.utilizador;
                for(Imovel im: c.getFavoritos().values()){
                    lista.add(im);
                }
        }
        else throw new SemAutorizacaoException("Apenas Compradores registados estão autorizados.");

        return lista;
    }
    
    
    //LEILAO
    public void iniciaLeilao ( Imovel im , int horas ) throws SemAutorizacaoException{
        /*nao sei se temos que verificar se o imovel existe*/
        if(this.utilizador.getClass().getSimpleName().equals("Vendedor")){
            this.leilao.iniciaLeilao(im,horas);
        }
        else throw new SemAutorizacaoException ("Apenas Vendedores.");/*ou será para ver se so podem ter vendedores a inicar??*/

    }
    
    public Comprador encerraLeilao (){
        String vencedor = this.leilao.encerraLeilao();
        return (Comprador)utilizadores.get(vencedor);
    }
}
