package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Ator;
import model.Filme;
import repository.AtorRepository;
import view.AtorView;

public class AtorController {
	private List<Ator> atores = new ArrayList<>();
	private AtorRepository repository;
	private AtorView view;
	private FilmeController filmeController;
	
	public AtorController(AtorView view, AtorRepository repository) {
		this.view = view;
		this.repository = repository;
	
		configurarEventos();
	}
	
	public void configurarEventos() {
		view.getBtnExcluir().addActionListener(e -> {
			try {
				excluirAtor();
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
	
	public void excluirAtor() {
		String id = view.getIdTextField().getText();
		Boolean vinculado = false;
		
		for(Filme filme : filmeController.listarFilmes())
			vinculado = filme.getAtores().stream()
				.anyMatch(ator -> (ator.getId() == Integer.parseInt(id)));

		if(!vinculado)
			repository.excluir(Integer.parseInt(id));
		
		limparCampos();
		montarTabela();
	}
	
	public void limparCampos() {
		view.getIdTextField().setText("");
		view.getNomeTextField().setText("");
	}
	
	public void SalvarAtor() {
		String id = view.getIdTextField().getText();
		String nome = view.getNomeTextField().getText();
		
		if(nome.isBlank())
			throw new IllegalArgumentException("Insira um nome válido!");
		
		Ator ator = new Ator();
		ator.setNome(nome);
		
		if(id.equals(""))
			atores.stream()
				.noneMatch(a -> a.getNome() == nome);
		else {
			ator.setId(Integer.parseInt(id));
			repository.atualizar(ator);
		}
		
		limparCampos();
		montarTabela();
	}
	
	public void novoAtor() {
		limparCampos();
	}
	
	public void montarTabela() {
		
	}
	
	
}
