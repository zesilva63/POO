import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.GregorianCalendar;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;


public abstract class Imovel implements Serializable {

    // VARIAVEIS DE INSTÂNCIA

    /* Codigo de um Imovel */
    private String id;
    /* Define a rua onde se encontra um Imovel */
    private String rua;
    /* Define o Preço de um Imovel */
    private double preco;
    /* Define o preço minimo de um Imovel, apenas visivel ao vendedor */
    private double preco_Minimo;
    /* Define se um Imovel está "em venda", "vendido" ou "reservado" */
    private String estado;
    /* Lista com as Consultas de cada Imovel */
    private List<Consulta> consultas;

   // CONSTRUTORES

    /**
     * Construtor vazio de um Imovel
     */
    public Imovel() {
        this.id = "n/a";
        this.rua = "n/a";
        this.preco = 0;
        this.preco_Minimo = 0;
        this.estado = "em venda";
        this.consultas = new ArrayList<Consulta>();
    }

    /**
     * Construtor por cópia de um Imovel.
     * @param i
     */
    public Imovel(Imovel i) {
        this.id = i.getId();
        this.rua = i.getRua();
        this.preco = i.getPreco();
        this.preco_Minimo = i.getPreco_Minimo();
        this.estado = i.getEstado();
        this.consultas = new ArrayList<Consulta>();
        Iterator<Consulta> it = i.consultas.iterator();
        while(it.hasNext()) {
          Consulta consult = it.next();
          this.consultas.add(consult.clone());
        }
    }

    /**
     * Construtor por parametro
     * @param rua
     * @param preco
     * @param preco_min
     * @param estado
     * @param cons
     */
    public Imovel(String idImovel, String rua, double preco, double preco_min, String estado, ArrayList<Consulta> cons) {
        this.id = idImovel;
        this.rua = rua;
        this.preco = preco;
        this.preco_Minimo = preco_min;
        this.estado = estado;
        this.consultas = new ArrayList<Consulta>();
        Iterator<Consulta> it;
        if(cons!=null){
            it = cons.iterator();
            while(it.hasNext()) {
                Consulta consult = it.next();
                this.consultas.add(consult.clone());
            }
        }
    }


    // GETTERS E SETTERS

    /**
     * Obter o ID de um Imovel.
     * @return
     */
    public String getId() {
        return this.id;
    }

    /**
     * Define o ID de um Imovel
     * @param idImovel
     */
    public void setId(String idImovel) {
        this.id = idImovel;
    }


    /**
     * Obter a Rua de um Imovel.
     * @return
     */
    public String getRua() {
        return this.rua;
    }

    /**
     * Define a Rua de um Imovel
     * @param rua
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Obter o Preco de um Imovel.
     * @return
     */
    public double getPreco() {
        return this.preco;
    }

    /**
     * Define o Preco de um Imovel
     * @param preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Obter o Preco Minimo de um Imovel.
     * @return
     */
    public double getPreco_Minimo() {
        return this.preco_Minimo;
    }

    /**
     * Define o Preco Minimo de um Imovel
     * @param preco_min
     */
    public void setPreco_Minimo(double preco_min) {
        this.preco_Minimo = preco_min;
    }


    /**
     * Obter o Estado de um Imovel.
     * @return
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * Define o Estado de um Imovel
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obter as Consultas de um Imovel.
     * @return
     */
    public ArrayList<Consulta> getConsultas() {
         ArrayList<Consulta> novo = new ArrayList<Consulta>();
         Iterator<Consulta> it = this.consultas.iterator();
         while(it.hasNext()) {
           Consulta consult = it.next();
           novo.add(consult.clone());
         }
         return novo;
    }

    /**
    * Define as consultas de um Imovel.
    * @param lista
    */
    public void setConsultas(ArrayList<Consulta> lista) {
      Iterator<Consulta> it = lista.iterator();
      while(it.hasNext()) {
         Consulta consult = it.next();
         this.consultas.add(consult.clone());
      }
    }


    // METODOS
    /**
    * Adiciona uma consulta a lista de Consultas efetuadas a um Imovel.
    * @param email
    * @param data
    */
    public void adicionaConsulta(String email, GregorianCalendar data) {
       Consulta nova = new Consulta(email,data);
       this.consultas.add(nova);
    }


    // CLONE

    /*
     * Devolve uma cópia desta instância Imóvel.
     * @return
    */
     public abstract Imovel clone();


     // EQUALS

     /**
     * Compara a igualdade com outro objecto
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Imovel o = (Imovel) obj;
        return o.getRua().equals(this.rua) && o.getPreco() == this.preco
        && o.getPreco_Minimo() == this.preco_Minimo && o.estado.equals(this.estado);
    }


    // TO STRING

    public String toString() {
        StringBuilder str;
        str = new StringBuilder();
        str.append("************ Imóvel ************\n");
        str.append("ID: ");
        str.append(this.id+"\n");
        str.append("Rua: ");
        str.append(this.rua+"\n");
        str.append("Preço: ");
        str.append(this.preco+"\n");
        str.append("Estado: ");
        str.append(this.estado+"\n");
        return str.toString();
    }

}
