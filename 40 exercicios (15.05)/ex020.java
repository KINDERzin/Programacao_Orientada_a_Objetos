import java.util.Scanner;

public class ex020 {
   public static void main(String[] args){
      Scanner leitor = new Scanner(System.in);
      Integer numero;
      Integer maior = 0;

      for(Integer i = 0; i < 10; i++) {
         System.out.println("Digite um número: ");
         numero = leitor.nextInt();

         maior = numero > maior ? numero : maior;
      }

      System.out.println("O maior número digitado foi: " + maior);
   
      leitor.close();
   }
}