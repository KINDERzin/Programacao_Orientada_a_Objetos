package entidades;

public class ServidorAdministrativo extends Usuario {
	private String setor;
	private String cargo;

	public ServidorAdministrativo(String Nome, String CodigoUsuario, String setor, String cargo) {
		super(Nome, CodigoUsuario, TipoUsuario.SERVIDOR_ADMINISTRATIVO, 5);
		setSetor(setor);
		setCargo(cargo);
	}
  
	// SETOR
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		if (setor != null)
			setor = setor.trim();

		if (setor == null || setor.isEmpty())
			throw new IllegalArgumentException("O setor do servidor administrativo não pode estar vazio. Tente novamente!");

		this.setor = setor;
	}

	// CARGO
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		if (cargo != null)
			cargo = cargo.trim();

		if (cargo == null || cargo.isEmpty())
			throw new IllegalArgumentException("O cargo do servidor administrativo não pode estar vazio. Tente novamente!");

		this.cargo = cargo;
	}
}
