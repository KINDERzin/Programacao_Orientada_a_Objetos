package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Ator;
import model.Filme;
import repository.AtorRepository;
import repository.FilmeRepository;
import repository.GeneroRepository;
import view.AtorView;
import view.FilmeView;
import view.GeneroView;

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
		
		view.getFilmeMenuItem().addActionListener(e -> {
			try { abrirTelaFilme(); }
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		view.getGeneroMenuItem().addActionListener(e -> {
			try { abrirTelaGenero(); }
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		view.getBtnExcluir().addActionListener(e -> {
			try {
				excluirAtor();
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
	
	// NAVEGAÇÃO ENTRE TELAS
	public void abrirTelaFilme() {
		FilmeView filmeView = new FilmeView();
		FilmeRepository filmeRepository = new FilmeRepository();
		new FilmeController(filmeView, filmeRepository);
		filmeView.setVisible(true);
		view.dispose();
	}
	
	public void abrirTelaGenero() {
		GeneroView generoView = new GeneroView();
		GeneroRepository generoRepository = new GeneroRepository();
		new GeneroController(generoView, generoRepository);
		generoView.setVisible(true);
		view.dispose();
	}

	// FUNÇÕES DOS BOTÕES
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
		view.getAtorTabelaModel().setRowCount(0);
		
		for(Ator a : repository.listarAtores()) {
			view.getAtorTabelaModel().addRow(
				new Object[] {
					a.getId(),
					a.getNome()
			});
		}
	}
	
	public void carregarLinhaSelecionada() {
		int linhaSelecionada = view.getAtorTable().getSelectedRow();
		
		if(linhaSelecionada == -1)
			throw new IllegalArgumentException("A linha selecionada inválida!");
		
		view.getBtnExcluir().setEnabled(true);
		
		int linhaModel = view.getAtorTable().convertColumnIndexToModel(linhaSelecionada);
		Integer id = (Integer) view.getAtorTabelaModel().getValueAt(linhaModel, 0);
		
		this.repository.buscarPorId(id).ifPresent(this::preencherCampos);
	}
	
	public void preencherCampos(Ator a) {
		view.getIdTextField().setText(a.getId().toString());
		view.getNomeTextField().setText(a.getNome());
	}
}