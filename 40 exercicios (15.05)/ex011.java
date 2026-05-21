import java.util.Scanner;

public class ex011 {
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      Double nota1;
      Double nota2;
      Double media;

      System.out.println("Digite a primeira nota: ");
      nota1 = leitor.nextDouble();
      System.out.println("Digite a segunda nota: ");
      nota2 = leitor.nextDouble();

      media = (nota1 + nota2) / 2;

      if (media >= 7)
         System.out.println("Aprovado");
      else if (media >= 5)
         System.out.println("Recuperação");
      else
         System.out.println("Reprovado");
      
      leitor.close();
   }
}
