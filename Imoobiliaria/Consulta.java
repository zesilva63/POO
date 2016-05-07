import java.util.GregorianCalendar;

/**
 * Implementação de uma Consulta a um Imovel por parte de um Utilizador.
 *
 * @author Grupo 60
 */

import java.util.GregorianCalendar;

public class Consulta {

   // VARIAVEIS DE INSTANCIA
   private String email;
   private GregorianCalendar data;


   // CONSTRUTORES

   /**
   * Construtor vazio de uma Consulta.
   */
   public Consulta() {
      email = " ";
      data = new GregorianCalendar();
   }

   /**
   * Construtor de uma Consulta por cópia.
   * @param c
   */
   public Consulta(Consulta c) {
      email = c.getEmail();
      data = (GregorianCalendar) c.getData().clone();
   }

   /**
   * Construtor por parametros.
   * @param e
   * @param c
   */
   public Consulta(String e, GregorianCalendar c) {
      this.email = e;
      this.data = (GregorianCalendar) c.clone();
   }


   //  GETTERS E SETTERS

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
   * Obter a data em que uma dada Consulta foi efetuada.
   * @return
   */
   public GregorianCalendar getData() {
      return this.data;
   }




}
