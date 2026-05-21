
import java.util.Scanner;

public class ex027 {
   static int soma(int a, int b) {
      return a + b;
   }
   
   public static int subtracao(int a, int b) {
      return a - b;
   }
   
   public static int multiplicacao(int a, int b) {
      return a * b;
   }
   
   public static double divisao(int a, int b) {
      return (double) a / b;
   }
   
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      Integer num1;
      Integer num2;

      System.out.println("Digite o primeiro número: ");
      num1 = leitor.nextInt();
      System.out.println("Digite o segundo número: ");
      num2 = leitor.nextInt();
      
      leitor.close();
      
      System.out.println("Soma: " + soma(num1, num2));
      System.out.println("Subtração: " + subtracao(num1, num2));
      System.out.println("Multiplicação: " + multiplicacao(num1, num2));
      System.out.println("Divisão: " + divisao(num1, num2));   
   }
}
