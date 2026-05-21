import java.util.ArrayList;
import java.util.Scanner;

public class ex022 {
   public static void main(String[] args){
      Scanner leitor = new Scanner(System.in);
      ArrayList<Integer> numeros = new ArrayList<>();
      Integer numero;

      for(Integer i = 0; i < 8; i++) {
         System.out.println("Digite um número: (" + (i + 1) + "-8)");
         numero = leitor.nextInt();
         numeros.add(numero);
      }
      
      Double soma = 0.0;
      Double media;

      for(int i = 0; i < numeros.size(); i++)
         soma += numeros.get(i);
      
      media = soma / numeros.size();

      System.out.println("A soma total dos números é: " + soma);
      System.out.println("A média dos números é: " + media);
   }
}
