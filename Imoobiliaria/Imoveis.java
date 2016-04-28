
/**
 * Abstract class Imoveis - write a description of the class here
 * 
 * @author Grupo 60
 * @version (version number or date here)
 */
public abstract class Imoveis {
    
    // instance variables
    
    private String Rua;
    private double Preco;
    private double Preco_Minimo;

    
    /**
     * Cria uma instância de um Imovel
     */
    public Imoveis() {
        this.Rua = "n/a";
        this.Preco = 0;
        this.Preco_Minimo = 0;
    }

    
    /**
     * Construtor por cópia.
     * @param c 
     */
    public Imoveis(Imoveis c) {
        this.Rua = c.getRua();
        this.Preco = c.getPreco();
        this.Preco_Minimo = c.getPreco_Minimo();
    }

    
    /**
     * Construtor por parametro
     * @param rua
     * @param preco
     * @param preco_min
     */
    public Imoveis(String rua, double preco, double preco_min) {
        this.Rua = rua;
        this.Preco = preco;
        this.Preco_Minimo = preco_min;
    }
    
    
    /**
     * Obter a Rua de um Imovel.
     * @return 
     */
    public String getRua() {
        return this.Rua;
    }
    
    
    /**
     * Define a Rua de um Imovel
     * @param rua
     */
    public void setRua(String rua) {
        this.Rua = rua;
    }
    
    
    /**
     * Obter o Preco de um Imovel.
     * @return 
     */
    public double getPreco() {
        return this.Preco;
    }

    /**
     * Define o Preco de um Imovel
     * @param preco
     */
    public void setPreco(double preco) {
        this.Preco = preco;
    }
    
    
    /**
     * Obter o Preco Minimo de um Imovel.
     * @return 
     */
    public double getPreco_Minimo() {
        return this.Preco_Minimo;
    }
    
    
    /**
     * Define o Preco Minimo de um Imovel
     * @param preco_min
     */
    public void setPreco_Minimo(double preco_min) {
        this.Preco_Minimo = preco_min;
    }
    
}
