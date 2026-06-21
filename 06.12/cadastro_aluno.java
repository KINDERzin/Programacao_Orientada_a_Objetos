
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class cadastro_aluno extends JFrame{
   private JPanel     panel;
   private JLabel     labelNome, labelNota, labelResposta;
   private JTextField campoNome, campoNota1, campoNota2;
   private JButton    botao;
   protected String   nome;
   protected Double   nota1, nota2;

   public cadastro_aluno() {
      setTitle("Cadastro aluno");
      setSize(500, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);


      panel = new JPanel();

      labelNome = new JLabel("Aluno: ");
      panel.add(labelNome);
      
      campoNome = new JTextField();
      campoNome.setPreferredSize(new Dimension(100, 30));
      panel.add(campoNome);

      labelNota = new JLabel("Nota 1: ");
      panel.add(labelNota);

      campoNota1 = new JTextField();
      campoNota1.setPreferredSize(new Dimension(100, 30));
      panel.add(campoNota1);

      labelNota = new JLabel("Nota 2: ");
      panel.add(labelNota);
      
      campoNota2 = new JTextField();
      campoNota2.setPreferredSize(new Dimension(100, 30));
      panel.add(campoNota2);

      botao = new JButton("Calcular situação");
      botao.addActionListener(e -> {
         Double media;
         String situacao;
         
         nome = campoNome.getText();
         nota1 = Double.parseDouble(campoNota1.getText());
         nota2 = Double.parseDouble(campoNota2.getText());
         media = (nota1 + nota2) / 2;
         if(media < 5.0)
            situacao = "Reprovado";
         else
            situacao = (media >= 7.0) ? "Aprovado" : "Recuperação";

         labelResposta.setText(nome + " - Média: " + media + " - " + situacao);
      });
      panel.add(botao);

      labelResposta = new JLabel();
      panel.add(labelResposta);

      add(panel);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         cadastro_aluno cadastro_aluno = new cadastro_aluno();
         cadastro_aluno.setVisible(true);
      });
   }
}