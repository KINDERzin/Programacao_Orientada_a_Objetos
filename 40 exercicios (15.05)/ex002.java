import java.util.Scanner;

public class ex002 {
   public static void main(String[] args){
      Scanner leitor = new Scanner(System.in);
      String nome;
      String cidade;
      Integer idade;
      Double altura;

      // Armazena o nome
      System.out.println("Digite seu nome:");
      nome = leitor.nextLine();
      // Armazena a idade
      System.out.println("Digite sua idade:");
      idade = leitor.nextInt();
      // Armazena a altura
      System.out.println("Digite sua altura:");
      altura = leitor.nextDouble();
      // Armazena a cidade
      System.out.println("Digite sua cidade:");
      cidade = leitor.nextLine();
      
      // Printa tudo
      System.out.println("Olá, " + nome + "! Você tem " + idade + " anos, tem " + altura + 
                         " metros de altura e mora em " + cidade + ".");
      
      leitor.close();
   }
}
