
import java.util.Scanner;

public class ex014 {
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      Integer numero1;
      Integer numero2;
      String operacao;

      System.out.println("Digite o primeiro número: ");
      numero1 = leitor.nextInt();
      System.out.println("Digite o segundo número: ");
      numero2 = leitor.nextInt();
      System.out.println("Digite a operação (+, -, *, /): ");
      operacao = leitor.next();

      switch (operacao) {
         case "+":
            System.out.println("Soma: " + (numero1 + numero2));
            break;
         case "-":
            System.out.println("Subtração: " + (numero1 - numero2));
            break;
         case "*":
            System.out.println("Multiplicação: " + (numero1 * numero2));
            break;
         case "/":
            if (numero2 == 0) {
               System.out.println("Não é possível dividir por zero");
               break;
            }
            System.out.println("Divisão: " + ((double) numero1 / numero2));
            break;
      }
   }
}
