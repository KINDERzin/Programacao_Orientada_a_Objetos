
import java.util.Scanner;

public class ex016 {
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      Integer N;
      Integer soma = 0;

      System.out.println("Digite um número inteiro: ");
      N = leitor.nextInt();

      for (int i = 1; i <= N; i++)
         soma+=i;

      System.out.println("A soma dos números de 1 a " + N + " é: " + soma);
   }
}
