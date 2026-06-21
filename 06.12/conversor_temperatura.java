import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class conversor_temperatura extends JFrame{
   
   private JPanel     panel;
   private JLabel     label, labelResposta;
   private JTextField campoTexto;
   private JButton    botao;

   public conversor_temperatura() {
      setTitle("Conversor de temperatura");
      setSize(300, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      panel = new JPanel();

      label = new JLabel("Temperatura em ºC: ");
      panel.add(label);

      campoTexto = new JTextField();
      campoTexto.setPreferredSize(new Dimension(100, 30));
      panel.add(campoTexto);

      botao = new JButton("Converter");
      botao.addActionListener(e -> {
         Double fahrenheit = Double.parseDouble(campoTexto.getText()) * 1.8 + 32;
         
         labelResposta.setText("Fahrenheit: " + fahrenheit);
      });
      panel.add(botao);

      labelResposta = new JLabel("Fahrenheit:");
      panel.add(labelResposta);
      
      add(panel);
   }   

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         conversor_temperatura conversor_temperatura = new conversor_temperatura();
         conversor_temperatura.setVisible(true);
      });
   }
}
