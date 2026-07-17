package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Ator;

public class AtorRepository {
	private final List<Ator> atores = new ArrayList<>();
	private Integer proximoId = 1;

	public void adicionarAtor(Ator ator) {
		ator.setId(proximoId);
		proximoId++;

		for(Ator a : atores)
			if(a.getNome().equals(ator.getNome()))
				throw new IllegalArgumentException("Esse ator já esta cadastrado no sistema!");

		atores.add(ator);
	}

	public List<Ator> listarAtores() { return atores; }

	public Optional<Ator> buscarPorId(int id) {
		return this.atores.stream()
				.filter(ator -> ator
				.getId() == id).findFirst();
	}

	public void atualizar(Ator ator) {
		for(int i = 0; i < atores.size(); i++) {
			Ator atual = atores.get(i);

			if(ator.getId() == atual.getId()) {
				atores.set(i, ator);
				break;
			}
		}
	}

	public void excluir(Integer id) { 
		this.atores.removeIf(ator -> ator.getId() == id);
	}
}