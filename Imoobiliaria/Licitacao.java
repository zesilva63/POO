import java.io.Serializable;

public class Licitacao implements Serializable
{
    private double minutos;
    private double limite;
    private double incremento;
    private long tempo;
    private String licitador;
    
    public Licitacao(String licitador, double limite, double incremento,double minutos){
        this.minutos=minutos;
        this.limite=limite;
        this.incremento=incremento;
        this.licitador=licitador;
    }
    
    public Licitacao(Licitacao l){
        this.minutos=l.getMinutos();
        this.limite=l.getLimite();
        this.incremento=l.getIncremento();
        this.licitador=l.getLicitador();
    }
    
    public long getTempo(){
        return this.tempo;
    }
    
    public void setTempo(long tempo){
        this.tempo=tempo;
    }
    
    public double getMinutos(){
        return this.minutos;
    }
    
    public double getLimite(){
        return this.limite;
    }
    
    public double getIncremento(){
        return this.incremento;
    }
    
    public String getLicitador(){
        return this.licitador;
    }
    
    public Licitacao clone (){
        return new Licitacao(this);
    }
    
    public boolean equals(Object obj){
      if(this == obj)
        return true;
      if ((obj==null) || (this.getClass() != obj.getClass()))
        return false;
      Licitacao l = (Licitacao) obj;
        return this.minutos==l.getMinutos() && this.limite==l.getLimite() && this.incremento==l.getIncremento() && this.licitador==l.getLicitador(); 
    }
}
