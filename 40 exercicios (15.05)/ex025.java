import java.util.ArrayList;
import java.util.Scanner;

public class ex025 {
   public static void main(String[] args) {
      ArrayList<String> nomes = new ArrayList<>();
      Scanner leitor = new Scanner(System.in);
      
      for(Integer i = 0; i < 10; i++) {
         System.out.println("Digite um nome: (" + (i + 1) + "-10)");
         String nome = leitor.nextLine();
         nomes.add(nome);
      }

      System.out.println("Buscar nome: ");
      String nomeBusca = leitor.nextLine();

      for (String nome : nomes)
         if (nome.equals(nomeBusca)) {
            System.out.println("Nome encontrado: " + nome);
            break;
         }
   }
}