import java.util.Scanner;

public class ex012 {
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      Double valor;
      Double desconto;

      System.out.println("Digite o valor do produto: ");
      valor = leitor.nextDouble();

      if(valor > 500.00)
         desconto = 0.15;
      else if(valor >= 200.00)
         desconto = 0.05;
      else
         desconto = 0.0;

      valor = valor - (valor * desconto);

      System.out.println("O valor final é: " + valor);

      leitor.close();
   }
}
