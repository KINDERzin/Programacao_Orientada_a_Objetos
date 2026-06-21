
import java.util.Scanner;

public class ex033 {
   public class Conta_Bancaria {
      public String titular;
      public Double saldo = 0.0;

      public Conta_Bancaria(String titular) {
         this.titular = titular;
      }

      public void exibir_saldo() {
         System.out.println("Saldo da conta: " + this.saldo);
      }
      public void Depositar(Double saldo) {
         this.saldo += saldo;
      }
      public void Sacar(Double saldo) {
         if(saldo > 0.0 && this.saldo >= saldo) {
            this.saldo -= saldo;
            System.out.println("Saque realizado com sucesso!");
            return;
         }
         System.out.println("Valor de saque inválido ou saldo insuficiente!");
      }

   }
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);

      System.out.print("Digite o nome do titular da conta: ");
      String titular = leitor.nextLine();

      Conta_Bancaria conta = new ex033().new Conta_Bancaria(titular);

      System.out.print("Digite o valor a ser depositado: ");
      Double deposito = leitor.nextDouble();
      conta.Depositar(deposito);

      System.out.print("Digite o valor a ser sacado: ");
      Double saque = leitor.nextDouble();
      conta.Sacar(saque);

      conta.exibir_saldo();
   }
}
