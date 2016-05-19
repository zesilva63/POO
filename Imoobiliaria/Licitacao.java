import java.io.Serializable;

public class Licitacao implements Serializable
{
    private double minutos;
    private double limite;
    private double incremento;
    private long tempo;
    private String licitador;
    
    /**
     * Construtor por parametro
     * @param licitador
     * @param limite
     * @param incremento
     * @param minutos
     */
    
    public Licitacao(String licitador, double limite, double incremento,double minutos){
        this.minutos=minutos;
        this.limite=limite;
        this.incremento=incremento;
        this.licitador=licitador;
    }
    
    /**
     * Construtor por cópia
     * @param l
     */
    public Licitacao(Licitacao l){
        this.minutos=l.getMinutos();
        this.limite=l.getLimite();
        this.incremento=l.getIncremento();
        this.licitador=l.getLicitador();
    }
    
    /**
     * Devolver o último tempo da licitação.
     * @return
     */
    public long getTempo(){
        return this.tempo;
    }
    
    
    /**
     * Definir o útlimo tempo da licitação.
     * @param
     */
    public void setTempo(long tempo){
        this.tempo=tempo;
    }
    
    /**
     * Devolver os Minutos da licitação.
     * @return
     */
    public double getMinutos(){
        return this.minutos;
    }
    
    /**
     * Definir os minutos da licitação.
     * @param
     */
    public void setMinutos(long minutos){
        this.minutos=minutos;
    }
    
    /**
     * Devolver o limite da licitação.
     * @return
     */
    public double getLimite(){
        return this.limite;
    }
    
    /**
     * Definir o limite da licitação.
     * @param limite
     */
    public void setLimite(double limite){
        this.limite = limite;
    }
    
    /**
     * Devolver o incremento da licitação.
     * @return 
     */
    public double getIncremento(){
        return this.incremento;
    }
    
    /**
     * Definir o incremento da licitação.
     * @param incremento
     */
    public void setIncremento(double incremento){
        this.incremento = incremento;
    }
    
    /**
     * Devolver o licitador da liciatação.
     * @return
     */
    public String getLicitador(){
        return this.licitador;
    }
    
    /**
     * Definir o licitador.
     */
    public void setLicitador(String licitador){
        this.licitador = licitador;
    }
    
    /**
     * Fazer um clone da Licitação.
     * @return
     */
    public Licitacao clone (){
        return new Licitacao(this);
    }
    
    /**
     * Compara a igualdade com outro objecto
     * @param obj
     * @return
     */
    public boolean equals(Object obj){
      if(this == obj)
        return true;
      if ((obj==null) || (this.getClass() != obj.getClass()))
        return false;
      Licitacao l = (Licitacao) obj;
        return this.minutos==l.getMinutos() && this.limite==l.getLimite() && this.incremento==l.getIncremento() && this.licitador==l.getLicitador(); 
    }
}
