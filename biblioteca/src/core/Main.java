// Pasta core - Necesário em todo arquivo para refernciar os arquivos do projeto
package core;

// OUTRAS IMPORTAÇÕES NECESSÁRIAS PARA O FUNCIONAMENTO DO PROJETO
import entidades.Biblioteca;
import entidades.Emprestimo;
import entidades.Livro;
import entidades.Usuario;
import entidades.TipoItemBiblioteca;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        Biblioteca biblioteca = new Biblioteca();

        public void terminal_principal() {
            do{
                System.out.println("\n==== BEM VINDO(A) À BIBLIOTECA ====\n");

                System.out.println("1. Usuários");
                System.out.println("2. Itens biblioca");
                System.out.println("3. Empréstimos");
                System.out.println("4. Em breve... (Reserva)");
                System.out.println(" 0. Sair");

                do {
                    try {
                        opcao = Integer.parseInt(leitor.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Opção inválida! Digite um número inteiro.");
                        opcao = null;
                    }

                } while (opcao == null);

                switch(opcao) {
                    case 0: 
                        System.out.println("Encerrando....");
                        break;
                    
                    case 1:
                        terminal_usuarios();
                        break;

                    case 2:
                        terminal_itens();
                        break;
                    
                    case 3:
                        terminal_emprestimos();
                        break;

                    case 4:
                        System.out.println("Em breve....");
                        break;
                }
            } while (opcao != 0);
        }

        public void terminal_usuarios() {
            Integer opcao = null;

            System.out.println("==== USUÁRIOS ====");
            System.out.println(" 1. Listar todos usuários");
            System.out.println(" 2. Listar alunos");
            System.out.println(" 3. Listar professores");
            System.out.println(" 4. Listar servidores");
            System.out.println(" 3. Voltar");
        
            System.out.println("\n- Insira a opção desejada: ");
            do {
                try {
                    opcao = Integer.parseInt(leitor.nextLine());
                } 
                catch (NumberFormatException e) {
                    System.out.println("Opção inválida! Digite um número inteiro.");
                    opcao = null;
                }

            } while (opcao == null);

            switch(opcao) {
                case 0:
                    terminal_principal();
                    break;

                case 1:
                    biblioca.getUsuarios().forEach(System.out::println);
                    break;
                
                case 2:
                    if(biblioca.getUsuarios().isBlank()) {
                        System.out.println("Nenhum usuário cadastrado!");
                        break;
                    }   

                    Boolean semAluno = biblioca.getUsuarios()
                        .noneMatch(a -> a instanceof Aluno);

                    if(semAluno) { 
                        System.out.println("Nenhum aluno cadastrado!");
                        break;
                    }   

                    biblioca.getUsuarios().stream()
                        .filter( a -> a instanceof Aluno)
                        .forEach(a -> {
                            Aluno aluno = (Aluno) a;
                            System.out.println("Nome: " + aluno.getNome());
                            System.out.println("Registro: " + aluno.getCodigoUsuario());
                            if (aluno.getCodigoEmprestimos().isEmpty() || aluno.getCodigoEmprestimos() == null)
                                    System.out.println("Livros Emprestados: Nenhum livro emprestado");
                            else {
                                System.out.println("Livros Emprestados: ");
                                for (String codigoEmprestimo : aluno.getCodigoEmprestimos())
                                    for (Livro livro : biblioteca.getLivros())
                                        if (livro.getIsbn().equals(codigoEmprestimo))
                                            System.out.println("  - " + livro.getTitulo());
                                System.out.println("-------------------------");
                            }
                        });
                    break;

                case 3: 
                    if(biblioca.getUsuarios().isBlank()) {
                        System.out.println("Nenhum usuário cadastrado!");
                        break;
                    }   

                    Boolean semProfessor = biblioca.getUsuarios()
                        .noneMatch(p -> p instanceof Professor);

                    if(semProfessor) { 
                        System.out.println("Nenhum professor cadastrado!");
                        break;
                    }   

                    biblioca.getUsuarios().stream()
                        .filter( p -> p instanceof Professor)
                        .forEach(p -> {     
                            Professor professor = (Professor) a;
                            System.out.println("Nome: " + professor.getNome());
                            System.out.println("Registro: " + professor.getCodigoUsuario());
                            if (professor.getCodigoEmprestimos().isEmpty() || professor.getCodigoEmprestimos() == null)
                                    System.out.println("Livros Emprestados: Nenhum livro emprestado");
                            else {
                                System.out.println("Livros Emprestados: ");
                                for (String codigoEmprestimo : professor.getCodigoEmprestimos())
                                    for (Livro livro : biblioteca.getLivros())
                                        if (livro.getIsbn().equals(codigoEmprestimo))
                                            System.out.println("  - " + livro.getTitulo());
                                System.out.println("-------------------------");
                            }
                        });
                    break;
                case 4:
                    if(biblioca.getUsuarios().isBlank()) {
                        System.out.println("Nenhum usuário cadastrado!");
                        break;
                    }   

                    Boolean semServidor = biblioca.getUsuarios()
                        .noneMatch(s -> s instanceof servidorAdministrativo);

                    if(semServidor) { 
                        System.out.println("Nenhum servidor cadastrado!");
                        break;
                    }   

                    biblioca.getUsuarios().stream()
                        .filter( s -> s instanceof ServidorAdministrativo)
                        .forEach(s -> {
                            ServidorAdministrativo servidorAdministrativo = (ServidorAdministrativo) s;
                            System.out.println("Nome: " + servidorAdministrativo.getNome());
                            System.out.println("Registro: " + servidorAdministrativo.getCodigoUsuario());
                            if (servidorAdministrativo.getCodigoEmprestimos().isEmpty() || servidorAdministrativo.getCodigoEmprestimos() == null)
                                    System.out.println("Livros Emprestados: Nenhum livro emprestado");
                            else {
                                System.out.println("Livros Emprestados: ");
                                for (String codigoEmprestimo : servidorAdministrativo.getCodigoEmprestimos())
                                    for (Livro livro : biblioteca.getLivros())
                                        if (livro.getIsbn().equals(codigoEmprestimo))
                                            System.out.println("  - " + livro.getTitulo());
                                System.out.println("-------------------------");
                            }
                        });
                    break;
                default: 
                    System.out.println("Opção inexistente!");
                    break;
            }
        }

        public void terminal_itens() {
            int opcao;

            System.out.println("==== ITENS ====");
            System.out.println(" 1. Listar todos os itens");
            System.out.println(" 2. Listar livros");
            System.out.println(" 3. Listar teses");
            System.out.println(" 4. Listar revistas");
            System.out.println(" 3. Voltar");
        
            System.out.println("\n- Insira a opção desejada: ");
            do {
                try {
                    opcao = Integer.parseInt(leitor.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Opção inválida! Digite um número inteiro.");
                    opcao = null;
                }

            } while (opcao == null);

            switch(opcao) {
                case 0:
                    terminal_principal();
                    break;

                case 1:
                    biblioca.getItens().forEach(System.out::println);
                    break;
                
                case 2:
                    if(biblioca.getItens().isBlank()) {
                        System.out.println("Nenhum item cadastrado!");
                        break;
                    }   

                    Boolean semLivro = biblioca.getItens()
                        .noneMatch(l -> l instanceof Livro);

                    if(semLivro) { 
                        System.out.println("Nenhum livro cadastrado!");
                        break;
                    }   

                    biblioca.getItens().stream()
                        .filter( l -> l instanceof Livro)
                        .forEach(l -> {
                            Livro livro = (Livro) l;
                            System.out.println("Título: " + livro.getTitulo());
                            System.out.println("Gênero: " + livro.getGenero());
                            System.out.println("ISBN: " + livro.getIsbn());
                            System.out.println("Edição: " + livro.getNumeroEdicao());
                            System.out.println("Quantidade de páginas: " + livro.getQuantidadePaginas());
                            System.out.println("Quantidade disponível: " + livro.getQuantidadeDisponivel());
                            System.out.println("-------------------------");
                        });
                    break;

                case 3: 
                    if(biblioca.getItens().isBlank()) {
                        System.out.println("Nenhum item cadastrado!");
                        break;
                    }   

                    Boolean semTese = biblioca.getItens()
                        .noneMatch(t -> t instanceof Tese);

                    if(semTese) { 
                        System.out.println("Nenhuma tese cadastrado!");
                        break;
                    }   

                    biblioca.getUsuarios().stream()
                        .filter( t -> t instanceof Tese)
                        .forEach(t -> {     
                            Tese tese = (Tese) t;
                            System.out.println("Título: " + tese.getTitulo());
                            System.out.println("Autor: " + tese.getAutor());
                            System.out.println("Orientador: " + tese.getOrientador());
                            System.out.println("Área pesquisada: " + tese.getAreaPesquisada());
                            System.out.println("Quantidade de páginas: " + tese.getQuantidadePaginas());
                            System.out.println("Quantidade disponível: " + tese.getQuantidadeDisponivel());
                            System.out.println("-------------------------");
                        });
                    break;
                case 4:
                    if(biblioca.getItens().isBlank()) {
                        System.out.println("Nenhum item cadastrado!");
                        break;
                    }   

                    Boolean semRevista = biblioca.getItens()
                        .noneMatch(s -> r instanceof revista);

                    if(semRevista) { 
                        System.out.println("Nenhuma revista cadastrado!");
                        break;
                    }   

                    biblioca.getItens().stream()
                        .filter( r -> r instanceof Revista)
                        .forEach(r -> {
                            System.out.println("Título: " + revista.getTitulo());
                            System.out.println("Editora: " + revista.getEditora());
                            System.out.println("ISSN: " + revista.getIssn());
                            System.out.println("Tema principal: " + revista.getTemaPrincipal());
                            System.out.println("Quantidade de páginas: " + revista.getQuantidadePaginas());
                            System.out.println("Quantidade disponível: " + revista.getQuantidadeDisponivel());
                            System.out.println("-------------------------");
                        });
                    break;
                default: 
                    System.out.println("Opção inexistente!");
                    break;
            }
        }

        public void terminal_emprestimos() {
            Integer opcao = null; // Usando Integer para aceitar null no controle do laço

            do {
                System.out.println("\n==== GESTÃO DE EMPRÉSTIMOS ====");
                System.out.println(" 1. Listar todos os empréstimos");
                System.out.println(" 2. Realizar novo empréstimo");
                System.out.println(" 3. Devolver item / Calcular Multa");
                System.out.println(" 0. Voltar");
                System.out.print("\n- Insira a opção desejada: ");

                try {
                    opcao = Integer.parseInt(leitor.nextLine());
                } 
                catch (NumberFormatException e) {
                    System.out.println("Opção inválida! Digite um número inteiro.");
                    opcao = null;
                    continue;
                }

                switch (opcao) {
                    case 0:
                        terminal_principal();
                        break;

                    case 1:
                        if (biblioteca.getEmprestimos().isEmpty()) {
                            System.out.println("Nenhum empréstimo registrado.");
                        } else {
                            System.out.println("\n--- RELATÓRIO DE EMPRÉSTIMOS ---");
                            biblioteca.getEmprestimos().forEach(e -> {
                                String status = e.getEmprestado() ? "EM ABERTO" : "DEVOLVIDO";
                                System.out.println("ID: " + e.getCodigoEmprestimo() + " | Livro: " + e.getIdLivro() + 
                                                " | Usuário: " + e.getRegistroUsuario() + " | Status: " + status);
                            });
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("ID do Empréstimo: ");
                            String codEmp = leitor.nextLine();
                            System.out.print("ID do Usuário: ");
                            String codUsu = leitor.nextLine();
                            System.out.print("ID do Item/Livro: ");
                            String codItem = leitor.nextLine();

                            biblioteca.buscarUsuario(codUsu); 
                            biblioteca.buscarItem(codItem);

                            LocalDate hoje = LocalDate.now();
                            LocalDate devolucaoPrevista = hoje.plusDays(14);

                            Emprestimo novoEmp = new Emprestimo(codEmp, codUsu, codItem, hoje, devolucaoPrevista, true);
                            biblioteca.adicionarEmprestimo(novoEmp);
                            
                            System.out.println("Empréstimo realizado! Devolução prevista: " + devolucaoPrevista);
                        } catch (Exception e) {
                            System.out.println("Erro ao emprestar: " + e.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            System.out.print("Digite o ID do Empréstimo para devolução: ");
                            String idBusca = leitor.nextLine();
                            
                            Emprestimo emp = biblioteca.getEmprestimos().stream()
                                .filter(e -> e.getCodigoEmprestimo().equals(idBusca))
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("Empréstimo não encontrado!"));

                            if (!emp.getEmprestado()) {
                                System.out.println("Este item já foi devolvido anteriormente.");
                                break;
                            }

                            // Calcula multa baseada na data de hoje
                            emp.calculaMulta(LocalDate.now());
                            emp.setEmprestado(false);

                            System.out.println("Devolução concluída!");
                            if (emp.getMulta() > 0) {
                                System.out.println("MULTA APLICADA: R$ " + String.format("%.2f", emp.getMulta()));
                            } else {
                                System.out.println("Sem multas. Devolução no prazo!");
                            }
                        } catch (Exception e) {
                            System.out.println("Erro na devolução: " + e.getMessage());
                        }
                        break;

                    default:
                        System.out.println("Opção inexistente!");
                        break;
                }
            } while (opcao != 0);
        }
    }
}