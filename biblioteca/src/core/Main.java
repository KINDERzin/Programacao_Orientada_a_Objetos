package core;
import entidades.Biblioteca;
import entidades.Livro;
import java.util.Scanner;
import java.util.Date;

public class Main
{
    public static void main(String[] args)
    {
        Biblioteca biblioteca = new Biblioteca();
        Scanner leitor = new Scanner(System.in);
        public Integer opcao;
        do 
        {
            System.out.println("Bem-vindo à Biblioteca!");
            System.out.println("1. Listar Livros");
            System.out.println("2. Adicionar Livro");
            System.out.println("3. Apagar Livro");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Adicionar Usuário");
            System.out.println("6. Apagar Usuário");
            System.out.println("0. Sair");   
            
            // Lê a opção que o usuário inseriu
            opcao = leitor.nextInt();

            switch (opcao)
            {
                case 1:
                    // Listar Livros
                   System.out.println("=== LISTA DE LIVROS ===");
                    for (Livro livro : biblioteca.getLivros())
                    {
                        System.out.println("Título: " + livro.getTitulo());
                        System.out.println("Autor: " + livro.getAutor());
                        System.out.println("Gênero: " + livro.getGenero());
                        System.out.println("Editora: " + livro.getEditora());
                        System.out.println("Quantidade de Páginas: " + livro.getQuantidadePaginas());
                        System.out.println("Quantidade Disponível: " + livro.getQuantidadeDisponivel());
                        System.out.println("-------------------------");
                    }
                    break;
                case 2:
                    // Adicionar Livro
                    String titulo, autor, genero, editora, numeroLivro;
                    Integer quantidadePaginas, quantidadeDisponivel;
                    
                    System.out.println("=== CADASTRO DE LIVRO ===");
                    // TITULO DO LIVRO
                    System.out.println("Digite o título do livro:");
                    titulo = leitor.nextLine();
                    // AUTOR(A) DO LIVRO
                    System.out.println("Digite o autor do livro:");
                    autor = leitor.nextLine();
                    // GENERO DO LIVRO
                    System.out.println("Digite o gênero do livro:");
                    genero = leitor.nextLine();
                    // EDITORA DO LIVRO
                    System.out.println("Digite a editora do livro:");
                    editora = leitor.nextLine();
                    // NÚMERO DO LIVRO
                    System.out.println("Digite o número do livro:");
                    numeroLivro = leitor.nextLine();
                    // QUANTIDADE DE PÁGINAS DO LIVRO
                    System.out.println("Digite a quantidade de páginas do livro:");
                    do { 
                        quantidadePaginas = leitor.nextInt(); 
                        System.out.println("Quantidade inválida! Digite novamente."); 
                    } 
                    while (quantidadePaginas <= 0);
                    // QUANTIDADE DE LIVROS DISPONÍVEIS
                    System.out.println("Digite a quantidade disponível do livro:");
                    do 
                    { 
                        quantidadeDisponivel = leitor.nextInt(); 
                        System.out.println("Quantidade inválida! Digite novamente."); 
                    } 
                    while (quantidadeDisponivel < 0);
                    biblioteca.adicionarLivro(titulo, autor, genero, editora,  numeroLivro, quantidadePaginas, quantidadeDisponivel);
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 3:
                    // Apagar Livro
                    String NumeroLivro;

                    System.out.println("Insira o número do livro que deseja apagar:");
                    NumeroLivro = leitor.nextLine();

                    if(biblioteca.removerLivro(NumeroLivro))
                    {   
                        System.out.println("Livro removido com sucesso!");
                        break;
                    }
                    System.out.println("Livro não encontrado!");
                    break;
                case 4:
                    System.out.println("=== LISTA DE USUÁRIOS ===");
                    for (Usuario usuario : biblioteca.getUsuarios())
                    {
                        System.out.println("Nome: " + usuario.getNome());
                        System.out.println("Registro: " + usuario.getRegistro());
                        System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
                        System.out.println("Livros Emprestados: " + usuario.getLivrosEmprestados());
                        System.out.println("-------------------------");
                    }
                    // Listar Usuários
                    break;
                case 5:
                    // Adicionar Usuário
                    String nome, registro;
                    Date dataNascimento;

                    System.out.println("=== CADASTRO DE USUARIO ===");
                    System.out.println("Digite o nome do usuário:");
                    nome = leitor.nextLine();
                    System.out.println("Digite o registro do usuário:");
                    registro = leitor.nextLine();
                    System.out.println("Digite a data de nascimento do usuário (dd/MM/yyyy):");
                    String dataNascimentoStr = leitor.nextLine();

                    if(biblioteca.adicionarUsuario(nome, registro, dataNascimento))
                    {   System.out.println("Erro ao adicionar usuário! Registro já existente.");
                        break;
                    }

                    System.out.println("Usuário adicionado com sucesso!");
                    break;
                case 6:
                    // Apagar Usuário
                    String registro;

                    System.out.println("Insira o registro do usuário que deseja apagar:");
                    registro = leitor.nextLine();

                    if(biblioteca.removerUsuario(registro))
                    {   
                        System.out.println("Usuário removido com sucesso!");
                        break;
                    }
                    System.out.println("Usuário não encontrado!");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}