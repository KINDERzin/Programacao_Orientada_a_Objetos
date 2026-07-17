package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Genero;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;

public class GeneroView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField generoTextField;
	private JButton btnExcluir;
	private JButton btnLimpar;
	private JButton btnNovo;
	private JButton btnSalvar;
	private DefaultTableModel generoTableModel;
	private JMenuItem filmeMenuItem;
	private JMenuItem atorMenuItem;
	private JMenuItem generoMenuItem;
	private JTable table_1;
	private JTable generoTable;

	public GeneroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		filmeMenuItem = new JMenuItem("Filme");
		menuBar.add(filmeMenuItem);
		
		atorMenuItem = new JMenuItem("Ator/Atriz");
		menuBar.add(atorMenuItem);
		
		generoMenuItem = new JMenuItem("Gênero");
		menuBar.add(generoMenuItem);
		
		JLabel labelPage = new JLabel("Cadastro de Gênero");
		labelPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelPage.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPage.setBounds(145, 51, 151, 25);
		contentPane.add(labelPage);
		
		JLabel labelId = new JLabel("ID: ");
		labelId.setHorizontalAlignment(SwingConstants.LEFT);
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelId.setBounds(10, 54, 50, 25);
		contentPane.add(labelId);
		
		idTextField = new JTextField();
		idTextField.setEnabled(false);
		idTextField.setEditable(false);
		idTextField.setColumns(10);
		idTextField.setBounds(61, 57, 50, 20);
		contentPane.add(idTextField);
		
		JLabel lblGenero = new JLabel("Gênero: ");
		lblGenero.setHorizontalAlignment(SwingConstants.LEFT);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGenero.setBounds(10, 83, 50, 25);
		contentPane.add(lblGenero);
		
		generoTextField = new JTextField();
		generoTextField.setColumns(10);
		generoTextField.setBounds(61, 86, 86, 20);
		contentPane.add(generoTextField);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(335, 87, 89, 23);
		contentPane.add(btnExcluir);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(335, 62, 89, 23);
		contentPane.add(btnLimpar);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(335, 37, 89, 23);
		contentPane.add(btnNovo);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(335, 14, 89, 23);
		contentPane.add(btnSalvar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 414, 91);
		contentPane.add(scrollPane);
		
		generoTable = new JTable();
		scrollPane.setViewportView(generoTable);
		
		generoTableModel = new DefaultTableModel(new Object[] {"ID", "Gênero"}, 0);
	}
	
	public JMenuItem getFilmeMenuItem() { return filmeMenuItem; }
	public void setFilmeMenuItem(JMenuItem menu) {
		this.filmeMenuItem = menu;
	}
	
	public JMenuItem getAtorMenuItem() { return atorMenuItem; }
	public void setAtorMenuItem(JMenuItem menu) {
		this.atorMenuItem = menu;
	}
	
	public JMenuItem getGeneroMenuItem() { return generoMenuItem; }
	public void setGeneroMenuItem(JMenuItem menu) {
		this.generoMenuItem = menu;
	}
	
	public DefaultTableModel getGeneroTableModel() { return this.generoTableModel; }
	public void setGeneroTableModel(DefaultTableModel model) {
		this.generoTableModel = model;
	}
	
	public JTable getGeneroTable() { return this.generoTable; }
	public void setGeneroTable(JTable t) {
		this.generoTable = t;
	}

	public JTextField getIdTextField() { return idTextField; }
	public void setIdTextField(JTextField idTextField) {
		this.idTextField = idTextField;
	}

	public JTextField getGeneroTextField() { return generoTextField; }
	public void setGeneroTextField(JTextField generoTextField) {
		this.generoTextField = generoTextField;
	}

	public JButton getBtnExcluir() { return btnExcluir; }
	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public JButton getBtnLimpar() { return btnLimpar; }
	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}

	public JButton getBtnNovo() { return btnNovo; }
	public void setBtnNovo(JButton btnNovo) {
		this.btnNovo = btnNovo;
	}

	public JButton getBtnSalvar() { return btnSalvar; }
	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}
}