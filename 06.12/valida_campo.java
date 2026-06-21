
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class valida_campo extends JFrame{
   private JPanel     panel;
   private JLabel     label, labelResposta;
   private JTextField campoTexto;
   private JButton    botao;

   public valida_campo() {
      setTitle("Campo obrigatório");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400, 400);
      setLocationRelativeTo(null);

      panel = new JPanel();

      label = new JLabel("Nome: ");
      panel.add(label);

      campoTexto = new JTextField();
      campoTexto.setPreferredSize(new Dimension(100, 30));
      panel.add(campoTexto);

      botao = new JButton("Cadastrar");
      botao.addActionListener(e -> {
         String nome = campoTexto.getText().trim();

         if(nome.isBlank())
            labelResposta.setText("O nome é obrtigatório");
         else 
            labelResposta.setText("");
      });
      panel.add(botao);

      labelResposta = new JLabel();
      panel.add(labelResposta);

      add(panel);
   }

   public static void main(String[] args) {
      valida_campo valida_campo = new valida_campo();
      valida_campo.setVisible(true);
   }
}
