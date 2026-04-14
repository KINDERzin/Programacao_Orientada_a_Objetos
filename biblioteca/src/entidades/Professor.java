package entidades;

public class Professor extends Usuario {
  	private String departamento;
	private String formacao;

	public Professor(String Nome, String CodigoUsuario, String Departamento, String Formacao) {
		super(Nome, CodigoUsuario, TipoUsuario.PROFESSOR, 10);
		setDepartamento(Departamento);
		setFormacao(Formacao);
	}
	
	// DEPARTAMENTO
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String Departamento) {
		if (Departamento == null || Departamento.trim().isEmpty())
			throw new IllegalArgumentException("O departamento do professor não pode estar vazio. Tente novamente!");

		this.departamento = Departamento.trim();
	}

	// FORMAÇÃO
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String Formacao) {
		if (Formacao == null || Formacao.trim().isEmpty())
			throw new IllegalArgumentException("A formação do professor não pode estar vazia. Tente novamente!");

		this.formacao = Formacao.trim();
	}
}
