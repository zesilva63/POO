/**
 * Abstract class Utilizador - Classe relativa á implementação abstrata de um utilizador com a informação comum a todos eles.
 *
 * @author Grupo 60
 */

public abstract class Utilizador {

    // Variaveis de instância
    private String email;
    private String nome;
    private String password;
    private String morada;
    private String data_Nascimento;

    /**
     * Cria uma instância de um Utilizador.
     */
    public Utilizador() {
        this.email = "n/a";
        this.nome = "n/a";
        this.password = "n/a";
        this.morada = "n/a";
        this.data_Nascimento = "n/a";
    }

    /**
     * Construtor por cópia.
     * @param c
     */
    public Utilizador(Utilizador c) {
        this.email = c.getEmail();
        this.nome = c.getNome();
        this.password = c.getPassword();
        this.morada = c.getMorada();
        this.data_Nascimento = c.getData_Nascimento();
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
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.morada = morada;
        this.data_Nascimento = data_nascimento;
    }


    /**
     * Obter o Email de um Utilizador.
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Define o Email de um Utilizador
     * @param n_email
     */
    public void setEmail(String n_email) {
        this.email = n_email;
    }

    /**
     * Obter o Nome de um Utilizador.
     * @return
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Define o Nome de um Utilizador
     * @param n_nome
     */
    public void setNome(String n_nome) {
        this.nome = n_nome;
    }

    /**
     * Obter a Password de um Utilizador.
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Define a Password de um Utilizador
     * @param pass
     */
    public void setPassword(String pass) {
        this.password = pass;
    }

    /**
     * Obter a Morada de um Utilizador.
     * @return
     */
    public String getMorada() {
        return this.morada;
    }

    /**
     * Define a Morada de um Utilizador
     * @param n_morada
     */
    public void setMorada(String n_morada) {
        this.morada = n_morada;
    }

    /**
     * Obter a Data de Nascimento de um Utilizador.
     * @return
     */
    public String getData_Nascimento() {
        return this.data_Nascimento;
    }

    /**
     * Define a Data de Nascimento de um Utilizador
     * @param data
     */
    public void setData_Nascimento(String data) {
        this.data_Nascimento = data;
    }

    /*
     * Devolve uma cópia desta instância
     * @return
     */
     public abstract Utilizador clone();

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
        Utilizador o = (Utilizador) obj;
        return o.getEmail().equals(this.email) && o.getNome().equals(this.nome) && o.getPassword().equals(this.password)
               && o.getMorada().equals(this.morada) && o.getData_Nascimento().equals(this.data_Nascimento);
    }

    // TO STRING

    public String toString() {
        StringBuilder str;
        str = new StringBuilder();
        str.append("    Email: ");
        str.append(this.email+"\n");
        str.append("    Nome: ");
        str.append(this.nome+"\n");
        return str.toString();
    }

}
