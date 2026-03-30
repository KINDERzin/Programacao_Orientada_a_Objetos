// Pasta core - Necesário em todo arquivo para refernciar os arquivos do projeto
package core;

// OUTRAS IMPORTAÇÕES NECESSÁRIAS PARA O FUNCIONAMENTO DO PROJETO
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
// CLASSES
import entidades.Biblioteca;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;

public class Main {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        Biblioteca biblioteca = new Biblioteca();
        Integer opcao;

        do {

            System.out.println("\n==== BEM VINDO(A) À BIBLIOTECA ====\n");
            System.out.println(" 1. Listar Livros");
            System.out.println(" 2. Listar Livros disponíveis");
            System.out.println(" 3. Listar Livros indisponíveis");
            System.out.println(" 4. Adicionar Livro");
            System.out.println(" 5. Apagar Livro");
            System.out.println(" 6. Listar Usuários");
            System.out.println(" 7. Adicionar Usuário");
            System.out.println(" 8. Apagar Usuário");
            System.out.println(" 9. Listar Emprestimos ativos");
            System.out.println(" 10. Listar Emprestimos finalizados");
            System.out.println(" 11. Listar Emprestimo de um Usuario:");
            System.out.println(" 12. Realizar Empréstimo");
            System.out.println(" 13. Realizar Devolução");
            System.out.println(" 0. Sair");

            System.out.println("\n- Insira a opção desejada: ");
            // Garante que a opção seja um numero inteiro
            do {
                // Se a pesoa nao colocar valor o projeto não quebra
                try {
                    opcao = Integer.parseInt(leitor.nextLine());
                } catch (NumberFormatException e) {
                    // Qualquer tipo de erro na conversão do valor para inteiro, o projeto não quebra, e a pessoa é avisada do erro
                    System.out.println("Opção inválida! Digite um número inteiro.");
                    opcao = null;
                    continue;
                }

                if (opcao == null)
                    System.out.println("Opção inválida! Digite novamente.");

            } while (opcao == null);

            switch (opcao) {

                case 1: // === LISTA OS LIVROS ===
                {
                    System.out.println("\n========= LISTA DE LIVROS =========\n");
                    // Verifica se a lista de livros está vazia
                    if (biblioteca.getLivros().isEmpty()) {
                        System.out.println("- Nenhum livro cadastrado!");
                        break;
                    }

                    biblioteca.getLivros().stream()
                        .forEach(livro -> {
                            System.out.println("Número do Livro: " + livro.getNumeroLivro());
                            System.out.println("Título: " + livro.getTitulo());
                            System.out.println("Autor: " + livro.getAutor());
                            System.out.println("Gênero: " + livro.getGenero());
                            System.out.println("Editora: " + livro.getEditora());
                            System.out.println("Quantidade de Páginas: " + livro.getQuantidadePaginas());
                            if (livro.getQuantidadeDisponivel() <= 0)
                                System.out.println("Obs: Livro Indisponível para empréstimo!");
                            else
                                System.out.println("Quantidade Disponível: " + livro.getQuantidadeDisponivel());
                            System.out.println("-------------------------");
                        });

                    break;
                }
                case 2: // === LISTA OS LIVROS DISPONÍVEIS PARA EMPRÉSTIMO ===
                {
                    boolean todosIndisponiveis;

                    System.out.println("\n========= LIVROS DISPONÍVEIS PARA EMPRÉSTIMO =========\n");
                    
                    if(biblioteca.getLivros().isEmpty()) {
                        System.out.println("- Nenhum livro cadastrado!");
                        break;
                    }
                    todosIndisponiveis = biblioteca.getLivros().stream()
                        .allMatch(livro -> livro.getQuantidadeDisponivel() < 1);

                    if(todosIndisponiveis) {
                        System.out.println("Todos os livros estão indisponíveis para empréstimo.");
                        break;
                    }

                    // .stream() funciona como um funil, entao eu pego a lista ge livros e seleciono apenas os que tem mais de 0
                    // quantidade disponivel, e depois pego cada um (forEach) e imprimo as informações desses livros
                    biblioteca.getLivros().stream()
                        .filter(livro -> livro.getQuantidadeDisponivel() > 0)
                        .forEach(livro -> {
                            System.out.println("Número do Livro: " + livro.getNumeroLivro());
                            System.out.println("Título: " + livro.getTitulo());
                            System.out.println("Autor: " + livro.getAutor());
                            System.out.println("Gênero: " + livro.getGenero());
                            System.out.println("Editora: " + livro.getEditora());
                            System.out.println("Quantidade de Páginas: " + livro.getQuantidadePaginas());
                            System.out.println("Quantidade Disponível: " + livro.getQuantidadeDisponivel());
                            System.out.println("-------------------------");
                        });
                    
                    // Seria exatamente esse for, vou deixar de exemplo casa necessite
                    // for (Livro livro : biblioteca.getLivros()) {
                    //     if (livro.getQuantidadeDisponivel() > 0) {
                    //         System.out.println("Número do Livro: " + livro.getNumeroLivro());
                    //         System.out.println("Título: " + livro.getTitulo());
                    //         System.out.println("Autor: " + livro.getAutor());
                    //         System.out.println("Gênero: " + livro.getGenero());
                    //         System.out.println("Editora: " + livro.getEditora());
                    //         System.out.println("Quantidade de Páginas: " + livro.getQuantidadePaginas());
                    //         System.out.println("Quantidade Disponível: " + livro.getQuantidadeDisponivel());
                    //         System.out.println("-------------------------");
                    //     }
                    // }

                    break;
                }
                case 3: // === LISTA OS LIVROS INDISPONÍVEIS PARA EMPRÉSTIMO ===
                {
                    boolean todosDisponeis;
                    System.out.println("\n========= LIVROS INDISPONÍVEIS PARA EMPRÉSTIMO =========\n");
                    // Verifica se a lista de livros está vazia
                    if (biblioteca.getLivros().isEmpty()) {
                        System.out.println("- Nenhum livro cadastrado!");
                        break;
                    }
                    todosDisponeis = biblioteca.getLivros().stream()
                        .allMatch(livro -> livro.getQuantidadeDisponivel() > 0);
                    
                    if(todosDisponeis) {
                        System.out.println("Todos os livros estão disponíveis para empréstimo.");
                        break;
                    }

                    biblioteca.getLivros().stream()
                        .filter(livro -> livro.getQuantidadeDisponivel() <= 0)
                        .forEach(livro -> {
                            System.out.println("Número do Livro: " + livro.getNumeroLivro());
                            System.out.println("Título: " + livro.getTitulo());
                            System.out.println("Autor: " + livro.getAutor());
                            System.out.println("Gênero: " + livro.getGenero());
                            System.out.println("Editora: " + livro.getEditora());
                            System.out.println("Quantidade de Páginas: " + livro.getQuantidadePaginas());
                            System.out.println("Quantidade Disponível: " + livro.getQuantidadeDisponivel());
                            System.out.println("-------------------------");
                        });

                    break;
                } 
                case 4: // === ADICIONA UM LIVRO ===
                {
                    String titulo, autor, genero, editora, numeroLivro;
                    Integer quantidadePaginas, quantidadeDisponivel;

                    System.out.println("\n======== CADASTRO DE LIVRO =========\n");
                    // - Título do livro
                    System.out.println("- Digite o título do livro:");
                    do {
                        titulo = leitor.nextLine();
                        if (titulo.isEmpty())
                            System.out.println("Título inválido! Digite novamente.");
                    } while (titulo.isEmpty());
                    // - Autor(a) do livro
                    System.out.println("- Digite o autor do livro:");
                    do {
                        autor = leitor.nextLine();
                        if (autor.isEmpty())
                            System.out.println("Autor inválido! Digite novamente.");
                    } while (autor.isEmpty());
                    // - Gênero do livro
                    System.out.println("- Digite o gênero do livro:");
                    do {
                        genero = leitor.nextLine();
                        if (genero.isEmpty())
                            System.out.println("Gênero inválido! Digite novamente.");
                    } while (genero.isEmpty());
                    // - Editora do livro
                    System.out.println("- Digite a editora do livro:");
                    do {
                        editora = leitor.nextLine();
                        if (editora.isEmpty())
                            System.out.println("Editora inválida! Digite novamente.");
                    } while (editora.isEmpty());
                    // - Número do cadastro do livro
                    System.out.println("- Digite o número do livro:");
                    do {
                        numeroLivro = leitor.nextLine();
                        if (numeroLivro.isEmpty())
                            System.out.println("Número do livro inválido! Digite novamente.");
                    } while (numeroLivro.isEmpty());
                    // - Quantidade de paginas do livro
                    System.out.println("- Digite a quantidade de páginas do livro:");
                    // Loop que garante que a quantidade de paginas seja um inteiro positivo
                    do {
                        quantidadePaginas = Integer.parseInt(leitor.nextLine());
                        // Valida se a quantidade de aginas é valido
                        if (quantidadePaginas <= 0 || quantidadePaginas.getClass() != Integer.class)
                            System.out.println("Quantidade inválida! Digite novamente.");
                    } while (quantidadePaginas <= 0 || quantidadePaginas.getClass() != Integer.class);
                    // Quantidade de livros disponíveis para empréstimo
                    System.out.println("- Digite a quantidade disponível do livro:");
                    // Loop que garante que a quantidade disponível seja um inteiro positivo
                    do {
                        quantidadeDisponivel = Integer.parseInt(leitor.nextLine());
                        System.out.println("Quantidade inválida! Digite novamente.");
                    } while (quantidadeDisponivel < 0 || quantidadeDisponivel.getClass() != Integer.class);

                    biblioteca.adicionarLivro(titulo, autor, genero, editora, numeroLivro, quantidadePaginas,
                            quantidadeDisponivel);
                    System.out.println("Livro adicionado com sucesso!");

                    break;
                }
                case 5: // === APAGA O REGISTRO DO LIVRO ===
                {
                    String NumeroLivro;

                    System.out.println("- Insira o número do livro que deseja apagar:");
                    NumeroLivro = leitor.nextLine();

                    if (biblioteca.removerLivro(NumeroLivro)) {
                        System.out.println("Livro removido com sucesso!");
                        break;
                    }
                    System.out.println("Livro não encontrado!");

                    break;
                }
                case 6: // === LISTA OS USUARIOS CADASTRADOS ===
                {
                    System.out.println("=== LISTA DE USUÁRIOS ===");
                    if (biblioteca.getUsuarios().isEmpty()) {
                        System.out.println("- Nenhum usuário cadastrado!");
                        break;
                    }
                    for (Usuario usuario : biblioteca.getUsuarios()) {
                        System.out.println("\nNome: " + usuario.getNome());
                        System.out.println("Registro: " + usuario.getCodigoUsuario());
                        System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
                        if (usuario.getCodigoEmprestimos().isEmpty() || usuario.getCodigoEmprestimos() == null)
                            System.out.println("Livros Emprestados: Nenhum livro emprestado");
                        else {
                            System.out.println("Livros Emprestados: ");
                            for (String codigoEmprestimo : usuario.getCodigoEmprestimos())
                                for (Livro livro : biblioteca.getLivros())
                                    if (livro.getNumeroLivro().equals(codigoEmprestimo))
                                        System.out.println("  - " + livro.getTitulo());
                            System.out.println("-------------------------");
                        }
                    }

                    break;
                }
                case 7: // === ADICIONA UM USUARIO ===
                {
                    String nome, registro, dataNascimento;
                    LocalDate dataLocal;

                    System.out.println("\n=== CADASTRO DE USUARIO ===\n");
                    System.out.println("- Digite o nome do usuário:");
                    nome = leitor.nextLine();
                    System.out.println("- Digite o registro do usuário:");
                    registro = leitor.nextLine();
                    System.out.println("- Digite a data de nascimento do usuário (dd/MM/yyyy):");
                    dataNascimento = leitor.nextLine();
                    // formata o dataNascimento para o formato Date
                    dataLocal = LocalDate.parse(dataNascimento, formatter);

                    if (!biblioteca.adicionarUsuario(nome, registro, dataLocal)) {
                        System.out.println("Erro ao adicionar usuário! Registro já existente.");
                        break;
                    }

                    System.out.println("Usuário adicionado com sucesso!");

                    break;
                }
                case 8: // === APAGA O REGISTRO DO USUÁRIO ===
                {
                    String registro;

                    System.out.println("- Insira o registro do usuário que deseja apagar:");
                    registro = leitor.nextLine();

                    if (biblioteca.removerUsuario(registro)) {
                        System.out.println("\nUsuário removido com sucesso!");
                        break;
                    }
                    System.out.println("\nUsuário não encontrado!");

                    break;
                }
                case 9: // === LISTA OS EMPRÉSTIMOS ATIVOS ===
                {
                    System.out.println("\n=== LISTA DE EMPRÉSTIMOS ATIVOS ===\n");
                    if (biblioteca.getEmprestimos().isEmpty()) {
                        System.out.println("- Nenhum empréstimo realizado!");
                        break;
                    }
                    for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
                        if (emprestimo.getEmprestado()) {
                            if (emprestimo.getDataDevolucao().isBefore(LocalDate.now())) {
                                emprestimo.calculaMulta(LocalDate.now());
                                System.out.println("Obs: Empréstimo com atraso! Multa: " + emprestimo.getMulta());
                            }
                            System.out.println("Número do Empréstimo: " + emprestimo.getCodigoEmprestimo());
                            System.out.println("Usuário: " + biblioteca.buscarUsuario(emprestimo.getRegistroUsuario()).getNome());
                            System.out.println("Livro: " + biblioteca.buscarLivro(emprestimo.getNumeroLivro()).getTitulo());
                            System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
                            System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao());
                            System.out.println("-------------------------");
                        }
                    }

                    break;
                }
                case 10: // === LISTA OS EMPRÉSTIMOS FINALIZADOS ===
                {
                    System.out.println("\n=== LISTA DE EMPRÉSTIMOS FINALIZADOS ===\n");
                    if (biblioteca.getEmprestimos().isEmpty()) {
                        System.out.println("- Nenhum empréstimo realizado!");
                        break;
                    }
                    for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
                        if (!emprestimo.getEmprestado()) {
                            System.out.println("Número do Empréstimo: " + emprestimo.getCodigoEmprestimo());
                            System.out.println("Usuário: " + biblioteca.buscarUsuario(emprestimo.getRegistroUsuario()).getNome());
                            System.out.println("Livro: " + biblioteca.buscarLivro(emprestimo.getNumeroLivro()).getTitulo());
                            System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
                            System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao());
                            System.out.println("Multa: " + emprestimo.getMulta());
                            System.out.println("-------------------------");
                        }
                    }

                    break;
                }
                case 11:
                {
                    String codigoUsuario;
                    Usuario usuarioAtual;

                    System.out.println("\n=== LISTA DE EMPRÉSTIMOS DE UM USUÁRIO ===\n");
                    do {
                        System.out.println("- Insira o código do usuário que deseja listar os empréstimos:");
                        codigoUsuario = leitor.nextLine();
                        usuarioAtual = biblioteca.buscarUsuario(codigoUsuario);
                        if (usuarioAtual == null) {
                            System.err.println("Usuario nao encontrado, tente novamente.");
                            continue;
                        }
                    } 
                    while (usuarioAtual == null);

                    System.out.println("\n=== EMPRESTIMOS ===\n");

                    if (usuarioAtual.getCodigoEmprestimos().isEmpty()) {
                        System.out.println("Nenhum empréstimo realizado por esse usuário!");
                        break;
                    }
                    System.out.println("Empréstimos do usuário " + usuarioAtual.getNome() + ":");
                    for (String codigoEmprestimo : usuarioAtual.getCodigoEmprestimos())
                        for (Emprestimo emprestimo : biblioteca.getEmprestimos())
                            if (emprestimo.getCodigoEmprestimo().equals(codigoEmprestimo)) {
                                System.out.println("Número do Empréstimo: " + emprestimo.getCodigoEmprestimo());
                                System.out.println("Livro: " + biblioteca.buscarLivro(emprestimo.getNumeroLivro()).getTitulo());
                                System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
                                System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao());
                                System.out.println("Status: " + (emprestimo.getEmprestado() ? "Empréstimo Ativo" : "Devolvido"));
                                System.out.println("-------------------------");
                            }
                    break;
                }
                case 12: // === REALIZA O EMPRÉSTIMO DE UM LIVRO ===
                {
                    Usuario usuarioAtual;
                    Livro livroBuscado;

                    String codigoLivro, codigoUsuario;
                    String codigoEmprestimo = String.valueOf(biblioteca.getEmprestimos().size() + 1);

                    System.out.println("\n=== CADASTRO DE EMPRÉSTIMO ===\n");
                    do {
                        System.out.println("- Insira o código do usuário que deseja realizar o empréstimo:");
                        codigoUsuario = leitor.nextLine();
                        // Atribui o usuario com base no codigoUsuario
                        usuarioAtual = biblioteca.buscarUsuario(codigoUsuario);
                        // Valida se o usuário existe na biblioteca
                        if (usuarioAtual == null) {
                            System.err.println("Usuario nao encontrado, tente novamente.");
                            continue;
                        }

                    } while (biblioteca.buscarUsuario(codigoUsuario) == null);
                    do {
                        System.out.println("- Insira o código do livro que deseja emprestar:");
                        codigoLivro = leitor.nextLine();

                        livroBuscado = biblioteca.buscarLivro(codigoLivro);
                        // Valida se o livro existe na biblioteca
                        if (livroBuscado == null) {
                            System.err.println("Livro nao encontrado, tente novamente.");
                            continue;
                        }
                        // Valida a quantidade de livros diponiveis para emprestimo
                        if (livroBuscado.getQuantidadeDisponivel() <= 0) {
                            System.err.println("Livro indisponivel para emprestimo, tente novamente.");
                            continue;
                        }
                        if (usuarioAtual.getCodigoEmprestimos().contains(codigoEmprestimo)) {
                            System.err.println("Usuario ja possui esse livro emprestado, tente novamente.");
                            continue;
                        }
                    } while (livroBuscado == null || livroBuscado.getQuantidadeDisponivel() <= 0);

                    biblioteca.realizarEmprestimo(codigoEmprestimo, codigoUsuario, codigoLivro);
                    usuarioAtual.setCodigoEmprestimos(codigoEmprestimo);

                    System.out.println("Empréstimo realizado com sucesso!");
                    // ----------------------------------------------DEBUG DO
                    // EMPRESTIMO-------------------------------------------------------------
                    System.out.println("=== Informações do emprestimo===");
                    Emprestimo exemplo = biblioteca.buscarEmprestimo(codigoEmprestimo);
                    System.out.println("Numero emprestimo: " + exemplo.getCodigoEmprestimo());
                    System.out.println("Usuario: " + biblioteca.buscarUsuario(exemplo.getRegistroUsuario()).getNome());
                    System.out.println("Livro: " + biblioteca.buscarLivro(exemplo.getNumeroLivro()).getTitulo());
                    System.out.println("Data do emprestimo: " + exemplo.getDataEmprestimo());
                    System.out.println("Data de devolução: " + exemplo.getDataDevolucao());
                    System.out.println("Emprestado: " + exemplo.getEmprestado());
                    // ----------------------------------------------------------------------------------------------------------------

                    break;
                }
                case 13: // === REALIZA A DEVOLUÇAO DE UM LIVRO ===
                {
                    if (biblioteca.getEmprestimos().isEmpty()) {
                        System.out.println("Nenhum empréstimo realizado!");
                        break;
                    }
                    Usuario usuarioDevolucao;
                    Livro livroDevolvido;

                    String codigoLivro, codigoUsuario, codigoDevolucao = "";

                    System.out.println("\n=== DEVOLUÇÃO DE LIVRO ===\n");
                    do {
                        System.out.println("- Insira o código do usuário que deseja realizar a devolução:");
                        codigoUsuario = leitor.nextLine();
                        usuarioDevolucao = biblioteca.buscarUsuario(codigoUsuario);
                        // Valida se o usuário existe na biblioteca
                        if (usuarioDevolucao == null) {
                            System.err.println("Usuario nao encontrado, tente novamente.");
                            continue;
                        }
                    } while (usuarioDevolucao == null);
                    do {
                        System.out.println("- Insira o código do livro que deseja devolver:");
                        codigoLivro = leitor.nextLine();
                        // Valida se o livro existe na biblioteca
                        livroDevolvido = biblioteca.buscarLivro(codigoLivro);
                        if (livroDevolvido == null) {
                            System.err.println("Livro nao encontrado, tente novamente.");
                            continue;
                        }
                        // Valida se o usuário possui esse livro emprestado
                        if (!usuarioDevolucao.getCodigoEmprestimos().contains(codigoLivro)) {
                            System.err.println("Usuario nao possui esse livro emprestado, tente novamente.");
                            continue;
                        }
                        for (Emprestimo emprestimo : biblioteca.getEmprestimos())
                            if (emprestimo.getRegistroUsuario().equals(codigoUsuario)
                                    && emprestimo.getNumeroLivro().equals(codigoLivro))
                                codigoDevolucao = emprestimo.getCodigoEmprestimo();

                    } while (livroDevolvido == null || !usuarioDevolucao.getCodigoEmprestimos().contains(codigoLivro));
                    // Realiza a devolução do livro
                    biblioteca.realizarDevolucao(codigoDevolucao);
                    // Atualiza a quantidade de livros disponíveis na biblioteca
                    livroDevolvido = biblioteca.buscarLivro(codigoLivro);
                    livroDevolvido.devolverLivro();
                    // Remove o código do empréstimo da lista de empréstimos do usuário
                    usuarioDevolucao = biblioteca.buscarUsuario(codigoUsuario);
                    usuarioDevolucao.getCodigoEmprestimos().remove(codigoLivro);

                    System.out.println("Dados do fechameto do empréstimo");
                    System.out.println("Número do Empréstimo: " + codigoDevolucao);
                    System.out.println("Usuário: " + usuarioDevolucao.getNome());
                    System.out.println("Livro: " + livroDevolvido.getTitulo());
                    System.out.println("Data do Empréstimo: " + biblioteca.buscarEmprestimo(codigoDevolucao).getDataEmprestimo());
                    System.out.println("Data de Devolução: " + biblioteca.buscarEmprestimo(codigoDevolucao).getDataDevolucao());
                    System.out.println("Multa: " + biblioteca.buscarEmprestimo(codigoDevolucao).getMulta());

                    break;
                }
                case 0: // === ENCERRA O PROGRAMA ===
                {
                    System.out.println("Saindo...");

                    break;
                }
                default: // === OPÇÃO INVÁLIDA ===
                {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }
        } while (opcao != 0);

        leitor.close();
    }
}