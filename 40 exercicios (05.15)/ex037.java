
import java.util.Scanner;

public class ex037 {
   public class Item_Pedido {
      private String nome_produto;
      private Integer quantidade;
      private Double valor_unitario;

      public Item_Pedido(String nome_produto, Integer quantidade, Double valor_unitario) {
         setNome_produto(nome_produto);
         setQuantidade(quantidade);
         setValor_unitario(valor_unitario);
      }

      public String getNome_produto() {
         return nome_produto;
      }

      public void setNome_produto(String nome_produto) {
         this.nome_produto = nome_produto;
      }

      public Integer getQuantidade() {
         return quantidade;
      }

      public void setQuantidade(Integer quantidade) {
         if(quantidade < 0) {
            System.out.println("Quantidade inválida.");
            return;
         }

         this.quantidade = quantidade;
      }

      public Double getValor_unitario() {
         return valor_unitario;
      }

      public void setValor_unitario(Double valor_unitario) {
         if(valor_unitario < 0) {
            System.out.println("Valor unitário inválido.");
            return;
         }

         this.valor_unitario = valor_unitario;
      }
   }

   public class Pedido {
      private String nome_cliente;
      private Item_Pedido[] itens;

      public Pedido(String nome_cliente, String endereco_entrega, Item_Pedido[] itens) {
         this.nome_cliente = nome_cliente;
         this.itens = itens;
      }

      public Double calcular_valor() {
         Double valor_total = 0.0;

         for(Item_Pedido item : itens) {
            valor_total += item.getQuantidade() * item.getValor_unitario();
         }

         return valor_total;
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Digite o nome do cliente: ");
      String nome_cliente = scanner.nextLine();
      
      Item_Pedido[] itens = new Item_Pedido[3];

      for(int i = 0; i < itens.length; i++) {
         System.out.print("Digite o nome do produto: ");
         String nome_produto = scanner.nextLine();

         System.out.print("Digite a quantidade: ");
         Integer quantidade = scanner.nextInt();

         System.out.print("Digite o valor unitário: ");
         Double valor_unitario = scanner.nextDouble();
         scanner.nextLine();

         itens[i] = new ex037().new Item_Pedido(nome_produto, quantidade, valor_unitario);
      }

      scanner.close();
   }
}
