
import java.util.Scanner;

public class ex015 {
   public static void main(String[] args) throws InterruptedException {
      Scanner leitor = new Scanner(System.in);
      Integer N;

      System.out.println("Digite um número inteiro: ");
      N = leitor.nextInt();
      
      System.out.println("\nContando até " + N + ":");
      for (int i = 1; i <= N; i++) {
         System.out.print("\b" + i);
         Thread.sleep(900);
      }

      System.out.println("\nContagem finalizada!");

      leitor.close();
   }
}
