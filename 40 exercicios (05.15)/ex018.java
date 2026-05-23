
import java.util.Scanner;

public class ex018 {
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      String senha = "java1234";
      String tentativa = "";

      while(!tentativa.equals(senha)) {
         System.out.println("Digite a senha: ");
         tentativa = leitor.nextLine();

         if(!tentativa.equals(senha))
            System.out.println("Senha incorreta, tente novamente.");
      }
      leitor.close();
      System.out.println("Senha correta, acesso permitido.");
   }
}
