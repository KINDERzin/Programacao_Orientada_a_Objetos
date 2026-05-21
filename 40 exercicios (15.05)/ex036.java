
import java.util.Scanner;

public class ex036 {
   public class Aluno {
      private String nome;
      private String RA;
      private Double media;

      public Aluno(String nome, String RA, Double media) {
         setNome(nome);
         setRA(RA);
         setMedia(media);
      }

      public String getNome() {
         return nome;
      }

      public void setNome(String nome) {
         this.nome = nome;
      }

      public String getRA() {
         return RA;
      }

      public void setRA(String RA) {
         this.RA = RA;
      }

      public Double getMedia() {
         return media;
      }

      public void setMedia(Double media) {
         if(media >= 0.0 && media <= 10.0) {
            this.media = media;
            return;
         }
         System.out.println("Média inválida!");
      }
   }

   public static void main(String[] args) {
      Scanner leitor = new Scanner(System.in);
      Aluno[] alunos = new Aluno[5];

      for (int i = 0; i < 5; i++) {
         System.out.print("Digite o nome do aluno: ");
         String nome = leitor.nextLine();

         System.out.print("Digite o RA do aluno: ");
         String RA = leitor.nextLine();

         System.out.print("Digite a média do aluno: ");
         Double media = leitor.nextDouble();

         Aluno aluno = new ex036().new Aluno(nome, RA, media);
         alunos[i] = aluno;
      }

      System.out.println("\nAlunos cadastrados:");
      for (Aluno aluno : alunos) {
          System.out.println("Nome: " + aluno.getNome());
          System.out.println("RA: " + aluno.getRA());
          System.out.println("Média: " + aluno.getMedia());
          System.out.println();
      }

      System.out.println("Alunos aprovados:");
      for (Aluno aluno : alunos) {
         if (aluno.getMedia() >= 7.0) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("RA: " + aluno.getRA());
            System.out.println("Média: " + aluno.getMedia());
            System.out.println();
         }
      }

      Double media_geral = 0.0;
      
      for (Aluno aluno : alunos)
         media_geral += aluno.getMedia();
      
      media_geral /= alunos.length;
      System.out.println("Média geral: " + media_geral);
   
      leitor.close();
   }
}
