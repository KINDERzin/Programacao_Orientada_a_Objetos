package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.ArrayList;

import repository.GeneroRepository;
import repository.FilmeRepository;
import repository.AtorRepository;
import view.GeneroView;
import view.FilmeView;
import view.AtorView;
import model.Genero;

public class GeneroController {
	private List<Genero> generos = new ArrayList<>();
	private GeneroRepository repository;
	private GeneroView view;
	
	public GeneroController(GeneroView view, GeneroRepository repository) {
		this.view = view;
		this.repository = repository;
		configurarEventos();
	}
	
	public List<Genero> listarGeneros() { return this.generos; }
	
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
		
		view.getGeneroTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				carregarGeneroSelecionado();
			}
		});	
	}
	
	public void carregarGeneroSelecionado() {
		int linhaSelecionada = view.getGeneroTable().getSelectedRow();
		
		if(linhaSelecionada == -1)
			throw new IllegalArgumentException("Linha selecionada inválida!");
		
		view.getBtnExcluir().setEnabled(true);
		
		int linhaModelo = view.getGeneroTable().convertColumnIndexToModel(linhaSelecionada);
		Integer id = (Integer) view.getGeneroTableModel().getValueAt(linhaModelo, 0);
		
		this.repository.buscarPorId(id).ifPresent(this::preencherCampos);
	}
	
	public void preencherCampos(Genero g) {
		view.getGeneroTextField().setText(g.getGenero());
		view.getIdTextField().setText(g.getId().toString());
	}
	
	public void abrirTelaFilme() {
		FilmeView filmeView = new FilmeView();
		FilmeRepository filmeRepository = new FilmeRepository();
		new FilmeController(filmeView, filmeRepository);
		filmeView.setVisible(true);
		view.dispose();
	}
	
	public void abrirTelaAtor() {
		AtorView atorView = new AtorView();
		AtorRepository atorRepository = new AtorRepository();
		new AtorController(atorView, atorRepository);
		atorView.setVisible(true);
		view.dispose();
	}
	
	public void salvarGenero() {
		System.out.println("salvarGenero");
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
		
		repository.excluir(Integer.parseInt(id));
		
		limparCampos();
		montarTabela();
	}
	
	public void limparCampos() {
		view.getGeneroTextField().setText("");
		view.getIdTextField().setText("");
		view.getBtnExcluir().setEnabled(false);
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