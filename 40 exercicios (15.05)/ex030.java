import java.util.ArrayList;
import java.util.Scanner;

public class ex030 {
   public static int encontrar_maior(ArrayList<Integer> numeros) {
      int maior = numeros.get(0);
      for (int i = 1; i < numeros.size(); i++)
         maior = numeros.get(i) > maior ? numeros.get(i) : maior;

      return maior;
   }
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      ArrayList<Integer> numeros = new ArrayList<>();
      Integer maior;

      for(Integer i = 0; i < 5; i++) {
         System.out.println("Digite um número: (" + (i + 1) + "-5)");
         Integer numero = leitor.nextInt();
         numeros.add(numero);
      }

      leitor.close();
      
      maior = encontrar_maior(numeros);
      System.out.println("O maior número é: " + maior);
   }
}
