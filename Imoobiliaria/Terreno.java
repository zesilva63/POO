/**
 * Classe que designa um Terreno.
 *
 * @author Grupo 60
 */

import java.util.List;
import java.util.ArrayList;

public class Terreno extends Imovel implements Habitavel {

    // Variaveis de instância
    private int area;
    private String tipo;
    private float diametro_canalizacoes; /* milimetros */
    private float carga_eletrica;
    private boolean saneamento;


    /**
     * Construtor de um Terreno
     */
    public Terreno() {
        super();
        this.tipo = "n/a";
        this.diametro_canalizacoes = 0;
        this.carga_eletrica = 0;
        this.saneamento = false;
    }


    /**
     * Construtor por cópia.
     * @param c
    */
    public Terreno(Terreno c) {
        super(c);
        this.tipo = c.getTipo();
        this.diametro_canalizacoes = c.getDiametroCanalizacoes();
        this.carga_eletrica = c.getCargaEletrica();
        this.saneamento = c.getSaneamento();
    }


    /**
     * Construtor por parametro
     * @param tipo
     * @param diametro_canalizacoes
     * @param carga_eletrica
     * @param saneamento
     */
    public Terreno(String codigo, String rua, double preco, double preco_min, String estado, ArrayList<Consulta> consultas, String tipo, float diametro_canalizacoes, float carga_eletrica, boolean saneamento) {
        super(codigo,rua,preco,preco_min,estado,consultas);
        this.tipo = tipo;
        this.diametro_canalizacoes = diametro_canalizacoes;
        this.carga_eletrica = carga_eletrica;
        this.saneamento = saneamento;
    }


    /**
     * Obter a Area de um Terreno.
     * @return
     */
    public int getArea(){
        return this.area;
    }

    /**
    * Define a Aréa de um Terreno
    * @param a
    */
    public void setArea(int a){
        this.area = a;
    }

    /**
     * Obter o tipo de um Terreno, se para contrução de habitações ou de armazens.
     * @return
     */
    public String getTipo(){
        return this.tipo;
    }

    /**
    * Define o Tipo de um Terreno
    * @param t
    */
    public void setTipo(String t){
        this.tipo = t;
    }

    /**
     * Obter Diametro das Canalizações de um Terreno.
     * @return
     */
    public float getDiametroCanalizacoes(){
        return this.diametro_canalizacoes;
    }

    /**
    * Define o Diametro das Canalizações de um Terreno
    * @param diametro
    */
    public void setDiametroCanalizacoes(float diametro){
        this.diametro_canalizacoes = diametro;
    }

    /**
     * Obter a Carga Eletrica possivel de um Terreno se o mesmo a tiver.
     * @return
     */
    public float getCargaEletrica(){
        return this.carga_eletrica;
    }

    /**
    * Define a Carga Eletrica permitida de um Terreno.
    * @param carga
    */
    public void setCargaEletrica(float carga){
        this.carga_eletrica = carga;
    }

    /**
     * Obter o valor de existencia de Saneamento num Terreno.
     * @return
     */
    public boolean getSaneamento(){
        return this.saneamento;
    }

    /**
    * Define a existência de Saneamento num Terreno
    * @param valor
    */
    public void setSaneamento(boolean valor){
        this.saneamento = valor;
    }


    /*
     * Devolve uma cópia desta instância Terreno.
     * @return
     */
    public Terreno clone(){
        return new Terreno(this);
    }


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
        Terreno o = (Terreno) obj;
        return super.equals(o) && o.getArea() == this.area && o.getTipo().equals(this.tipo)
        && o.getDiametroCanalizacoes() == this.diametro_canalizacoes
        && o.getCargaEletrica() == this.carga_eletrica && o.getSaneamento() == this.saneamento;
    }

    // TO STRING

    public String toString() {
      StringBuilder str;
      str = new StringBuilder();
      str.append(super.toString()).append("\n");
      str.append("Tipo de Terreno: ");
      str.append(this.tipo+"\n");
      str.append("Área: ");
      str.append(this.area+"\n");
      str.append("Diametro das Canalizações: ");
      str.append(this.diametro_canalizacoes+"\n");
      str.append("Capacidade Elétrica: ");
      str.append(this.carga_eletrica+"\n");
      str.append("Saneamento: ");
      str.append(this.saneamento+"\n");
      return str.toString();
   }

}
