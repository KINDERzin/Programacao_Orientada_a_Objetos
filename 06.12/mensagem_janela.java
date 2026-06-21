import javax.swing.*;

public class mensagem_janela extends JFrame {
   
   private JLabel  label;
   private JButton button;
   private JPanel  panel;

   public mensagem_janela() {
      setTitle("Mensagem na Janela");
      setSize(300, 200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

      // Cria o painel, a label e o botão
      panel = new JPanel();
      label = new JLabel("Bem vindo ao sistema!");
      button = new JButton("Clique aqui");
      button.addActionListener(e -> label.setText("Botão clicado com sucesso!"));
      // Adiciona os elementos ao painel
      panel.add(label);
      panel.add(button);
      // Adiciona o painel à janela
      add(panel);
   }
   
   public static void main (String[] args) {
      SwingUtilities.invokeLater(() -> {
         mensagem_janela janela = new mensagem_janela();
         janela.setVisible(true);
      });
   }
}
