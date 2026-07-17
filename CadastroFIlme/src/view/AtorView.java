package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AtorView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField  idTextField;
	private JTextField  nomeTextField;
	private JButton     btnSalvar;
	private JButton     btnNovo;
	private JButton     btnLimpar;  
	private JButton     btnExcluir;
	private JScrollPane scrollPane;
	private JTable      table;
	private DefaultTableModel atorTableModel;
	private JMenuItem   filmeMenuItem;
	private JMenuItem   atorMenuItem;
	private JMenuItem   generoMenuItem;

	public AtorView() {
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
		
		JLabel labelPage = new JLabel("Cadastro de Ator/Atriz");
		labelPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelPage.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPage.setBounds(136, 11, 151, 25);
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
		
		JLabel labelNome = new JLabel("Nome: ");
		labelNome.setHorizontalAlignment(SwingConstants.LEFT);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNome.setBounds(10, 83, 50, 25);
		contentPane.add(labelNome);
		
		nomeTextField = new JTextField();
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(61, 86, 86, 20);
		contentPane.add(nomeTextField);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(191, 47, 89, 23);
		contentPane.add(btnSalvar);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(191, 72, 89, 23);
		contentPane.add(btnNovo);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(191, 97, 89, 23);
		contentPane.add(btnLimpar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(191, 122, 89, 23);
		contentPane.add(btnExcluir);

		atorTableModel = new DefaultTableModel(new Object[] {"ID", "Nome"}, 0);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 414, 91);
		contentPane.add(scrollPane);
		
		table = new JTable(atorTableModel);
		scrollPane.setViewportView(table);
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
	
	public JTextField getIdTextField() { return idTextField; }
	public void setIdTextField(JTextField idTextField) {
		this.idTextField = idTextField;
	}
	public JTextField getNomeTextField() { return nomeTextField; }
	public void setNomeTextField(JTextField nomeTextField) {
		this.nomeTextField = nomeTextField;
	}
	public JButton getBtnSalvar() { return btnSalvar; }
	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}
	public JButton getBtnNovo() { return btnNovo; }
	public void setBtnNovo(JButton btnNovo) {
		this.btnNovo = btnNovo;
	}
	public JButton getBtnLimpar() { return btnLimpar; }
	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}
	public JButton getBtnExcluir() { return btnExcluir; }
	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
	}
	public JTable getTable() { return table; }
	public void setTable(JTable table) {
		this.table = table;
	}
	public DefaultTableModel getAtorTableModel() { return atorTableModel; }
	public void setAtorTableModel(DefaultTableModel atorTableModel) {
		this.atorTableModel = atorTableModel;
	}
}