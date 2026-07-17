package controller;

import javax.swing.JOptionPane;

import repository.GeneroRepository;
import repository.FilmeRepository;
import repository.AtorRepository;
import view.GeneroView;
import view.FilmeView;
import view.AtorView;
import model.Genero;

public class GeneroController {
	private GeneroRepository repository;
	private AtorRepository atorRepository;
	private FilmeRepository filmeRepository;
	private GeneroView view;

	public GeneroController(GeneroView view, GeneroRepository repository) {
		this(view, repository, new AtorRepository(), new FilmeRepository());
	}

	public GeneroController(GeneroView view, GeneroRepository repository, AtorRepository atorRepository, FilmeRepository filmeRepository) {
		this.view = view;
		this.repository = repository;
		this.atorRepository = atorRepository;
		this.filmeRepository = filmeRepository;

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
		
		view.getAtorMenuItem().addActionListener(e -> {
			try { abrirTelaAtor(); }
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		view.getBtnSalvar().addActionListener(e -> {
			try { salvarGenero(); }
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		view.getBtnNovo().addActionListener(e -> {
			try { novoGenero(); }
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		view.getBtnExcluir().addActionListener(e -> {
			try { excluirGenero(); }
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

		view.getTable().getSelectionModel().addListSelectionListener(e -> {
			if(!e.getValueIsAdjusting()) {
				try { carregarGeneroSelecionado(); }
				catch(Exception ex) {
					JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	public void abrirTelaFilme() {
		FilmeView filmeView = new FilmeView();
		new FilmeController(filmeView, filmeRepository, atorRepository, repository);
		filmeView.setVisible(true);
		view.dispose();
	}
	
	public void abrirTelaAtor() {
		AtorView atorView = new AtorView();
		new AtorController(atorView, atorRepository, filmeRepository, repository);
		atorView.setVisible(true);
		view.dispose();
	}

	public void carregarGeneroSelecionado() {
		int linhaSelecionada = view.getTable().getSelectedRow();

		if(linhaSelecionada == -1)
			return;

		int linhaModelo = view.getTable().convertRowIndexToModel(linhaSelecionada);
		Integer id = (Integer) view.getGeneroTableModel().getValueAt(linhaModelo, 0);

		repository.buscarPorId(id).ifPresent(this::preencherCampos);
		view.getBtnExcluir().setEnabled(true);
	}

	public void preencherCampos(Genero genero) {
		view.getIdTextField().setText(String.valueOf(genero.getId()));
		view.getGeneroTextField().setText(genero.getGenero());
	}
	
	public void salvarGenero() {
		String id = view.getIdTextField().getText();
		String genero = view.getGeneroTextField().getText();
		
		if(genero.isBlank())
			throw new IllegalArgumentException("Insira um gênero válido!");
		
		Genero g = new Genero();
		g.setGenero(genero);
		
		if(id.equals("")) {
			repository.adicionarGenero(g);
		}
		else {
			g.setId(Integer.parseInt(id));
			repository.atualizar(g);
		}
		
		limparCampos();
		montarTabela();
	}
	
	public void novoGenero() {
		limparCampos();
	}
	
	public void excluirGenero() {
		String id = view.getIdTextField().getText();

		if(id.isBlank())
			throw new IllegalArgumentException("Selecione um gênero para excluir!");
		
		repository.excluir(Integer.parseInt(id));
		
		limparCampos();
		montarTabela();
	}
	
	public void limparCampos() {
		view.getGeneroTextField().setText("");
		view.getIdTextField().setText("");
		view.getBtnExcluir().setEnabled(false);
		view.getTable().clearSelection();
	}
	
	public void montarTabela() {
		view.getGeneroTableModel().setRowCount(0);
		
		for(Genero g : repository.listarGeneros())
			view.getGeneroTableModel().addRow(
				new Object[] {
					g.getId(),
					g.getGenero()
			});
	}
}