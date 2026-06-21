import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class soma_numeros extends JFrame{
   private JPanel     panel, panelSuperior, panelInferior;   
   private JLabel     label1, label2, labelResultado;
   private JTextField campoTexto1, campoTexto2;
   private JButton    botao;

   public soma_numeros() {
      setTitle("Somando os números");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(200, 200);
      setLocationRelativeTo(null);

      panel = new JPanel(new GridLayout(2, 2));
      
      panelSuperior = new JPanel();

      label1 = new JLabel("Número 01:");
      panelSuperior.add(label1);
      
      campoTexto1 = new JTextField();
      campoTexto1.setPreferredSize(new Dimension(100, 30));
      panelSuperior.add(campoTexto1);
      
      label2 = new JLabel("Número 02:");
      panelSuperior.add(label2);
      
      campoTexto2 = new JTextField();
      campoTexto2.setPreferredSize(new Dimension(100, 30));
      panelSuperior.add(campoTexto2);

      panel.add(panelSuperior);

      panelInferior = new JPanel();
      
      botao = new JButton("Somar");
      botao.addActionListener(e -> {
         Integer num1, num2;

         num1 = Integer.parseInt(campoTexto1.getText());
         num2 = Integer.parseInt(campoTexto2.getText());

         labelResultado.setText("Resultado: " + (num1 + num2));
      });
      panelInferior.add(botao);

      labelResultado = new JLabel("Resultado:");
      panelInferior.add(labelResultado);

      panel.add(panelInferior);

      add(panel);
   }

   public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
         soma_numeros soma = new soma_numeros();
         soma.setVisible(true);
       });
   }
}
