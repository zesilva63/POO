/**
 * Write a description of class Terreno here.
 * 
 * @author Grupo 60
 * @version (a version number or a date)
 */
public class Terreno extends Imovel {

    private String tipo;
    private float diametro_canalizacoes; /* milimetros */
    private float carga_eletrica;
    private boolean saneamento;
    
    /**
     * Construtor de um Terreno
     */
    public Terreno() {
        super();
        this.tipo = "n/a";
        this.diametro_canalizacoes = 0;
        this.carga_eletrica = 0;
        this.saneamento = false;
    }
    
    /**
     * Construtor por cópia.
     * @param c 
    */
    public Terreno(Terreno c) {
        super(c);
        this.tipo = c.getTipo();
        this.diametro_canalizacoes = c.getDiametroCanalizacoes();
        this.carga_eletrica = c.getCargaEletrica();
        this.saneamento = c.getSaneamento();
    }
    
    /**
     * Construtor por parametro
     * @param tipo
     * @param diametro_canalizacoes
     * @param carga_eletrica
     * @param saneamento 
     */
    public Terreno(String rua, double preco, double preco_min, String tipo, float diametro_canalizacoes, float carga_eletrica, boolean saneamento) {
        super(rua,preco,preco_min);
        this.tipo = tipo;
        this.diametro_canalizacoes = diametro_canalizacoes;
        this.carga_eletrica = carga_eletrica;
        this.saneamento = saneamento;
    }

    public String getTipo(){
        return this.tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public float getDiametroCanalizacoes(){
        return this.diametro_canalizacoes;
    }
    
    public void setDiametroCanalizacoes(float diametro_canalizacoes){
        this.diametro_canalizacoes = diametro_canalizacoes;
    }
    
    public float getCargaEletrica(){
        return this.carga_eletrica;
    }
    
    public void setCargaEletrica(float carga_eletrica){
        this.carga_eletrica = carga_eletrica;
    }
    
    public boolean getSaneamento(){
        return this.saneamento;
    }
    
    public void setSaneamento(boolean saneamento){
        this.saneamento = saneamento;
    }
    
    public Terreno clone(){
        return new Terreno(this);
    }
    
}
