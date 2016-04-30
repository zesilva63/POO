/**
 * Write a description of class Loja here.
 *
 * @author Grupo 60
 * @version (a version number or a date)
 */
public class Loja extends Imovel {

    private double area;
    private boolean wc;
    private String tipo_negocio;
    private int numero;
    /* falta ver habitacional, se tiver guardar informaçao do apartamento */


   /**
    * Construtor de uma Loja
    */
    public Loja(){
        super();
        this.area = 0;
        this.wc = false;
        this.tipo_negocio = "n/a";
        this.numero = 0;
    }

   /**
     * Construtor por cópia.
     * @param c
   */
    public Loja(Loja c) {
        super(c);
        this.area = c.getArea();
        this.wc = c.getWC();
        this.tipo_negocio = c.getTipo_Negocio();
        this.numero = c.getNumero();
    }

   /**
     * Construtor por parametro
     * @param area
     * @param wc
     * @param tipo_negocio
     * @param numero
   */

   public Loja(String rua, double preco, double preco_min, double area, boolean wc, String tipo_negocio,int numero){
       super(rua,preco,preco_min);
       this.area = area;
       this.wc = wc;
       this.tipo_negocio = tipo_negocio;
       this.numero = numero;
    }


    public double getArea(){
        return this.area;
    }


    public void setArea(double area){
        this.area = area;
    }


    public boolean getWC(){
        return this.wc;
    }


    public void setWC(boolean wc){
        this.wc = wc;
    }


    public String getTipo_Negocio(){
        return this.tipo_negocio;
    }


    public void setTipo_Negocio(String tipo_negocio){
        this.tipo_negocio = tipo_negocio;
    }


    public int getNumero(){
        return this.numero;
    }


    public void setNumero(int numero){
        this.numero = numero;
    }


    /*
     * Devolve uma cópia desta instância Loja.
     * @return
     */
    public Loja clone(){
        return new Loja(this);
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
        Loja o = (Loja) obj;
        return super.equals(o) && o.getArea() == this.area && o.getWC() == this.wc
               && o.getTipo_Negocio().equals(this.tipo_negocio) && o.getNumero() == this.numero;
    }

}
