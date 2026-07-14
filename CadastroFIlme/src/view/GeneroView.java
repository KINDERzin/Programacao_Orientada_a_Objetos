package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class GeneroView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public GeneroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(191, 122, 89, 23);
		contentPane.add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 414, 91);
		contentPane.add(scrollPane);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(191, 97, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(191, 72, 89, 23);
		contentPane.add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(191, 47, 89, 23);
		contentPane.add(btnSalvar);
		
		JLabel labelPage = new JLabel("Cadastro de Filme");
		labelPage.setHorizontalAlignment(SwingConstants.CENTER);
		labelPage.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPage.setBounds(136, 11, 151, 25);
		contentPane.add(labelPage);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(61, 57, 50, 20);
		contentPane.add(textField);
		
		JLabel labelId = new JLabel("ID: ");
		labelId.setHorizontalAlignment(SwingConstants.LEFT);
		labelId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelId.setBounds(10, 54, 50, 25);
		contentPane.add(labelId);
		
		JLabel lblGenero = new JLabel("Gênero: ");
		lblGenero.setHorizontalAlignment(SwingConstants.LEFT);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGenero.setBounds(10, 83, 50, 25);
		contentPane.add(lblGenero);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(61, 86, 86, 20);
		contentPane.add(textField_1);

	}

}
