
import java.util.Scanner;

public class ex034 {
   public class Produto{
      private String nome;
      private Double preco;
      private Integer quantidade;

      public Produto(String nome, double preco, int quantidade) {
         setNome(nome);
         setPreco(preco);
         setQuantidade(quantidade);
      }

      public String getNome() {
         return nome;
      }
      public void setNome(String nome) {
         this.nome = nome;
      }
      public Double getPreco() {
         return preco;
      }
      public void setPreco(Double preco) {
         if(preco >= 0.0) {
            this.preco = preco;
            return;
         }
         System.out.println("Preço inválido!");
      }
      public Integer getQuantidade() {
         return quantidade;
      }
      public void setQuantidade(Integer quantidade) {
         if(quantidade >= 0) {
            this.quantidade = quantidade;
            return;
         }

         System.out.println("Quantidade inválida!");
      }
   }
   
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);

      System.out.print("Digite o nome do produto: ");
      String nome = leitor.nextLine();

      System.out.print("Digite o preço do produto: ");
      Double preco = leitor.nextDouble();

      System.out.print("Digite a quantidade do produto: ");
      Integer quantidade = leitor.nextInt();

      Produto produto = new ex034().new Produto(nome, preco, quantidade);

      System.out.println("Produto: " + produto.getNome());
      System.out.println("Preço: " + produto.getPreco());
      System.out.println("Quantidade: " + produto.getQuantidade());
      
      leitor.close();
   }
}
