
public class Licitacao
{
    private double minutos;
    private double limite;
    private double incremento;
    private double valor;
    private String licitador;
    
    public Licitacao(String licitador, double limite, double incremento,double minutos){
        this.minutos=minutos;
        this.limite=limite;
        this.incremento=incremento;
        this.licitador=licitador;
        this.valor=incremento;/*Devia ser o preco minimo do imovel*/
    }
    
    public Licitacao(Licitacao l){
        this.minutos=l.getMinutos();
        this.limite=l.getLimite();
        this.incremento=l.getIncremento();
        this.licitador=l.getLicitador();
        this.valor=l.getValor();
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
    
    public double getValor(){
        return this.valor;
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
        return this.minutos==l.getMinutos() && this.limite==l.getLimite() && this.incremento==l.getIncremento() && this.licitador==l.getLicitador() && this.valor==l.getValor(); 
    }
}
