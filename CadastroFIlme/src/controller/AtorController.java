package controller;

import javax.swing.JOptionPane;

import model.Ator;
import repository.AtorRepository;
import repository.FilmeRepository;
import repository.GeneroRepository;
import view.AtorView;
import view.FilmeView;
import view.GeneroView;

public class AtorController {
	private AtorRepository repository;
	private AtorView view;
	private FilmeRepository filmeRepository;
	private GeneroRepository generoRepository;

	public AtorController(AtorView view, AtorRepository repository) {
		this(view, repository, new FilmeRepository(), new GeneroRepository());
	}

	public AtorController(AtorView view, AtorRepository repository, FilmeRepository filmeRepository, GeneroRepository generoRepository) {
		this.view = view;
		this.repository = repository;
		this.filmeRepository = filmeRepository;
		this.generoRepository = generoRepository;

		configurarEventos();
		montarTabela();
		limparCampos();
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

		view.getBtnSalvar().addActionListener(e -> {
			try { salvarAtor(); }
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		view.getBtnNovo().addActionListener(e -> {
			try { novoAtor(); }
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		view.getBtnLimpar().addActionListener(e -> {
			try { limparCampos(); }
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		view.getBtnExcluir().addActionListener(e -> {
			try { excluirAtor(); }
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		view.getTable().getSelectionModel().addListSelectionListener(e -> {
			if(!e.getValueIsAdjusting()) {
				try { carregarAtorSelecionado(); }
				catch(Exception ex) {
					JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void abrirTelaFilme() {
		FilmeView filmeView = new FilmeView();
		new FilmeController(filmeView, filmeRepository, repository, generoRepository);
		filmeView.setVisible(true);
		view.dispose();
	}

	public void abrirTelaGenero() {
		GeneroView generoView = new GeneroView();
		new GeneroController(generoView, generoRepository, repository, filmeRepository);
		generoView.setVisible(true);
		view.dispose();
	}

	public void carregarAtorSelecionado() {
		int linhaSelecionada = view.getTable().getSelectedRow();

		if(linhaSelecionada == -1)
			return;

		int linhaModelo = view.getTable().convertRowIndexToModel(linhaSelecionada);
		Integer id = (Integer) view.getAtorTableModel().getValueAt(linhaModelo, 0);

		repository.buscarPorId(id).ifPresent(this::preencherCampos);
		view.getBtnExcluir().setEnabled(true);
	}

	public void preencherCampos(Ator ator) {
		view.getIdTextField().setText(String.valueOf(ator.getId()));
		view.getNomeTextField().setText(ator.getNome());
	}

	public void excluirAtor() {
		String id = view.getIdTextField().getText();

		if(id.isBlank())
			throw new IllegalArgumentException("Selecione um ator para excluir!");

		int idInt = Integer.parseInt(id);

		boolean vinculado = filmeRepository.listarFilmes().stream()
				.anyMatch(filme -> filme.getAtores().stream()
						.anyMatch(ator -> ator.getId() == idInt));

		if(vinculado)
			throw new IllegalArgumentException("Esse ator está vinculado a um filme e não pode ser excluído!");

		repository.excluir(idInt);

		limparCampos();
		montarTabela();
	}

	public void limparCampos() {
		view.getIdTextField().setText("");
		view.getNomeTextField().setText("");
		view.getBtnExcluir().setEnabled(false);
		view.getTable().clearSelection();
	}

	public void salvarAtor() {
		String id = view.getIdTextField().getText();
		String nome = view.getNomeTextField().getText();

		if(nome.isBlank())
			throw new IllegalArgumentException("Insira um nome válido!");

		Ator ator = new Ator();
		ator.setNome(nome);

		if(id.equals("")) {
			repository.adicionarAtor(ator);
		}
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
		view.getAtorTableModel().setRowCount(0);

		for(Ator a : repository.listarAtores())
			view.getAtorTableModel().addRow(new Object[] { a.getId(), a.getNome() });
	}
}