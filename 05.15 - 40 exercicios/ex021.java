import java.util.ArrayList;
import java.util.Scanner;

public class ex021 {
   public static void main(String[] args){
      ArrayList<Integer> numeros = new ArrayList<>();
      Scanner leitor = new Scanner(System.in);

      for(Integer i = 0; i < 5; i++) {
         System.out.println("Digite um número: (" + (i + 1) + "-5)");
         Integer numero = leitor.nextInt();
         numeros.add(numero);
      }

      System.out.println("Números digitados: " + numeros);

      leitor.close();
   }
}
