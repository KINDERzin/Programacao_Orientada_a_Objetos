import java.util.Scanner;

public class ex019 {
   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      Double nota = 0.0;
      Double nota_total = 0.0;
      Integer quantidade_notas = 0;

      while(nota != -1) {
         System.out.println("Digite a nota total (-1 para sair):");
         nota = leitor.nextDouble();
         nota_total += nota;
         quantidade_notas++;
      }

      System.out.println("Média das notas: " + (nota_total / quantidade_notas));
   }
}
