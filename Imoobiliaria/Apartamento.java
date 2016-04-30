/**
 * Write a description of class Apartamento here.
 *
 * @author Grupo 60
 * @version (a version number or a date)
 */
public class Apartamento extends Imovel {

    private String tipo;
    private double area;
    private int quartos;
    private int casas_Banho;
    private int numero;
    private int andar;
    private boolean garagem;

    /**
     * Construtor de um Apartamento
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
     * Construtor por cópia.
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
     * Construtor por parametro
     * @param tipo
     * @param area
     * @param quartos
     * @param casas_Banho
     * @param numero
     * @param andar
     * @param garagem
     */
    public Apartamento(String rua, double preco, double preco_min, String tipo, double area, int quartos, int casas_Banho, int numero, int andar, boolean garagem) {
        super(rua,preco,preco_min);
        this.tipo = tipo;
        this.area = area;
        this.quartos = quartos;
        this.casas_Banho = casas_Banho;
        this.numero = numero;
        this.andar = andar;
        this.garagem = garagem;
    }


    public String getTipo(){
        return this.tipo;
    }


    public void setTipo(String tipo){
        this.tipo = tipo;
    }


    public double getArea(){
        return this.area;
    }


    public void setArea(double area){
        this.area = area;
    }


    public int getQuartos(){
        return this.quartos;
    }


    public void setQuartos(int quartos){
        this.quartos = quartos;
    }


    public int getCasasBanho(){
        return this.casas_Banho;
    }


    public void setCasasBanho(int casas_banho){
        this.casas_Banho = casas_Banho;
    }


    public int getNumero(){
        return this.numero;
    }


    public void setNumero(int numero){
        this.numero = numero;
    }


    public int getAndar(){
        return this.andar;
    }


    public void setAndar(int andar){
        this.andar = andar;
    }


    public boolean getGaragem(){
        return this.garagem;
    }


    public void setGaragem(boolean garagem){
        this.garagem = garagem;
    }


    /*
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

}
