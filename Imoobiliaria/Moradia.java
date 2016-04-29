/**
 * Write a description of class Moradia here.
 * 
 * @author Grupo 60 
 * @version (a version number or a date)
 */
public class Moradia extends Imovel {

    /* Variaveis de instância */
    private String tipo;
    private double area;
    private double area_Coberta;
    private double area_Terreno;
    private int quartos;
    private int casas_Banho;
    private int numero;

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
    public Moradia(String rua, double preco, double preco_min, String tipo, double area, double area_Coberta, double area_Terreno, int quartos, int casas_Banho, int numero ) {
        super(rua,preco,preco_min);
        this.tipo = tipo;
        this.area = area;
        this.area_Coberta = area_Coberta;
        this.area_Terreno = area_Terreno;
        this.quartos = quartos;
        this.casas_Banho = casas_Banho;
        this.numero = numero;
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
    
    public double getAreaCoberta(){
        return this.area_Coberta;
    }
    
    public void setAreaCoberta(double area_Coberta){
        this.area_Coberta = area_Coberta;
    }
    
    public double getAreaTerreno(){
        return this.area_Terreno;
    }
    
    public void setAreaTerreno(double area_Terreno){
        this.area_Terreno = area_Terreno;
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
    
    public void setCasasBanho(int casas_Banho){
        this.casas_Banho = casas_Banho;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public Moradia clone(){
        return new Moradia(this);
    }
    
}
