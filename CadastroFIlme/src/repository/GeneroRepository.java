package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Genero;

public class GeneroRepository {
	private final List<Genero> generos = new ArrayList<>();
	private Integer proximoId = 1;
	
	public void adicionarGenero(Genero genero) {
		System.out.println("adicionarGenero");
		genero.setId(proximoId);
		proximoId++;
		
		System.out.println(genero.getGenero());
		System.out.println(genero.getId());
		generos.add(genero);
	}
	
	public List<Genero> listarGeneros() { return this.generos; }
	
	public Optional<Genero> buscarPorId(int id) {
		return this.generos.stream()
				.filter(genero -> genero.getId() == id)
				.findFirst();
	}
	
	public void atualizar(Genero genero) {
		for (int i = 0; i < generos.size(); i++) {
			if(generos.get(i).getId() == genero.getId()) {
				generos.set(i, genero);
				break;
			}
		}
	}
	
	public void excluir(int id) {
		this.generos.removeIf(genero -> genero.getId() == id);
	}
}