package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();

        InitializeLibrary();
    }

    public void InitializeLibrary() {
        // Adiciona livros à biblioteca
        adicionarLivro("O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", "HarperCollins", "001", 1178, 5);
        adicionarLivro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Fantasia", "Rocco", "002", 309, 3);
        adicionarLivro("1984", "George Orwell", "Distopia", "Companhia das Letras", "003", 328, 4);
        adicionarLivro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Fábula", "Agir", "004", 96, 2);
        adicionarLivro("A Guerra dos Tronos", "George R.R. Martin", "Fantasia Épica", "Leya", "005", 694, 6);

        // Adiciona usuários à biblioteca
        adicionarUsuario("Alice Silva", "U001", criarData(1990, 5, 15));
        adicionarUsuario("Bruno Costa", "U002", criarData(1998, 7, 22));
        adicionarUsuario("Carla Mendes", "U003", criarData(1992, 10, 30));
        adicionarUsuario("Diego Santos", "U004", criarData(1988, 2, 10));
        adicionarUsuario("Elisa Ferreira", "U005", criarData(1995, 1, 5));
    }

    public static LocalDate criarData(int ano, int mes, int dia) {
        return LocalDate.of(ano, mes, dia);
    }

    // GET SETTERS
    // LIVROS
    public List<Livro> getLivros() {
        return livros;
    }

    public boolean adicionarLivro(String titulo, String autor, String genero, String editora, String numeroLivro,
            Integer quantidadePaginas, Integer quantidadeDisponivel) {
        Livro livro = new Livro(titulo, autor, genero, editora, numeroLivro, quantidadePaginas, quantidadeDisponivel);

        for (int i = 0; i < this.livros.size(); i++)
            if (this.livros.get(i).getNumeroLivro().equals(livro.getNumeroLivro()))
                // Retorna FALSE se o número do livro já existir
                return false;

        this.livros.add(livro);
        // Retorna TRUE se o livro for adicionado com sucesso
        return true;
    }

    public boolean removerLivro(String numeroLivro) {
        for (int i = 0; i < this.livros.size(); i++)
            if (this.livros.get(i).getNumeroLivro().equals(numeroLivro)) {
                this.livros.remove(i);
                // Retorna TRUE se o livro for encontrado e removido
                return true;
            }
        // Retorna FALSE se o livro não for encontrado
        return false;
    }

    public Livro buscarLivro(String numeroLivro) {
        for (Livro livro : this.livros)
            if (livro.getNumeroLivro().equals(numeroLivro))
                return livro;
        return null; // Retorna null se o livro não for encontrado
    }

    // USUARIOS
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean adicionarUsuario(String nome, String registro, LocalDate dataNascimento) {
        Usuario usuario = new Usuario(nome, registro, dataNascimento);

        for (int i = 0; i < this.usuarios.size(); i++)
            if (this.usuarios.get(i).getCodigoUsuario().equals(usuario.getCodigoUsuario()))
                // Retorna FALSE se o código do usuário já existir
                return false;

        this.usuarios.add(usuario);
        // Retorna TRUE se o usuário for adicionado com sucesso
        return true;
    }

    public boolean removerUsuario(String codigoUsuario) {
        for (int i = 0; i < this.usuarios.size(); i++)
            if (this.usuarios.get(i).getCodigoUsuario().equals(codigoUsuario)) {
                this.usuarios.remove(i);
                // Retorna TRUE se o usuário for encontrado e removido
                return true;
            }
        // Retorna FALSE se o usuário não for encontrado
        return false;
    }

    public Usuario buscarUsuario(String codigoUsuario) {
        for (Usuario usuario : this.usuarios)
            if (usuario.getCodigoUsuario().equals(codigoUsuario))
                return usuario;
        return null; // Retorna null se o usuário não for encontrado
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    public Emprestimo buscarEmprestimo(String codigoEmprestimo) {
        for (Emprestimo emprestimo : this.emprestimos)
            if (emprestimo.getCodigoEmprestimo().equals(codigoEmprestimo))
                return emprestimo;
        return null; // Retorna null se o empréstimo não for encontrado
    }

    // Cria um emprestimo novo e adiciona na lista de emprestimos da biblioteca
    public boolean realizarEmprestimo(String codigoEmprestimo, String codigoUsuario, String codigoLivro) {
        // Busca o usuario
        Usuario usuarioEmprestimo = buscarUsuario(codigoUsuario);
        // Busca o livro
        Livro livroEmprestado = buscarLivro(codigoLivro);

        if (usuarioEmprestimo != null && livroEmprestado != null && livroEmprestado.getQuantidadeDisponivel() > 0) {
            // Classe dos emprestimos
            LocalDate dataAtual = LocalDate.now();
            // Adiciona 30 dias à data atual para definir a data de devolução
            LocalDate dataDevolucao = dataAtual.plusDays(30); // Adiciona 30 dias à data atual

            Emprestimo emprestimo = new Emprestimo(String.valueOf(emprestimos.size() + 1), codigoUsuario, codigoLivro, dataAtual, dataDevolucao, true);
            // Adiciona o emprestimo à List de emprestimos da biblioteca
            emprestimos.add(emprestimo);
            livroEmprestado.emprestarLivro();

            return true;
        }

        return false;
    }

    public void realizarDevolucao(String codigoEmprestimo) { // , String codigoUsuario, String codigoLivro
        Emprestimo emprestimoDevolucao = buscarEmprestimo(codigoEmprestimo);
        if (emprestimoDevolucao != null && emprestimoDevolucao.getEmprestado()) {
            for(Emprestimo emprestimo : this.emprestimos)
                if(emprestimo.getCodigoEmprestimo().equals(emprestimoDevolucao.getCodigoEmprestimo())) {
                    emprestimo.setEmprestado(false);
                    emprestimo.setDataDevolucao(LocalDate.now());
                    emprestimo.calculaMulta(emprestimo.getDataDevolucao());
                }    
            // Incrementa a quantidade disponível do livro devolvido        
            Livro livroDevolvido = buscarLivro(emprestimoDevolucao.getNumeroLivro());
            if (livroDevolvido != null)
                livroDevolvido.devolverLivro();
        }
    }
}