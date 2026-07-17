package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Ator;
import model.Filme;
import model.Genero;
import view.AtorView;
import view.FilmeView;
import view.GeneroView;
import repository.AtorRepository;
import repository.FilmeRepository;
import repository.GeneroRepository;

public class FilmeController {
	private FilmeRepository repository;
	private AtorRepository atorRepository;
	private GeneroRepository generoRepository;
	private FilmeView view;

	public FilmeController(FilmeView view, FilmeRepository repository) {
		this(view, repository, new AtorRepository(), new GeneroRepository());
	}

	public FilmeController(FilmeView view, FilmeRepository repository, AtorRepository atorRepository, GeneroRepository generoRepository) {
		this.view = view;
		this.repository = repository;
		this.atorRepository = atorRepository;
		this.generoRepository = generoRepository;

		Configurar_Eventos();
		CarregarGenerosEAtores();
		MontarTabela();
		LimparCampos();
	}

	public List<Filme> listarFilmes() { return this.repository.listarFilmes(); }

	public void Configurar_Eventos() {

		view.getAtorMenuItem().addActionListener(e -> {
			try {
				abrirTelaAtor();
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		view.getGeneroMenuItem().addActionListener(e -> {
			try {
				abrirTelaGenero();
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});

		// Eventos do botão LIMPAR
		view.getLimparButton().addActionListener(e ->  {
			try { LimparCampos(); }
			catch (Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		// Eventos do botão EXCLUIR
		view.getExcluirButton().addActionListener(e ->  {
			try { ExcluirFilme(); }
			catch (Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		// Eventos do botão SALVAR
		view.getSalvarButton().addActionListener(e ->  {
			try { SalvarFilme(); }
			catch (Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		// Eventos do botão NOVO
		view.getNovoButton().addActionListener(e ->  {
			try { NovoFilme(); }
			catch (Exception ex) {
				JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		// Evento da seleção do filme na tabela
		view.getTableFilmes().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					try { CarregarFilmeSelecionado(); }
					catch(Exception ex) {
						JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}

	public void CarregarGenerosEAtores() {
		view.getComboBoxGenero().removeAllItems();
		for(Genero g : generoRepository.listarGeneros())
			view.getComboBoxGenero().addItem(g);

		view.getAtorListaModelo().clear();
		for(Ator a : atorRepository.listarAtores())
			view.getAtorListaModelo().addElement(a);
	}

	public void abrirTelaAtor() {
		AtorView atorView = new AtorView();
		new AtorController(atorView, atorRepository, repository, generoRepository);
		atorView.setVisible(true);
		view.dispose();
	}

	public void abrirTelaGenero() {
		GeneroView generoView = new GeneroView();
		new GeneroController(generoView, generoRepository, atorRepository, repository);
		generoView.setVisible(true);
		view.dispose();
	}

	public void CarregarFilmeSelecionado() {
		int linhaSelecionada = view.getTableFilmes().getSelectedRow();

		if(linhaSelecionada == -1)
			return;

		int linhaModelo = view.getTableFilmes().convertRowIndexToModel(linhaSelecionada);
		Integer id = (Integer) view.getTabelaFilmesModel().getValueAt(linhaModelo, 0);

		this.repository.buscarPorId(id).ifPresent(this::PreencherCampos);
		view.getExcluirButton().setEnabled(true);
	}

	public void PreencherCampos(Filme filme) {
		view.getTextFieldTitulo().setText(filme.getTitulo());
		view.getComboBoxGenero().setSelectedItem(filme.getGenero());
		view.getSpinnerDuracao().setValue(filme.getDuracao());
		view.getTextFieldId().setText(String.valueOf(filme.getId()));

		List<Integer> indices = new ArrayList<>();
		for(int i = 0; i < view.getAtorListaModelo().size(); i++) {
			Ator atorLista = view.getAtorListaModelo().get(i);
			boolean selecionado = filme.getAtores().stream()
					.anyMatch(a -> a.getId() == atorLista.getId());
			if(selecionado)
				indices.add(i);
		}
		int[] indicesArray = indices.stream().mapToInt(Integer::intValue).toArray();
		view.getAtorList().setSelectedIndices(indicesArray);
	}

	public void LimparCampos() {
		view.getTextFieldTitulo().setText("");
		view.getComboBoxGenero().setSelectedItem(null);
		view.getSpinnerDuracao().setValue(1);
		view.getTextFieldId().setText("");
		view.getAtorList().clearSelection();
		view.getExcluirButton().setEnabled(false);
	}

	public void ExcluirFilme() {
		String id = view.getTextFieldId().getText();

		if(id.isBlank())
			throw new IllegalArgumentException("Selecione um filme para excluir!");

		repository.excluir(Integer.parseInt(id));

		LimparCampos();
		MontarTabela();
	}

	public void SalvarFilme() {		
		String id = view.getTextFieldId().getText();		
		String titulo = view.getTextFieldTitulo().getText();
		Genero genero = (Genero) view.getComboBoxGenero().getSelectedItem();
		Integer duracao = (Integer) view.getSpinnerDuracao().getValue();
		List<Ator> atores = new ArrayList<>(view.getAtorList().getSelectedValuesList());

		if(titulo.isBlank())
			throw new IllegalArgumentException("Insira um título válido!");
		
		if(genero == null)
			throw new IllegalArgumentException("Insira um gênero válido!");
		
		if(duracao < 1)
			throw new IllegalArgumentException("Insira uma duração válida!");

		if(atores.size() < 1)
			throw new IllegalArgumentException("Quantidade de atores inválida!");
		
		Filme filme = new Filme();
		
		filme.setTitulo(titulo);
		filme.setGenero(genero);
		filme.setDuracao(duracao);
		filme.setAtores(atores);
		
		if(id.equals("")) {
			repository.adicionarFilme(filme);
		}
		else {
			filme.setId(Integer.parseInt(id));
			repository.atualizar(filme);
		}
		
		LimparCampos();
		MontarTabela();
	}
	
	public void MontarTabela() {
		view.getTabelaFilmesModel().setRowCount(0);
		
		for(Filme f : repository.listarFilmes()) {			
			view.getTabelaFilmesModel().addRow(
				new Object[] {
					f.getId(),
					f.getTitulo(),
					f.getGenero().getGenero(),
					f.getDuracao(),
					f.getAtores().size()
			});
		}
	}
	
	public void NovoFilme() {
		LimparCampos();		
	}
}