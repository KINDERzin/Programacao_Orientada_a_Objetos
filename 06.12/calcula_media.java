import java.awt.Dimension;
import javax.swing.*;

public class calcula_media extends JFrame{

   private JPanel     panel, panelSuperior, panelInferior;
   private JLabel     label1, label2, labelResultado;
   private JTextField campoTexto1, campoTexto2;
   private JButton    botao; 

   public calcula_media() {
      setTitle("Calculadora de média");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400, 400);
      setLocationRelativeTo(null);

      panel = new JPanel();

      panelSuperior = new JPanel();

      label1 = new JLabel("Nota 01: ");
      panelSuperior.add(label1);

      campoTexto1 = new JTextField();
      campoTexto1.setPreferredSize(new Dimension(100, 30));
      panelSuperior.add(campoTexto1);

      label2 = new JLabel("Nota 02: ");
      panelSuperior.add(label2);
      
      campoTexto2 = new JTextField();
      campoTexto2.setPreferredSize(new Dimension(100, 30));
      panelSuperior.add(campoTexto2);

      panel.add(panelSuperior);

      panelInferior = new JPanel();

      botao = new JButton("Calcular");
      botao.addActionListener(e -> {
         Double nota1, nota2;

         nota1 = Double.parseDouble(campoTexto1.getText());
         nota2 = Double.parseDouble(campoTexto2.getText());
         
         labelResultado.setText("Média: " + (nota1 + nota2) / 2.0);
      });
      panelInferior.add(botao);

      labelResultado = new JLabel("Resultado");
      panelInferior.add(labelResultado);

      panel.add(panelInferior);

      add(panel);
   }
   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         calcula_media calcula_media = new calcula_media();
         calcula_media.setVisible(true);
      });
   }
}
