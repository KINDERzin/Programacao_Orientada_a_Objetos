
import java.util.ArrayList;
import java.util.Scanner;

public class ex040 {
   public abstract class Forma_Pagamento {
      public abstract void pagar(Double valor);
   }
   
   public class Pagamento_Cartao extends Forma_Pagamento {
      Pagamento_Cartao(Double valor) {
         pagar(valor);
      }
      
      @Override
      public void pagar(Double valor) {
         System.out.println("Pagamento de R$ " + (valor + (valor * 0.05)) + " realizado com cartão. (5% de taxa da máquina)");
      }
   }

   public class Pagamento_Pix extends Forma_Pagamento {
      public Pagamento_Pix(Double valor) {
         pagar(valor);
      }
      
      @Override
      public void pagar(Double valor) {
         System.out.println("Pagamento de R$ " + valor + " realizado via Pix. (Sem taxa)");
      }
   }

   public class Pagamento_Boleto extends Forma_Pagamento {
      public Pagamento_Boleto(Double valor) {
         pagar(valor);
      }
      
      @Override
      public void pagar(Double valor) {
         System.out.println("Pagamento de R$ " + (valor + (valor * 0.02)) + " realizado via boleto. (2% de taxa)");
      }
   }
   public static void main(String[] args) {
      ArrayList<Forma_Pagamento> formasPagamento = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);

      System.out.println("Digite o valor da compra:");
      Double valorCompra = scanner.nextDouble();

      formasPagamento.add(new ex040().new Pagamento_Cartao(valorCompra));
      formasPagamento.add(new ex040().new Pagamento_Pix(valorCompra));
      formasPagamento.add(new ex040().new Pagamento_Boleto(valorCompra));

      scanner.close();
   }
}
