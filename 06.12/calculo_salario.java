import java.awt.Dimension;
import javax.swing.*;

public class calculo_salario extends JFrame{
   private JPanel     panel;
   private JLabel     label, labelResposta;
   private JTextField campoHoras, campoValorHora;
   private JButton    botao;
   
   public calculo_salario() {
      setTitle("Calculo de salário");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(300, 300);
      setLocationRelativeTo(null);

      panel = new JPanel();

      label = new JLabel("Horas trabalhadas: ");
      panel.add(label);
      
      campoHoras = new JTextField();
      campoHoras.setPreferredSize(new Dimension(100, 30));
      panel.add(campoHoras);
      
      label = new JLabel("Valor hora: ");
      panel.add(label);
      
      campoValorHora = new JTextField();
      campoValorHora.setPreferredSize(new Dimension(100, 30));
      panel.add(campoValorHora);
      
      botao = new JButton("Calcular salário");
      botao.addActionListener(e -> {
         Double salario = Double.parseDouble(campoHoras.getText()) * Double.parseDouble(campoValorHora.getText());
         labelResposta.setText("Salário bruto: " + salario);
      });
      panel.add(botao);

      labelResposta = new JLabel("Salário bruto:");
      panel.add(labelResposta);

      add(panel);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         calculo_salario calculo_salario = new calculo_salario();
         calculo_salario.setVisible(true);
      });
   }
}
