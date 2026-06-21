import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class analise_numeros extends JFrame{

   private JPanel     panel;
   private JLabel     label, labelResposta;
   private JButton    botao;
   private JTextField campoTexto;

   public analise_numeros() {
      setTitle("Análise de números");
      setSize(300, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      panel = new JPanel();

      label = new JLabel("Insira um número");
      panel.add(label);

      campoTexto = new JTextField();
      campoTexto.setPreferredSize(new Dimension(100, 30));
      panel.add(campoTexto);

      botao = new JButton("Verificar");
      botao.addActionListener(e -> {
         Integer numero = Integer.parseInt(campoTexto.getText()); 
         if(numero != 0) {
            if(numero > 0) 
               { labelResposta.setText("Positivo"); }
            else 
               { labelResposta.setText("Negativo"); }            
            
            return;
         }

         labelResposta.setText("Zero");
      });
      panel.add(botao);

      labelResposta = new JLabel();
      panel.add(labelResposta);

      add(panel);
   }

   public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
         analise_numeros analise_numeros = new analise_numeros();
         analise_numeros.setVisible(true);
       });
   }
}
