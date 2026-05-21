import java.util.Scanner;

public class ex007 {
   public static void main(String[] args){
      Scanner leitor = new Scanner(System.in);
      Integer numero1;
      Integer numero2;

      System.out.println("Digite o primeiro número:");
      numero1 = leitor.nextInt();
      System.out.println("Digite o segundo número:");
      numero2 = leitor.nextInt();

      System.out.println("Soma: " + (numero1 + numero2));
      System.out.println("Subtração: " + (numero1 - numero2));
      System.out.println("Multiplicação: " + (numero1 * numero2));
      System.out.println("Divisão: " + (numero1 / numero2));

      leitor.close();
   }
}
