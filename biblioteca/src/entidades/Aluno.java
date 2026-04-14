package entidades;

public class Aluno extends Usuario {
   private String curso;

   public Aluno(String nome, String codigoUsuario, String curso) {
      super(nome, codigoUsuario, TipoUsuario.ALUNO, 3);
      setCurso(curso);
   }
  
   // CURSO
   public String getCurso() {
      return this.curso;
   }
   public void setCurso(String curso) {
      if (curso == null || curso.trim().isEmpty())
         throw new IllegalArgumentException("O curso do aluno não pode estar vazio. Tente novamente!");

      this.curso = curso;
   }
}
