import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class contador_clicks extends JFrame{
   private JPanel  panel;
   private JLabel  label;
   private JButton botao;
   public Integer contador = 0;   
   
   public contador_clicks() {
      setTitle("Contador de clicks");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(200, 200);
      setLocationRelativeTo(null);

      panel = new JPanel();

      label = new JLabel("Cliques: 0");
      panel.add(label);

      botao = new JButton("Clique");
      botao.addActionListener(e -> {
         contador++;
         label.setText("Clique: " + contador);
      });
      panel.add(botao);

      add(panel);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         contador_clicks contador_clicks = new contador_clicks();
         contador_clicks.setVisible(true);
      });
   }
}