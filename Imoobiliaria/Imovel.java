/**
 * Abstract class Imovel - write a description of the class here
 *
 * @author Grupo 60
 * @version (version number or date here)
 */
public abstract class Imovel {

    // VARIAVEIS DE INSTÂNCIA

    /* Define a rua onde se encontra um Imovel */
    private String rua;
    /* Define o Preço de um Imovel */
    private double preco;
    /* Define o preço minimo de um Imovel, apenas visivel ao vendedor */
    private double preco_Minimo;


   // CONSTRUTORES

    /**
     * Construtor vazio de um Imovel
     */
    public Imovel() {
        this.rua = "n/a";
        this.preco = 0;
        this.preco_Minimo = 0;
    }

    /**
     * Construtor por cópia de um Imovel.
     * @param c
     */
    public Imovel(Imovel i) {
        this.rua = i.getRua();
        this.preco = i.getPreco();
        this.preco_Minimo = i.getPreco_Minimo();
    }

    /**
     * Construtor por parametro
     * @param rua
     * @param preco
     * @param preco_min
     */
    public Imovel(String rua, double preco, double preco_min) {
        this.rua = rua;
        this.preco = preco;
        this.preco_Minimo = preco_min;
    }


    // GETTERS E SETTERS

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
        return o.getRua().equals(this.rua) && o.getPreco() == this.preco &&
                o.getPreco_Minimo() == this.preco_Minimo;
    }


    // TO STRING

    public String toString() {
        StringBuilder str;
        str = new StringBuilder();
        str.append("Rua: ");
        str.append(this.rua);
        str.append("Preço: ");
        str.append(this.preco);
        str.append("Preço Minimo: ");
        str.append(this.preco_Minimo);
        return str.toString();
    }

}
