package model;

public class Ator {
	private Integer id;
	private String nome;
	
	public int getId() { return this.id; }
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() { return this.nome; }
	public void setNome(String nome) {
		if(nome.isBlank())
			throw new IllegalArgumentException("Nome inválido!");

		this.nome = nome.trim();
	}
}
