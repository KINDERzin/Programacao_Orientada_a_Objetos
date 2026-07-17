package model;

import java.util.List;

public class Filme {
	private Integer id;
	private Integer duracao;
	private String titulo;
	private Genero genero;
	private List<Ator> atores;

	public Integer getId() { return this.id; }
	public void setId(Integer id) {
		this.id = id;
	}

    public String getTitulo() { return this.titulo; }
    public void setTitulo(String titulo) {
    	if(titulo.trim().isBlank())
    		throw new IllegalArgumentException("Insira um título válido!");

        this.titulo = titulo.trim();
    }

    public Integer getDuracao() { return this.duracao; }
    public void setDuracao(Integer tempo) {
    	if(duracao < 1)
    		throw new IllegalArgumentException("A duração deve ser maior que 0");

    	this.duracao = tempo;
    }

    public Genero getGenero() { return this.genero; }
    public void setGenero(Genero g) {
    	if(g == null)
    		throw new IllegalArgumentException("Gênero inválido!");

    	this.genero = g;
    }
 
    public List<Ator> getAtores() { return this.atores; }
    public void setAtores(List<Ator> atores) {
    	if(atores.size() < 1)
    		throw new IllegalArgumentException("Quantidade de atores inválida!");

		this.atores = atores;
    }
}