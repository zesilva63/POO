/**
 * Abstract class Utilizador - Classe relativa á implementação abstrata de um utilizador com a informação comum a todos eles.
 * 
 * @author Grupo 60
 * @version (version number or date here)
 */



public abstract class Utilizador {
    
    // instance variables
    private String Email;
    private String Nome;
    private String Password;
    private String Morada;
    private String Data_Nascimento;
    
    /**
     * Cria uma instância de um Utilizador
     */
    public Utilizador() {
        this.Email = "n/a";
        this.Nome = "n/a";
        this.Password = "n/a";
        this.Morada = "n/a";
        this.Data_Nascimento = "n/a";
    }

    /**
     * Construtor por cópia.
     * @param c 
     */
    public Utilizador(Utilizador c) {
        this.Email = c.getEmail();
        this.Nome = c.getNome();
        this.Password = c.getPassword();
        this.Morada = c.getMorada();
        this.Data_Nascimento = c.getData_Nascimento();
    }

    /**
     * Construtor por parametro
     * @param email
     * @param nome
     * @param password
     * @param morada
     * @param data_nascimento
     */
    public Utilizador(String email, String nome, String password, String morada, String data_nascimento) {
        this.Email = email;
        this.Nome = nome;
        this.Password = password;
        this.Morada = morada;
        this.Data_Nascimento = data_nascimento;
    }

    /**
     * Obter o Email de um Utilizador.
     * @return 
     */
    public String getEmail() {
        return this.Email;
    }
    
    
    /**
     * Define o Email de um Utilizador
     * @param email
     */
    public void setEmail(String email) {
        this.Email = email;
    }
    
    
    /**
     * Obter o Nome de um Utilizador.
     * @return 
     */
    public String getNome() {
        return this.Nome;
    }
    
    
    /**
     * Define o Nome de um Utilizador
     * @param nome
     */
    public void setNome(String nome) {
        this.Nome = nome;
    }
    
    
    /**
     * Obter a Password de um Utilizador.
     * @return 
     */
    public String getPassword() {
        return this.Password;
    }
    
    
    /**
     * Define a Password de um Utilizador
     * @param password
     */
    public void setPassword(String password) {
        this.Password = password;
    }
    
    
    /**
     * Obter a Morada de um Utilizador.
     * @return 
     */
    public String getMorada() {
        return this.Morada;
    }
    
    
    /**
     * Define a Morada de um Utilizador
     * @param morada
     */
    public void setMorada(String morada) {
        this.Morada = morada;
    }
    
    
    /**
     * Obter a Data de Nascimento de um Utilizador.
     * @return 
     */
    public String getData_Nascimento() {
        return this.Data_Nascimento;
    }
    
    
    /**
     * Define a Data de Nascimento de um Utilizador
     * @param data
     */
    public void setData_Nascimento(String data) {
        this.Data_Nascimento = data;
    }
    
}