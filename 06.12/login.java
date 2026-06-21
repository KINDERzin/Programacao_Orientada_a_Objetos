import java.awt.Dimension;
import javax.swing.*;

public class login extends JFrame {
   private JPanel     panel;
   private JLabel     label, labelResposta;
   private JTextField campoUsuario, campoSenha;
   private JButton    botao;
   
   public login() {
      setTitle("Login");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400, 400);
      setLocationRelativeTo(null);

      panel = new JPanel();
      
      label = new JLabel("Usuário: ");
      panel.add(label);

      campoUsuario = new JTextField();
      campoUsuario.setPreferredSize(new Dimension(100, 30));
      panel.add(campoUsuario);
      
      label = new JLabel("Senha: ");
      panel.add(label);
      
      campoSenha = new JTextField();
      campoSenha.setPreferredSize(new Dimension(100, 30));
      panel.add(campoSenha);

      botao = new JButton("Login");
      botao.addActionListener(e -> {
         String usuario, senha;
         
         usuario = campoUsuario.getText().trim();
         senha = campoSenha.getText();

         if (usuario.equals("admin") && senha.equals("1234"))
            labelResposta.setText("Login realizado com sucesso!");
         else
            labelResposta.setText("Usuário ou senha inválidos!");
      });
      panel.add(botao);

      labelResposta = new JLabel();
      panel.add(labelResposta);

      add(panel);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         login login = new login();
         login.setVisible(true);
      });
   }
}
