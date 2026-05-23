import java.util.Scanner;

public class ex010 {
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      Integer numero;

      System.out.println("Digite um número: ");
      numero = leitor.nextInt();

      if (numero < 0)
         System.out.println("Número negativo");
      else if (numero == 0)
         System.out.println("Número zero");
      else
         System.out.println("Número positivo");

      leitor.close();
   }
}
