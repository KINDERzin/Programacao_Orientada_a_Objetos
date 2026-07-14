package view;

import java.awt.EventQueue;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JList;

import model.Ator;

public class FilmeView extends JFrame {
	
	private DefaultTableModel tableFilmesModel;
	private JPanel      contentPane;
	private JLabel      labelPage;
	private JLabel      labelId;
	private JLabel      labelTitulo;
	private JLabel      labelGenero;
	private JLabel      labelDuracao;
	private JComboBox   comboBoxGenero;
	private JButton     btnExcluir;
	private JButton     btnLimpar;
	private JButton     btnNovo;
	private JButton     btnSalvar;
	private JSpinner    spinnerDuracao;
	private JTextField  textFieldTitulo;
	private JTextField  textFieldId;
	private JTable      table_1;
	private JTable      tableFilmes;
	private JList<Ator> atorList;
	private DefaultListModel<Ator> atorListaModelo;

	
	public FilmeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelPage = new JLabel("Cadastro de Filme");
		labelPage.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelPage.setBounds(136, 11, 151, 25);
		contentPane.add(labelPage);

		labelId = new JLabel("ID: ");
		labelId.setHorizontalAlignment(SwingConstants.LEFT);
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelId.setBounds(10, 36, 50, 25);
		contentPane.add(labelId);
		
		textFieldId = new JTextField();
		textFieldId.setEnabled(false);
		textFieldId.setEditable(false);
		textFieldId.setColumns(10);
		textFieldId.setBounds(61, 39, 50, 20);
		contentPane.add(textFieldId);
		
		labelTitulo = new JLabel("Título: ");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		labelTitulo.setBounds(10, 59, 50, 25);
		contentPane.add(labelTitulo);
		
		labelGenero = new JLabel("Gênero: ");
		labelGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelGenero.setHorizontalAlignment(SwingConstants.LEFT);
		labelGenero.setBounds(10, 82, 50, 25);
		contentPane.add(labelGenero);
		
		labelDuracao = new JLabel("Duração:");
		labelDuracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelDuracao.setHorizontalAlignment(SwingConstants.LEFT);
		labelDuracao.setBounds(10, 105, 50, 25);
		contentPane.add(labelDuracao);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(61, 62, 86, 20);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		spinnerDuracao = new JSpinner();
		spinnerDuracao.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerDuracao.setBounds(61, 108, 85, 20);
		contentPane.add(spinnerDuracao);
		
		tableFilmesModel = new DefaultTableModel(new Object[] {"ID", "Título", "Gênero", "Duração", "Atores"}, 0);
		
		comboBoxGenero = new JComboBox();
		comboBoxGenero.setBounds(61, 84, 86, 22);
		contentPane.add(comboBoxGenero);
		
		JLabel labelAtor = new JLabel("Ator: ");
		labelAtor.setHorizontalAlignment(SwingConstants.LEFT);
		labelAtor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelAtor.setBounds(154, 56, 50, 25);
		contentPane.add(labelAtor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 414, 91);
		contentPane.add(scrollPane);
		
		tableFilmes = new JTable();
		scrollPane.setViewportView(tableFilmes);
		
		btnExcluir= new JButton("Excluir");
		btnExcluir.setBounds(335, 122, 89, 23);
		contentPane.add(btnExcluir);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(335, 97, 89, 23);
		contentPane.add(btnLimpar);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(335, 72, 89, 23);
		contentPane.add(btnNovo);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(335, 47, 89, 23);
		contentPane.add(btnSalvar);
		
		atorListaModelo = new DefaultListModel<Ator>();
		atorList = new JList<>(atorListaModelo);
		atorList.setBounds(202, 59, 120, 72);
		contentPane.add(atorList);
	}
	
	public DefaultTableModel getTabelaFilmesModel() { return this.tableFilmesModel; }
	public void setTabelaFilmesModel(DefaultTableModel filmesTableModel) {
		this.tableFilmesModel = filmesTableModel;
	}
	
	public JTable getTableFilmes() { return this.tableFilmes; }
	public void setTableFilmes(JTable table) {
		this.tableFilmes = table;
	}
	
	public JButton getSalvarButton() { return this.btnSalvar; }
	public void setSalvarButton(JButton button) {
		this.btnSalvar = button;
	}
	
	public JButton getNovoButton() { return this.btnNovo; }
	public void setNovoButton(JButton button) {
		this.btnNovo = button;
	}
	
	public JButton getLimparButton() { return this.btnLimpar; }
	public void setLimparButton(JButton button) {
		this.btnLimpar = button;
	}
	
	public JButton getExcluirButton() { return this.btnExcluir; }
	public void setExcluirButton(JButton button) {
		this.btnExcluir = button;
	}
	
	public JTextField getTextFieldTitulo() { return textFieldTitulo; }
	public void setTextFieldTitulo(JTextField textFieldTitulo) {
		this.textFieldTitulo = textFieldTitulo;
	}

	public JComboBox getComboBoxGenero() { return this.comboBoxGenero; }
	public void setTextFieldGenero(JComboBox comboBoxGenero) {
		this.comboBoxGenero= comboBoxGenero;
	}
	
	

	public JTextField getTextFieldId() { return textFieldId; }
	public void setTextFieldId(JTextField textFieldId) {
		this.textFieldId = textFieldId;
	}

	public JSpinner getSpinnerDuracao() { return this.spinnerDuracao; }
	public void setSpinnerDuracao(JSpinner spinnerDuracao) {
		this.spinnerDuracao = spinnerDuracao;
	}
	
	public JList<Ator> getAtorList() { return atorList; }
	public void setAtorList(DefaultListModel<Ator> atorListaModelo) {
		this.atorList = new JList<>(atorListaModelo);
	}

	public DefaultListModel<Ator> getAtorListaModelo() { return atorListaModelo; }
	public void setAtorListaModelo(DefaultListModel<Ator> atorListaModelo) {
		this.atorListaModelo = atorListaModelo;
	}
}
