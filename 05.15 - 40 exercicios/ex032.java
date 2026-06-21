import java.util.Scanner;

public class ex032 {
   public class Aluno {
      private String nome;
      private Integer idade;
      private Double nota1;
      private Double nota2;

      public Aluno(String nome, int idade, Double nota1, Double nota2) {
         setNome(nome);
         setIdade(idade);
         setNotas(nota1, nota2);
      }

      public String getNome() {
         return nome;
      }
      public void setNome(String nome) {
         this.nome = nome;
      }

      public Integer getIdade() {
         return idade;
      }
      public void setIdade(Integer idade) {
         this.idade = idade;
      }

      public void setNotas(Double nota1, Double nota2) {
         this.nota1 = nota1;
         this.nota2 = nota2;
      }
      public Double getNota1() {
         return nota1;
      }
      public Double getNota2() {
         return nota2;
      }

      public Double calcular_media(Double nota1, Double nota2) {
         return (nota1 + nota2) / 2;
      }
   }

   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);

      System.out.print("Digite o nome do aluno: ");
      String nome = leitor.nextLine();

      System.out.print("Digite a idade do aluno: ");
      Integer idade = leitor.nextInt();

      System.out.print("Digite a primeira nota do aluno: ");
      Double nota1 = leitor.nextDouble();

      System.out.print("Digite a segunda nota do aluno: ");
      Double nota2 = leitor.nextDouble();

      Aluno aluno = new ex032().new Aluno(nome, idade, nota1, nota2);
      Double media = aluno.calcular_media(nota1, nota2);

      System.out.println("Aluno: " + aluno.getNome());
      System.out.println("Média: " + media);
   }
}
