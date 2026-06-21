import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class saudacao extends JFrame {

   private JLabel     label, labelResultado;
   private JPanel     panel, panelSuperior, panelInferior;
   private JButton    botao;
   private JTextField campoTexto;

   public saudacao() {
      setTitle("Saudação");
      setSize(350, 200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      panel = new JPanel(new GridLayout(2, 1)); // Painel principal

      panelSuperior = new JPanel();
      // Cria, formata e adiciona os elemento ao painel
      // JLabel
      label = new JLabel("Digite seu nome: ");
      panelSuperior.add(label);
      // JTextField
      campoTexto = new JTextField();
      campoTexto.setPreferredSize(new Dimension(100, 30));
      panelSuperior.add(campoTexto);
      // JButton
      botao = new JButton();
      botao.setText("Enviar");
      botao.addActionListener(e -> {
         labelResultado.setText("Olá, " + campoTexto.getText() + "!");
      });
      panelSuperior.add(botao);

      panel.add(panelSuperior, CENTER_ALIGNMENT);

      panelInferior = new JPanel();
      // JLabel - resulado
      labelResultado = new JLabel();
      labelResultado.setSize(10, 5);
      panelInferior.add(labelResultado);
      
      panel.add(panelInferior, CENTER_ALIGNMENT);

      add(panel);
   }
   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         saudacao saudacao = new saudacao();
         saudacao.setVisible(true);
      });
   }   
}
