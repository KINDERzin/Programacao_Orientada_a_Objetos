import java.util.Scanner;

public class ex009 {
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      Integer idade;

      System.out.println("Digite a idade: ");
      idade = leitor.nextInt();
      
      if (idade < 18)
         System.out.println("Menor de idade");
      else
         System.out.println("Maior de idade");
      
      leitor.close();
   }

}
