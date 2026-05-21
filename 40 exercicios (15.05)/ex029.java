import java.util.ArrayList;
import java.util.Scanner;

public class ex029 {
   public static double media(ArrayList<Double> numeros) {
      double soma = 0.0;

      for (Double numero : numeros) {
         soma += numero;
      }
      
      return soma / numeros.size();
      
   }
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      ArrayList<Double> numeros = new ArrayList<>();
      
      for(Integer i = 0; i < 5; i++) {
         System.out.println("Digite sua nota: (" + (i + 1) + "-5)");
         Double numero = leitor.nextDouble();
         numeros.add(numero);
      }

      leitor.close();
      
      double resultado = media(numeros);
      System.out.println("A média das notas é: " + resultado);
   }
}
