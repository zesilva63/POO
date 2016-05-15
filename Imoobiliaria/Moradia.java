/**
 * Classe relativa a uma Moradia.
 *
 * @author Grupo 60
 */

import java.util.List;
import java.util.ArrayList;

public class Moradia extends Imovel implements Habitavel {

    // VARIAVEIS DE INSTANCIA

    private String tipo;
    private double area;
    private double area_Coberta;
    private double area_Terreno;
    private int quartos;
    private int casas_Banho;
    private int numero;


    // CONSTRUTORES

    /**
    * Construtor de uma Moradia
    */
    public Moradia() {
        super();
        this.tipo = "n/a";
        this.area = 0;
        this.area_Coberta = 0;
        this.area_Terreno = 0;
        this.quartos = 0;
        this.casas_Banho = 0;
        this.numero = 0;
    }

    /**
     * Construtor por cópia.
     * @param c
     */
    public Moradia(Moradia c) {
        super(c);
        this.tipo = c.getTipo();
        this.area = c.getArea();
        this.area_Coberta = c.getAreaCoberta();
        this.area_Terreno = c.getAreaTerreno();
        this.quartos = c.getQuartos();
        this.casas_Banho = c.getCasasBanho();
        this.numero = c.getNumero();
    }

    /**
     * Construtor por parametro
     * @param tipo
     * @param area
     * @param area_Coberta
     * @param area_Terreno
     * @param quartos
     * @param casas_Banho
     * @param numero
     */
    public Moradia(String codigo, String rua, double preco, double preco_min, String estado, ArrayList<Consulta> consultas, String tipo, double area, double area_Coberta, double area_Terreno, int quartos, int casas_Banho, int numero ) {
        super(codigo,rua,preco,preco_min,estado,consultas);
        this.tipo = tipo;
        this.area = area;
        this.area_Coberta = area_Coberta;
        this.area_Terreno = area_Terreno;
        this.quartos = quartos;
        this.casas_Banho = casas_Banho;
        this.numero = numero;
    }

    // GETTERS E SETTERS

    /**
     * Obter o Tipo de uma Moradia.
     * @return
     */
    public String getTipo(){
        return this.tipo;
    }

    /**
     * Define o Tipo de uma Moradia.
     * @param tipo
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    /**
     * Obter a Area de uma Moradia.
     * @return
     */
    public double getArea(){
        return this.area;
    }

    /**
     * Define a Area de uma Moradia.
     * @param area
     */
    public void setArea(double area){
        this.area = area;
    }

    /**
     * Obter a Area Coberta de uma Moradia.
     * @return
     */
    public double getAreaCoberta(){
        return this.area_Coberta;
    }

    /**
     * Define a Area Coberta de uma Moradia.
     * @param area_coberta
     */
    public void setAreaCoberta(double area_coberta){
        this.area_Coberta = area_coberta;
    }

    /**
     * Obter a Area do Terreno de uma Moradia.
     * @return
     */
    public double getAreaTerreno(){
        return this.area_Terreno;
    }

    /**
     * Define a Area do Terreno de uma Moradia.
     * @param area_terreno
     */
    public void setAreaTerreno(double area_terreno){
        this.area_Terreno = area_terreno;
    }

    /**
     * Obter o número de Quartos de uma Moradia.
     * @return
     */
    public int getQuartos(){
        return this.quartos;
    }

    /**
     * Define o numero de Quartos de uma Moradia.
     * @param quartos
     */
    public void setQuartos(int quartos){
        this.quartos = quartos;
    }

    /**
     * Obter o numero de Casas de Banho de uma Moradia.
     * @return
     */
    public int getCasasBanho(){
        return this.casas_Banho;
    }

    /**
     * Define o numero de Casas de Banho de uma Moradia.
     * @param casas_banho
     */
    public void setCasasBanho(int casas_banho){
        this.casas_Banho = casas_banho;
    }

    /**
     * Obter o numero de uma Moradia.
     * @return
     */
    public int getNumero(){
        return this.numero;
    }

    /**
     * Define o numero de uma Moradia.
     * @param num
     */
    public void setNumero(int num){
        this.numero = num;
    }


    // CLONE

    /*
     * Devolve uma cópia desta instância Moradia.
     * @return
     */
    public Moradia clone(){
        return new Moradia(this);
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
        Moradia o = (Moradia) obj;
        return super.equals(o) && o.getTipo().equals(this.tipo) && o.getArea() == this.area
               && o.getAreaCoberta() == this.area_Coberta && o.getAreaTerreno() == this.area_Terreno
               && o.getQuartos() == this.quartos && o.getCasasBanho() == this.casas_Banho
               && o.getNumero() == this.numero;
    }


    // TO STRING

    public String toString() {
      StringBuilder str;
      str = new StringBuilder();
      str.append(super.toString());
      str.append("Tipo: Moradia\n");
      str.append("Tipo de Moradia: ");
      str.append(this.tipo+"\n");
      str.append("Área: ");
      str.append(this.area+"\n");
      str.append("Área Coberta: ");
      str.append(this.area_Coberta+"\n");
      str.append("Área do Terreno: ");
      str.append(this.area_Terreno+"\n");
      str.append("Número de Quartos: ");
      str.append(this.quartos+"\n");
      str.append("Número de Casas de Banho: ");
      str.append(this.casas_Banho+"\n");
      str.append("Número da porta: ");
      str.append(this.numero+"\n");
      str.append("********************************\n");
      return str.toString();
   }

}
