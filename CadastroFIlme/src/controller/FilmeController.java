package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Ator;
import model.Filme;
import model.Genero;
import view.FilmeView;
import repository.AtorRepository;
import repository.FilmeRepository;
import repository.GeneroRepository;

public class FilmeController {
	private List<Filme> filmes = new ArrayList<>();
	private List<Ator> atores = new ArrayList<>();
	private List<Genero> generos = new ArrayList<>();
	private FilmeRepository repository;
	private FilmeView view;
	
	public FilmeController(FilmeView view, FilmeRepository repository) {
		this.view = view;
		this.repository = repository;
		
		Configurar_Eventos();
	}
	
	public List<Filme> listarFilmes() { return this.filmes; }
	
	public void Configurar_Eventos() {
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
				System.out.println("Opa");
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
				CarregarFilmeSelecionado();
			}
		});
		// Popula o modelo que será passado para a lista
		for(int i = 0; i < atores.size(); i++) {
			view.getAtorListaModelo().add(i, atores.get(i));			
		}
		// Seta os valores da lista
		view.setAtorList(view.getAtorListaModelo());
	}
	
	public void CarregarFilmeSelecionado() {
		int linhaSelecionada = view.getTableFilmes().getSelectedRow();	
		
		if(linhaSelecionada == -1) 
			throw new IllegalAccessError("Linha selecionada inválida!");
		
		view.getExcluirButton().setEnabled(true);
		
		int linhaModelo = view.getTableFilmes().convertColumnIndexToModel(linhaSelecionada);
		Integer id = (Integer) view.getTabelaFilmesModel().getValueAt(linhaModelo, 0);

		this.repository.buscarPorId(id).ifPresent(this::PreencherCampos);
	}
	
	public void PreencherCampos(Filme filme) {
		view.getTextFieldTitulo().setText(filme.getTitulo());
		view.getComboBoxGenero().setSelectedItem(filme.getGenero());
		view.getSpinnerDuracao().setValue(filme.getDuracao());
		view.getTextFieldId().setText(filme.getId().toString());
		
	}
	
	public void LimparCampos() {
		view.getTextFieldTitulo().setText("");
		view.getComboBoxGenero().setSelectedItem(null);
		view.getSpinnerDuracao().setValue(1);
		view.getTextFieldId().setText("");
		view.getExcluirButton().setEnabled(false);
	}
	
	public void ExcluirFilme() {
		String id = view.getTextFieldId().getText();
		
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
		
		if(genero.equals(null))
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
					f.getGenero(),
					f.getDuracao()
			});
		}
	}
	
	public void NovoFilme() {
		LimparCampos();		
	}
}