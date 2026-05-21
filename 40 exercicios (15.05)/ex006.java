import java.util.Scanner;

public class ex006 {
   public static void main(String[] args){
      Scanner leitor = new Scanner(System.in);
      String nome;
      Integer idade;
      String curso;

      System.out.println("Digite seu nome:");
      nome = leitor.nextLine();
      System.out.println("Digite sua idade:");
      idade = leitor.nextInt();
      System.out.println("Digite seu curso:");
      curso = leitor.nextLine();

      System.out.println("Olá, " + nome + "! Você tem " + idade + " anos e está cursando " + curso + ".");
   
      leitor.close();
   }
}
