
import java.util.Scanner;

public class ex039 {
   public class Funcionario {
      private String nome;
      private Double salario_base;

      public Funcionario(String nome, Double salario_base) {
         setNome(nome);
         setSalario_base(salario_base);
      }

      public String getNome() {
         return nome;
      }
      public void setNome(String nome) {
         this.nome = nome;
      }

      public Double getSalario_base() {
         return salario_base;
      }
      public void setSalario_base(Double salario_base) {
         if (salario_base < 0) {
            System.out.println("Salário base inválido!");
            return;
         }
         
         this.salario_base = salario_base;
      }
   }
   
   public class Gerente extends Funcionario {
      private Double bonus = 0.20;

      public Gerente(String nome, Double salario_base) {
         super(nome, salario_base);
         calcularSalario();
      }

      public Double getBonus() {
         return bonus;
      }
      public void setBonus(Double bonus) {
         if (bonus < 0 || bonus > 1) {
            System.out.println("Bônus inválido! O valor deve estar entre 0 e 1.");
            return;
         }
         this.bonus = bonus;
      }

      public void calcularSalario() {
         Double salario_final = getSalario_base() + (getSalario_base() * getBonus());
         System.out.println("Salário final do gerente " + getNome() + ": " + salario_final);
      }
   }
   
   public class FuncionarioComum extends Funcionario {
      public FuncionarioComum(String nome, Double salario_base) {
         super(nome, salario_base);
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Digite o nome do gerente:");
      String nomeGerente = scanner.nextLine();

      System.out.println("Digite o salário base do gerente:");
      Double salarioBaseGerente = scanner.nextDouble();

      Gerente gerente = new ex039().new Gerente(nomeGerente, salarioBaseGerente);
      gerente.calcularSalario();

      System.out.println("Digite o nome do funcionário comum:");
      scanner.nextLine(); // Consumir a quebra de linha pendente
      String nomeFuncionario = scanner.nextLine(); 

      System.out.println("Digite o salário base do funcionário comum:");
      Double salarioBaseFuncionario = scanner.nextDouble();

      FuncionarioComum funcionarioComum = new ex039().new FuncionarioComum(nomeFuncionario, salarioBaseFuncionario);

      System.out.println("Salário do funcionário comum: " + funcionarioComum.getSalario_base());
      System.out.println("Salário do gerente: " + gerente.getSalario_base());
   
      scanner.close();
   }
}
