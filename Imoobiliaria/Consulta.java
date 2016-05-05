import java.util.GregorianCalendar;

/**
 * Implementação de uma Consulta
 *
 * @author Grupo 60
 */

import java.util.GregorianCalendar;

public class Consulta {

   // VARIAVEIS DE INSTANCIA
   private String email;
   private GregorianCalendar data;


   // CONSTRUTORES

   public Consulta() {
      email = " ";
      data = new GregorianCalendar();
   }

   public Consulta(Consulta c) {
      email = c.getEmail();
      data = c.getData();
   }

   public Consulta(String e, GregorianCalendar c) {
      this.email = e;
      this.data = new GregorianCalendar();
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


   public GregorianCalendar getData() {
      return this.data;
   }


}
