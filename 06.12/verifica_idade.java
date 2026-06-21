import java.awt.Dimension;
import javax.swing.*;

public class verifica_idade extends  JFrame{
   private JPanel     panel;
   private JLabel     label, labelResposta;
   private JButton    botao;
   private JTextField campoTexto;

   public verifica_idade() {
      setTitle("Verificação de idade");
      setSize(300, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      panel = new JPanel();

      label = new JLabel("Idade: ");
      panel.add(label);

      campoTexto = new JTextField();
      campoTexto.setPreferredSize(new Dimension(100, 30));
      panel.add(campoTexto);

      botao = new JButton("Verificar");
      botao.addActionListener(e -> {
         if(Integer.parseInt(campoTexto.getText()) < 18) {
            labelResposta.setText("Menor de idade");
            return;
         }   

         labelResposta.setText("Maior de idade");
      });
      panel.add(botao);

      labelResposta = new JLabel();
      panel.add(labelResposta);
      
      add(panel);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         verifica_idade verifica_idade = new verifica_idade();
         verifica_idade.setVisible(true);   
      });
   }
}
