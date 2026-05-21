import java.util.Scanner;

public class ex008 {
   public static void main(String[] args){
      Scanner leitor = new Scanner(System.in);
      Double salario;
      String hora_trabalho;

      System.out.println("Digite seu salário:");
      salario = leitor.nextDouble();
      System.out.println("Digite a quantidade de horas trabalhadas:");
      hora_trabalho = leitor.nextLine();

      // Divide a string e pega as partes de horas e minutos
      Integer horas = Integer.parseInt(hora_trabalho.split(":")[0]);
      Integer minutos = Integer.parseInt(hora_trabalho.split(":")[1]);
      // Realiza o cálculo do valor da hora trabalhada
      Double valor_hora = salario / (horas + (minutos / 60.0));

      System.out.println("Valor da hora trabalhada: " + valor_hora);
      
      leitor.close();
   }
}
