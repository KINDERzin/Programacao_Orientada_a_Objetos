
import java.util.Scanner;

public class ex031 {
   public class Produto {
      public String nome;
      public Double preco;
      public Integer quantidade;

      public Produto(String nome, double preco, int quantidade) {
         this.nome = nome;
         this.preco = preco;
         this.quantidade = quantidade;
      }
   }

   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      Produto produto[] = new Produto[3];

      for (int i = 0; i < 3; i++) {
         System.out.println("Digite o nome do produto: ");
         String nome = leitor.nextLine();

         System.out.println("Digite o preço do produto: ");
         Double preco = leitor.nextDouble();
         
         System.out.println("Digite a quantidade do produto: ");
         Integer quantidade = leitor.nextInt();

         produto[i] = new ex031().new Produto(nome, preco, quantidade);
      }

      for(Produto p : produto) {
         System.out.println("Produto: " + p.nome);
         System.out.println("Preço: " + p.preco);
         System.out.println("Quantidade: " + p.quantidade);
      }
   }
   
}
