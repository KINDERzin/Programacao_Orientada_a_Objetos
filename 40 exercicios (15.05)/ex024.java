import java.util.ArrayList;
import java.util.Scanner;

public class ex024 {
   public static void main(String[] args) {
      ArrayList<Integer> numeros = new ArrayList<>();
      Scanner leitor = new Scanner(System.in);
      Integer numero;

      for(Integer i = 0; i < 10; i++) {
         System.out.println("Digite um número: (" + (i + 1) + "-10)");
         numero = leitor.nextInt();
         numeros.add(numero);
      }

      Integer maior = null;
      Integer menor = null;

      for(Integer n : numeros) {
         maior = maior == null || n > maior ? n : maior;
         menor = menor == null || n < menor ? n : menor;
      }

      System.out.println("Maior: " + maior);
      System.out.println("Menor: " + menor);
   }
}
