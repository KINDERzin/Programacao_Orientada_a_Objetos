import java.util.ArrayList;
import java.util.Scanner;


public class ex013 {
   
   public class Usuario {
      private String nome;
      private Integer idade;

      public Usuario(String nome, Integer idade) {
         setNome(nome);
         setIdade(idade);
      }

      public String getNome() {
         return nome;
      }

      public void setNome(String nome) {
         if(nome.isBlank()) {
            System.out.println("Nome inválido");
            return;
         }

         this.nome = nome;
      }

      public Integer getIdade() {
         return idade;
      }

      public void setIdade(Integer idade) {
         if(idade < 0) {
            System.out.println("Idade inválida");
            return;
         }

         this.idade = idade;
      }
   }

   public static void main (String[] args) throws InterruptedException{
      Scanner leitor = new Scanner(System.in);
      ArrayList<Usuario> usuarios = new ArrayList<>();
      Integer opcao;

      do {
         System.out.println("Menu:");
         System.out.println("1 - Cadastrar Usuário");
         System.out.println("2 - Listar Usuários");
         System.out.println("3 - Sair");
         
         System.out.println("Digite uma opção: ");
         opcao = leitor.nextInt();

         switch (opcao) {
            case 1:
               System.out.println("Cadastrar Usuário");
               
               System.out.print("Nome: ");
               String nome = leitor.next();
               
               System.out.print("Idade: ");
               Integer idade = leitor.nextInt();
               
               Usuario cadastro = new ex013().new Usuario(nome, idade);
               
               usuarios.add(cadastro);
               break;
            case 2:
               System.out.println("Listar Usuários");
               
               if(usuarios.isEmpty()) {
                  System.out.println("Nenhum usuário cadastrado");
                  break;
               }

               for (Usuario usuario : usuarios)
                  System.out.println("Nome: " + usuario.getNome() + "\nIdade: " + usuario.getIdade());
               
               break;
            case 3:
               String base = "Saindo";
               System.out.print(base);
               for (int i = 0; i < 3; i++) {
                  System.out.print(".");
                  Thread.sleep(200);
                  
                  System.out.print(".");
                  Thread.sleep(200);
                  
                  System.out.print(".");
                  Thread.sleep(200);
                  
                  // Apaga os 3 pontos para recomeçar o ciclo na mesma linha
                  System.out.print("\b\b\b   \b\b\b"); 
                  Thread.sleep(200);
               }
               
               System.out.print("...");
               break;
            default:
               System.out.println("Opção inválida");
         }

         System.out.println("\n");
      } while (opcao != 3);
   }
}
