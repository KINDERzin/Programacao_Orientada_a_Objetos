
import java.util.Scanner;

public class ex028 {

   static boolean eh_Par(int n) {
      return n % 2 == 0;
   }
   
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      Integer numero;

      System.out.println("Digite um número: ");
      numero = leitor.nextInt();
      
      leitor.close();

      if (eh_Par(numero))
         System.out.println(numero + " é par.");
      else 
         System.out.println(numero + " é ímpar.");
   }
}
