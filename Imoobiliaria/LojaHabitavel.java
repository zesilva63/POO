/**
 * Classe relativa a uma LojaHabitavel.
 *
 * @author Grupo 60
 */
public class LojaHabitavel extends Imovel {

   // VARIAVEIS DE INSTÂNCIA

    private double area;
    private boolean wc;
    private String tipo_Negocio;
    private int numero;
    private Apartamento apartamento;


    // CONSTRUTORES

   /**
    * Construtor vazio de uma LojaHabitavel
    */
    public LojaHabitavel(){
        super();
        this.area = 0;
        this.wc = false;
        this.tipo_Negocio = "n/a";
        this.numero = 0;
        this.apartamento = new Apartamento();
    }

   /**
     * Construtor por cópia de uma LojaHabitavel.
     * @param c
   */
    public LojaHabitavel(LojaHabitavel c) {
        super(c);
        this.area = c.getArea();
        this.wc = c.getWC();
        this.tipo_Negocio = c.getTipo_Negocio();
        this.numero = c.getNumero();
        this.apartamento = new Apartamento(c.getApartamento().clone());
    }

   /**
     * Construtor por parametro de uma LojaHabitavel.
     * @param area
     * @param wc
     * @param tipo_negocio
     * @param numero
   */
   public LojaHabitavel(String rua, double preco, double preco_min, double area, boolean wc, String tipo_negocio,int numero,
   String tipo, double area, int quartos, int casa_banho, int numero, int andar, boolean garagem) {
       super(rua,preco,preco_min);
       this.area = area;
       this.wc = wc;
       this.tipo_Negocio = tipo_negocio;
       this.numero = numero;
       this.apartamento = new Apartamento(rua, preco, preco_min, tipo, area, quartos, casa_banho, numero, andar, garagem);
    }


    // GETTERS E SETTERS

    /**
     * Obter a Area de uma LojaHabitavel.
     * @return
     */
    public double getArea(){
        return this.area;
    }

    /**
     * Define a Area de uma LojaHabitavel.
     * @param area
     */
    public void setArea(double area){
        this.area = area;
    }

    /**
     * Obter o valor da existẽncia de WC numa LojaHabitavel.
     * @return
     */
    public boolean getWC(){
        return this.wc;
    }

    /**
     * Define a existência ou não de WC numa LojaHabitavel.
     * @param wc
     */
    public void setWC(boolean wc){
        this.wc = wc;
    }

    /**
     * Obter o Tipo de Negócio de uma LojaHabitavel.
     * @return
     */
    public String getTipo_Negocio(){
        return this.tipo_Negocio;
    }

    /**
     * Define o Tipo de Negocio de uma LojaHabitavel.
     * @param tipo_negocio
     */
    public void setTipo_Negocio(String tipo_negocio){
        this.tipo_Negocio = tipo_negocio;
    }

    /**
     * Obter o número de uma LojaHabitavel.
     * @return
     */
    public int getNumero(){
        return this.numero;
    }

    /**
     * Define o numero de uma LojaHabitavel.
     * @param num
     */
    public void setNumero(int num){
        this.numero = num;
    }

    // CLONE

    /*
     * Devolve uma cópia desta instância LojaHabitavel.
     * @return
     */
    public LojaHabitavel clone(){
        return new LojaHabitavel(this);
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
        LojaHabitavel o = (LojaHabitavel) obj;
        return super.equals(o) && o.getArea() == this.area && o.getWC() == this.wc
               && o.getTipo_Negocio().equals(this.tipo_Negocio) && o.getNumero() == this.numero;
    }

    // TO STRING

    public String toString() {
        StringBuilder str;
        str = new StringBuilder();
        str.append(super.toString()).append("\n");
        str.append("Área: ");
        str.append(this.area);
        str.append("WC: ");
        str.append(this.wc);
        str.append("Tipo de negócio viável na LojaHabitavel: ");
        str.append(this.tipo_Negocio);
        str.append("Número da porta:");
        str.append(this.numero);
        return str.toString();
    }


}
