/**
 * Classe relativa a um Apartamento.
 *
 * @author Grupo 60
 */

import java.util.List;
import java.util.ArrayList;

public class Apartamento extends Imovel implements Habitavel {

    // VARIAVEIS DE INSTÂNCIA
    private String tipo;
    private double area;
    private int quartos;
    private int casas_Banho;
    private int numero;
    private int andar;
    private boolean garagem;


    // CONSTRUTORES

    /**
     * Construtor vazio de um Apartamento.
     */
    public Apartamento() {
        super();
        this.tipo = "n/a";
        this.area = 0;
        this.quartos = 0;
        this.casas_Banho = 0;
        this.numero = 0;
        this.andar = 0;
        this.garagem = false;
    }

    /**
     * Construtor por cópia de um Apartamento.
     * @param c
     */
    public Apartamento(Apartamento c) {
        super(c);
        this.tipo = c.getTipo();
        this.area = c.getArea();
        this.quartos = c.getQuartos();
        this.casas_Banho = c.getCasasBanho();
        this.numero = c.getNumero();
        this.andar = c.getAndar();
        this.garagem = c.getGaragem();
    }

    /**
     * Construtor por parametro de um Apartamento.
     * @param codigo
     * @param tipo
     * @param area
     * @param quartos
     * @param casas_Banho
     * @param numero
     * @param andar
     * @param garagem
     */
    public Apartamento(String codigo, String rua, double preco, double preco_min, String estado, ArrayList<Consulta> consultas, String tipo, double area, int quartos, int casas_Banho, int numero, int andar, boolean garagem) {
        super(codigo, rua,preco,preco_min,estado,consultas);
        this.tipo = tipo;
        this.area = area;
        this.quartos = quartos;
        this.casas_Banho = casas_Banho;
        this.numero = numero;
        this.andar = andar;
        this.garagem = garagem;
    }

    /**
     * Obter o Tipo de um Apartamento.
     * @return
     */
    public String getTipo(){
        return this.tipo;
    }

    /**
     * Define o tipo de um Apartamento.
     * @param tipo
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    /**
     * Obter a Area de um Apartamento.
     * @return
     */
    public double getArea(){
        return this.area;
    }

    /**
     * Definir a Area de um Apartamento.
     * @param area
     */
    public void setArea(double area){
        this.area = area;
    }

    /**
     * Obter o numero de Quartos de um Apartamento.
     * @return
     */
    public int getQuartos(){
        return this.quartos;
    }

    /**
     * Definir o numero de Quartos de um Apartamento.
     * @param quartos
     */
    public void setQuartos(int quartos){
        this.quartos = quartos;
    }

    /**
     * Obter o numero de Casas de Banho de um Apartamento.
     * @return
     */
    public int getCasasBanho(){
        return this.casas_Banho;
    }

    /**
     * Definir o numero de Casas de Banho de um Apartamento.
     * @param casas_banho
     */
    public void setCasasBanho(int casas_banho){
        this.casas_Banho = casas_Banho;
    }

    /**
     * Obter o numero de um Apartamento.
     * @return
     */
    public int getNumero(){
        return this.numero;
    }

    /**
     * Definir o numero de um Apartamento.
     * @param tipo
     */
    public void setNumero(int numero){
        this.numero = numero;
    }

    /**
     * Obter o Andar de um Apartamento.
     * @return
     */
    public int getAndar(){
        return this.andar;
    }

    /**
     * Definir o Andar de um Apartamento.
     * @param andar
     */
    public void setAndar(int andar){
        this.andar = andar;
    }

    /**
     * Obter o valor referente á existência de Garagem num Apartamento.
     * @return
     */
    public boolean getGaragem(){
        return this.garagem;
    }

    /**
     * Definir a existencia de Garagem para um Apartamento.
     * @param tipo
     */
    public void setGaragem(boolean garagem){
        this.garagem = garagem;
    }


    /**
     * Devolve uma cópia desta instância Apartamento.
     * @return
    */
    public Apartamento clone(){
        return new Apartamento(this);
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
        Apartamento o = (Apartamento) obj;
        return super.equals(o) && o.getTipo().equals(this.tipo) && o.getArea() == this.area && o.getQuartos() == this.quartos
               && o.getCasasBanho() == this.casas_Banho && o.getNumero() == this.numero && o.getAndar() == this.andar &&
               o.getGaragem() == this.garagem;
    }


    // TO STRING

    public String toString() {
        StringBuilder str;
        str = new StringBuilder();
        str.append(super.toString());
        str.append("Tipo: Apartamento\n");
        str.append("Tipo de Apartamento: ");
        str.append(this.tipo+"\n");
        str.append("Área: ");
        str.append(this.area+"\n");
        str.append("Número de Quartos: ");
        str.append(this.quartos+"\n");
        str.append("Número de Casas de Banho: ");
        str.append(this.casas_Banho+"\n");
        str.append("Número da porta: ");
        str.append(this.numero+"\n");
        str.append("Andar: ");
        str.append(this.andar+"\n");
        str.append("Garagem: ");
        str.append(this.garagem+"\n");
        str.append("********************************\n");
        return str.toString();
    }

}
