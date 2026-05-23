
import java.util.Scanner;

public class ex035 {
   public class Conta_Bancaria {
      private String titular;
      private Double saldo = 0.0;

      public Conta_Bancaria(String titular) {
         setTitular(titular);
      }

      public String getTitular() {
         return titular;
      }
      public void setTitular(String titular) {
         this.titular = titular;
      }

      public Double exibir_saldo() {
         return this.saldo;
      }
      public void Depositar(Double saldo) {
         if(saldo > 0.0) {
            this.saldo += saldo;
            System.out.println("Depósito realizado com sucesso!");
            return;
         }
         System.out.println("Valor de depósito inválido!");
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

      Conta_Bancaria conta = new ex035().new Conta_Bancaria(titular);

      System.out.print("Digite o valor a ser depositado: ");
      Double deposito = leitor.nextDouble();
      conta.Depositar(deposito);
      System.out.println("Saldo atual: " + conta.exibir_saldo());
      
      System.out.print("Digite o valor a ser sacado: ");
      Double saque = leitor.nextDouble();
      conta.Sacar(saque);
      System.out.println("Saldo atual: " + conta.exibir_saldo());
   
      leitor.close();
   }
}
