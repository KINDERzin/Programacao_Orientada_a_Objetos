import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class simulador_desconto extends JFrame {
   private JPanel     panel;
   private JLabel     labelProduto, labelValor, labeldesconto, labelResposta;
   private JTextField campoProtudo, campoValor,  campoDesconto;
   private JButton    botao;

   public simulador_desconto() {
      setTitle("Simulador de desconto");
      setSize(500, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      panel = new JPanel();

      labelProduto = new JLabel("Produto: ");
      panel.add(labelProduto);

      campoProtudo = new JTextField();
      campoProtudo.setPreferredSize(new Dimension(100, 30));
      panel.add(campoProtudo);

      labelValor = new JLabel("Preço: ");
      panel.add(labelValor);

      campoValor = new JTextField();
      campoValor.setPreferredSize(new Dimension(100, 30));
      panel.add(campoValor);

      labeldesconto = new JLabel("Desconto (%): ");
      panel.add(labeldesconto);

      campoDesconto = new JTextField();
      campoDesconto.setPreferredSize(new Dimension(100, 30));
      panel.add(campoDesconto);

      botao = new JButton("Calcular desconto");
      botao.addActionListener(e -> {
         Double preco, desconto, novoPreco;
         preco = Double.parseDouble(campoValor.getText());
         desconto = Double.parseDouble(campoDesconto.getText()) / 100;
         novoPreco = preco - (preco * desconto);

         labelResposta.setText("Produto: " + campoProtudo.getText() + " | Valor final: R$" + novoPreco);
      });
      panel.add(botao);

      labelResposta = new JLabel();
      panel.add(labelResposta);

      add(panel);
   }

   public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
         simulador_desconto simulador_desconto = new simulador_desconto();
         simulador_desconto.setVisible(true);
       });
   }
}