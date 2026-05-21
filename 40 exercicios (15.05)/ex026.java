import java.util.Scanner;

public class ex026 {
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      String palavra;

      System.out.println("Digite uma palavra: ");
      palavra = leitor.nextLine();

      System.out.println("Palavra em maiúsculas: " + palavra.toUpperCase());
      System.out.println("Palavra em minúsculas: " + palavra.toLowerCase());
      System.out.println("Quantidade de caracteres: " + palavra.length());
      if(palavra.contains("java")) 
         System.err.println("A palavra contém 'java'.");
      else 
         System.out.println("A palavra não contém 'java'.");
      leitor.close();
   }
}
