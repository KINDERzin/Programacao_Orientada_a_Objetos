import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class calculadora_botao extends JFrame{
   private JPanel     panel, panelSuperior, panelCentral;
   private JLabel     label, labelResultado;
   private JTextField campoNum1, campoNum2;
   private JButton    botaoSoma, botaoSubtrair, botaoMultiplicar, botaoDividir;

   public calculadora_botao() {
      setTitle("Calculadora");
      setSize(500, 300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      panel = new JPanel(new GridLayout(3, 4));
      panelSuperior = new JPanel();

      label = new JLabel("Número 1:");
      panelSuperior.add(label);

      campoNum1 = new JTextField();
      campoNum1.setPreferredSize(new Dimension(100, 30));
      panelSuperior.add(campoNum1);

      label = new JLabel("Número 2:");
      panelSuperior.add(label);

      campoNum2 = new JTextField();
      campoNum2.setPreferredSize(new Dimension(100, 30));
      panelSuperior.add(campoNum2);

      panel.add(panelSuperior);

      panelCentral = new JPanel();

      botaoSoma = new JButton("Somar");
      botaoSoma.addActionListener(e -> {
         Integer num1, num2;

         num1 = Integer.parseInt(campoNum1.getText());
         num2 = Integer.parseInt(campoNum2.getText());

         labelResultado.setText("Resultado: " + (num1 + num2));
      });
      panelCentral.add(botaoSoma);

      botaoSubtrair = new JButton("Subtrair");
      botaoSubtrair.addActionListener(e -> {
         Integer num1, num2;

         num1 = Integer.parseInt(campoNum1.getText());
         num2 = Integer.parseInt(campoNum2.getText());

         labelResultado.setText("Resultado: " + (num1 - num2));
      });
      panelCentral.add(botaoSubtrair);

      botaoMultiplicar = new JButton("Multiplicar");
      botaoMultiplicar.addActionListener(e -> {
         Integer num1, num2;

         num1 = Integer.parseInt(campoNum1.getText());
         num2 = Integer.parseInt(campoNum2.getText());

         labelResultado.setText("Resultado: " + (num1 * num2));
      });
      panelCentral.add(botaoMultiplicar);

      botaoDividir = new JButton("Dividir");
      botaoDividir.addActionListener(e -> {
         Integer num1, num2;

         num1 = Integer.parseInt(campoNum1.getText());
         num2 = Integer.parseInt(campoNum2.getText());

         if(num2 == 0) {
            labelResultado.setText("Não é possivel dividir por 0");
            return;
         }

         labelResultado.setText("Resultado: " + (num1 / num2));
      });
      panelCentral.add(botaoDividir);
      
      panel.add(panelCentral);

      labelResultado = new JLabel("Resultado:");
      panel.add(labelResultado);

      add(panel);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         calculadora_botao calculadora_botao = new calculadora_botao();
         calculadora_botao.setVisible(true);
      });
   }
   
}
