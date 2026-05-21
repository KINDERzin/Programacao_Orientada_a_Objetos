
import java.util.ArrayList;
import java.util.Scanner;

public class ex038 {
   public class Pessoa {
      private String nome;
      private Integer idade;

      public Pessoa(String nome, Integer idade) {
         setNome(nome);
         setIdade(idade);
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
         if(idade < 0) {
            System.out.println("Idade inválida.");
            return;
         }

         this.idade = idade;
      }
   }
  
   public class Aluno extends Pessoa {
      private String RA;
      private String curso;

      public Aluno(String nome, Integer idade, String RA, String curso) {
         super(nome, idade);
         setRA(RA);
         setCurso(curso);
      }

      public String getRA() {
         return RA;
      }

      public void setRA(String RA) {
         this.RA = RA;
      }

      public String getCurso() {
         return curso;
      }

      public void setCurso(String curso) {
         this.curso = curso;
      }
   }
   
   public class Professor extends Pessoa {
      private String matricula;
      private String disciplina;

      public Professor(String nome, Integer idade, String matricula, String disciplina) {
         super(nome, idade);
         setMatricula(matricula);
         setDisciplina(disciplina);
      }

      public String getMatricula() {
         return matricula;
      }

      public void setMatricula(String matricula) {
         this.matricula = matricula;
      }

      public String getDisciplina() {
         return disciplina;
      }

      public void setDisciplina(String disciplina) {
         this.disciplina = disciplina;
      }
   }
   
   public static void main(String[] args) {
      ArrayList<Pessoa> pessoas = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);

      System.out.println("Digite o nome do aluno:");
      String nomeAluno = scanner.nextLine();

      System.out.println("Digite a idade do aluno:");
      Integer idadeAluno = scanner.nextInt();
      scanner.nextLine(); // Consume the newline character

      System.out.println("Digite o RA do aluno:");
      String RA = scanner.nextLine();

      System.out.println("Digite o curso do aluno:");
      String curso = scanner.nextLine();

      Aluno aluno = new ex038().new Aluno(nomeAluno, idadeAluno, RA, curso);
      pessoas.add(aluno);

      System.out.println("Digite o nome do professor:");
      String nomeProfessor = scanner.nextLine();

      System.out.println("Digite a idade do professor:");
      Integer idadeProfessor = scanner.nextInt();
      scanner.nextLine(); // Consume the newline character

      System.out.println("Digite a matrícula do professor:");
      String matricula = scanner.nextLine();

      System.out.println("Digite a disciplina do professor:");
      String disciplina = scanner.nextLine();

      Professor professor = new ex038().new Professor(nomeProfessor, idadeProfessor, matricula, disciplina);
      pessoas.add(professor);

      System.out.println("\nPessoas cadastradas:");
      for(Pessoa pessoa : pessoas) {
         System.out.println("Nome: " + pessoa.getNome());
         System.out.println("Idade: " + pessoa.getIdade());

         if(pessoa instanceof Aluno) {
            Aluno a = (Aluno) pessoa;
            System.out.println("RA: " + a.getRA());
            System.out.println("Curso: " + a.getCurso());
         } 
         else if(pessoa instanceof Professor) {
            Professor p = (Professor) pessoa;
            System.out.println("Matrícula: " + p.getMatricula());
            System.out.println("Disciplina: " + p.getDisciplina());
         }

         scanner.close();
      }
   }
}
