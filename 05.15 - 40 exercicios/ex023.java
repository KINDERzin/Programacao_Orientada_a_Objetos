import java.util.ArrayList;
import java.util.Scanner;

public class ex023 {
   public static void main(String[] args) {
      ArrayList<Integer> numeros = new ArrayList<>();
      Scanner leitor = new Scanner(System.in);
      Integer numero;

      for(Integer i = 0; i < 5; i++) {
         System.out.println("Digite um número: (" + (i + 1) + "-5)");
         numero = leitor.nextInt();
         numeros.add(numero);
      }

      System.out.println("Números pares digitados: ");
      for (Integer n : numeros)
         if (n % 2 == 0)
            System.out.print(n + " ");
   }
}
