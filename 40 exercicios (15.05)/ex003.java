import java.util.Scanner;

public class ex003 {
   public static void main(String[] args){
      Scanner leitor = new Scanner(System.in);
      Double nota1;
      Double nota2;

      System.out.println("Digite a primeira nota:");
      nota1 = leitor.nextDouble();
      System.out.println("Digite a segunda nota:");
      nota2 = leitor.nextDouble();

      Double media = (nota1 + nota2) / 2;

      System.out.println("A média do aluno é: " + media);
      
      leitor.close();
   }
}
