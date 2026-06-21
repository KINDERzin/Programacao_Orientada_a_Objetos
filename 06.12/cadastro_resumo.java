
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class cadastro_resumo extends JFrame{
   private JPanel     panel;
   private JLabel     label, labelResposta;
   private JTextField nome, idade, curso, cidade;
   private JButton    botao;   

   public cadastro_resumo() {
      setTitle("Cadastro com resumo");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500, 500);
      setLocationRelativeTo(null);

      panel = new JPanel();

      label = new JLabel("Nome: ");
      panel.add(label);

      nome = new JTextField();
      nome.setPreferredSize(new Dimension(100, 30));
      panel.add(nome);

      label = new JLabel("Idade: ");
      panel.add(label);

      idade = new JTextField();
      idade.setPreferredSize(new Dimension(100, 30));
      panel.add(idade);

      label = new JLabel("Curso: ");
      panel.add(label);

      curso = new JTextField();
      curso.setPreferredSize(new Dimension(100, 30));
      panel.add(curso);

      label = new JLabel("Cidade: ");
      panel.add(label);

      cidade = new JTextField();
      cidade.setPreferredSize(new Dimension(100, 30));
      panel.add(cidade);

      botao = new JButton("Gerar resumo");
      botao.addActionListener(e -> {
         String name, age, course, city;

         name = nome.getText();
         age = idade.getText();
         course = curso.getText();
         city = cidade.getText();

         labelResposta.setText(name + " | " + age + " anos" + "\n Curso: " + course + "\n Cidade: " + city);
      });
      panel.add(botao);

      labelResposta = new JLabel();
      panel.add(labelResposta);

      add(panel);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         cadastro_resumo cadastro_resumo = new cadastro_resumo();
         cadastro_resumo.setVisible(true);
      });
   }
}
