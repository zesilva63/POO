/**
 * Abstract class Imovel - write a description of the class here
 *
 * @author Grupo 60
 * @version (version number or date here)
 */
public abstract class Imovel {

    // VARIAVEIS DE INSTÂNCIA

    /* Define a rua onde se encontra um Imovel */
    private String Rua;
    /* Define o Preço de um Imovel */
    private double Preco;
    /* Define o preço minimo de um Imovel, apenas visivel ao vendedor */
    private double Preco_Minimo;


   // CONSTRUTORES

    /**
     * Construtor vazio de um Imovel
     */
    public Imovel() {
        this.Rua = "n/a";
        this.Preco = 0;
        this.Preco_Minimo = 0;
    }

    /**
     * Construtor por cópia de um Imovel.
     * @param c
     */
    public Imovel(Imovel i) {
        this.Rua = i.getRua();
        this.Preco = i.getPreco();
        this.Preco_Minimo = i.getPreco_Minimo();
    }

    /**
     * Construtor por parametro
     * @param rua
     * @param preco
     * @param preco_min
     */
    public Imovel(String rua, double preco, double preco_min) {
        this.Rua = rua;
        this.Preco = preco;
        this.Preco_Minimo = preco_min;
    }


    // GETTERS E SETTERS

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
        return o.getRua().equals(this.Rua) && o.getPreco() == this.Preco &&
                o.getPreco_Minimo() == this.Preco_Minimo;
    }

}
