package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Filme;

public class FilmeRepository {
	private final List<Filme> filmes = new ArrayList<>();
	private Integer proximoId = 1;
	
	public void adicionarFilme(Filme filme) {
		filme.setId(proximoId);
		proximoId++;

		filmes.add(filme);
	}
	
	public List<Filme> listarFilmes() { return filmes; }
	
	public Optional<Filme> buscarPorId(Integer id) {
		return this.filmes.stream()
				.filter(filme -> filme.getId() == id)
				.findFirst();
	}
	
	public void atualizar(Filme filme) {
		for(int i = 0; i < filmes.size(); i++) {
			Filme atual = filmes.get(i);
			
			if(filme.getId() == atual.getId()) {
				filmes.set(i, atual);
				break;
			}	
		}
	}
	
	public void excluir(Integer id) {
		this.filmes.removeIf(filme -> filme.getId() == id);
	}
}