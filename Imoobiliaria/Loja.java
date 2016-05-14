/**
 * Classe relativa a uma Loja.
 *
 * @author Grupo 60
 */


import java.util.List;
import java.util.ArrayList;


public class Loja extends Imovel {

   // VARIAVEIS DE INSTÂNCIA

    private double area;
    private boolean wc;
    private String tipo_Negocio;
    private int numero;


    // CONSTRUTORES

   /**
    * Construtor vazio de uma Loja
    */
    public Loja(){
        super();
        this.area = 0;
        this.wc = false;
        this.tipo_Negocio = "n/a";
        this.numero = 0;
    }

   /**
     * Construtor por cópia de uma Loja.
     * @param c
   */
    public Loja(Loja c) {
        super(c);
        this.area = c.getArea();
        this.wc = c.getWC();
        this.tipo_Negocio = c.getTipo_Negocio();
        this.numero = c.getNumero();
    }

   /**
     * Construtor por parametro de uma Loja.
     * @param area
     * @param wc
     * @param tipo_negocio
     * @param numero
   */
   public Loja(String codigo, String rua, double preco, double preco_min, String estado, ArrayList<Consulta> consultas, double area, boolean wc, String tipo_negocio,int numero){
       super(codigo,rua,preco,preco_min,estado,consultas);
       this.area = area;
       this.wc = wc;
       this.tipo_Negocio = tipo_negocio;
       this.numero = numero;
    }


    // GETTERS E SETTERS

    /**
     * Obter a Area de uma Loja.
     * @return
     */
    public double getArea(){
        return this.area;
    }

    /**
     * Define a Area de uma Loja.
     * @param area
     */
    public void setArea(double area){
        this.area = area;
    }

    /**
     * Obter o valor da existẽncia de WC numa Loja.
     * @return
     */
    public boolean getWC(){
        return this.wc;
    }

    /**
     * Define a existência ou não de WC numa Loja.
     * @param wc
     */
    public void setWC(boolean wc){
        this.wc = wc;
    }

    /**
     * Obter o Tipo de Negócio de uma Loja.
     * @return
     */
    public String getTipo_Negocio(){
        return this.tipo_Negocio;
    }

    /**
     * Define o Tipo de Negocio de uma Loja.
     * @param tipo_negocio
     */
    public void setTipo_Negocio(String tipo_negocio){
        this.tipo_Negocio = tipo_negocio;
    }

    /**
     * Obter o número de uma Loja.
     * @return
     */
    public int getNumero(){
        return this.numero;
    }

    /**
     * Define o numero de uma Loja.
     * @param num
     */
    public void setNumero(int num){
        this.numero = num;
    }

    // CLONE

    /*
     * Devolve uma cópia desta instância Loja.
     * @return
     */
    public Loja clone(){
        return new Loja(this);
    }

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
        Loja o = (Loja) obj;
        return super.equals(o) && o.getArea() == this.area && o.getWC() == this.wc
               && o.getTipo_Negocio().equals(this.tipo_Negocio) && o.getNumero() == this.numero;
    }

    // TO STRING

    public String toString() {
        StringBuilder str;
        str = new StringBuilder();
        str.append(super.toString()).append("\n");
        str.append("Área: ");
        str.append(this.area+"\n");
        str.append("WC: ");
        str.append(this.wc+"\n");
        str.append("Tipo de negócio viável na loja: ");
        str.append(this.tipo_Negocio+"\n");
        str.append("Número da porta: ");
        str.append(this.numero+"\n");
        return str.toString();
    }


}
