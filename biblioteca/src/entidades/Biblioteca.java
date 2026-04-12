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
    public boolean adicionarLivro(String titulo, String autor, String genero, String editora, String Isbn,
            Integer quantidadePaginas, Integer quantidadeDisponivel) {
                
        for (Livro livroAtual : this.livros)
            if (livroAtual.getIsbn().equals(Isbn))
                throw new IllegalArgumentException("O Livro " + Isbn + " já foi cadastrado!");
                    
        Livro livro = new Livro(titulo, autor, genero, editora, Isbn, quantidadePaginas, quantidadeDisponivel);
        
        this.livros.add(livro);
        // Retorna TRUE se o livro for adicionado com sucesso
        return true;
    }
    public boolean removerLivro(String Isbn) {
        if(Isbn == null || Isbn.isEmpty())
            throw new IllegalArgumentException("IBNS inválido!");
        
        Isbn = Isbn.trim();

        for (Livro livroAtual : this.livros)
            if (livroAtual.getIsbn().equals(Isbn)) {
                this.livros.remove(livroAtual.getIsbn());
                // Retorna TRUE se o livro for encontrado e removido
                return true;
            }
        throw new IllegalArgumentException("Livro não encontrado!");
    }
    public Livro buscarLivro(String Isbn) {
        if(Isbn == null || Isbn.isEmpty())
            throw new IllegalArgumentException("Isbn inválido!");

        Isbn = Isbn.trim();

        for (Livro livro : this.livros)
            if (livro.getIsbn().equals(Isbn))
                return livro;
     
        throw new IllegalArgumentException("Livro não encontrado!"); 
    }

    // USUARIOS
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public boolean adicionarUsuario(String nome, String registro, LocalDate dataNascimento) {
        Usuario usuario = new Usuario(nome, registro, dataNascimento);

        for (Usuario usuarioAtual : this.usuarios)
            if (usuarioAtual.getCodigoUsuario().equals(usuario.getCodigoUsuario()))
                throw new IllegalArgumentException("O usuário já possui cadastro");    

        this.usuarios.add(usuario);
        // Retorna TRUE se o usuário for adicionado com sucesso
        return true;
    }
    public boolean removerUsuario(String codigoUsuario) {
        for (Usuario usuarioAtual : this.usuarios)
            if (usuarioAtual.getCodigoUsuario().equals(codigoUsuario)) {
                this.usuarios.remove(usuarioAtual);
                // Retorna TRUE se o usuário for encontrado e removido
                return true;
            }
        // Retorna FALSE se o usuário não for encontrado
        throw new IllegalArgumentException("Usuário não encontrado");
    }
    public Usuario buscarUsuario(String codigoUsuario) {
        if(codigoUsuario == null || codigoUsuario.isEmpty())
            throw new IllegalArgumentException("O codigo de usuário inválido!");
        else
            codigoUsuario = codigoUsuario.trim();
        for (Usuario usuario : this.usuarios)
            if (usuario.getCodigoUsuario().equals(codigoUsuario))
                return usuario;
        
        throw new IllegalArgumentException("Usuário não encontrado!");
    }

    // EMPRÉSTIMOS
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    public Emprestimo buscarEmprestimo(String codigoEmprestimo) {
        if (codigoEmprestimo == null || codigoEmprestimo.isEmpty())
            throw new IllegalArgumentException("Código de empréstimo inválido!");
        else
            codigoEmprestimo = codigoEmprestimo.trim();

        for (Emprestimo emprestimo : this.emprestimos)
            if (emprestimo.getCodigoEmprestimo().equals(codigoEmprestimo))
                return emprestimo;
            
        throw new IllegalArgumentException("Empréstimo não encontrado!");
    }
    // Cria um emprestimo novo e adiciona na lista de emprestimos da biblioteca
    public boolean realizarEmprestimo(String codigoEmprestimo, String codigoUsuario, String codigoLivro) {
        if(codigoEmprestimo == null || codigoEmprestimo.isEmpty())
            throw new IllegalArgumentException("Código de empréstimo inválido!");

        if(codigoUsuario == null || codigoUsuario.isEmpty())
            throw new IllegalArgumentException("Código de usuário inválido");

        if(codigoLivro == null || codigoLivro.isEmpty())
            throw new IllegalArgumentException("Código do livro inválido");

        codigoEmprestimo = codigoEmprestimo.trim();
        codigoUsuario = codigoUsuario.trim();
        codigoLivro = codigoLivro.trim();

        Usuario usuarioEmprestimo = buscarUsuario(codigoUsuario);
        if(usuarioEmprestimo == null)
            throw new IllegalArgumentException("Usuário não encontrado!");

        // Busca o livro
        Livro livroEmprestado = buscarLivro(codigoLivro);
        if(livroEmprestado == null)
            throw new IllegalArgumentException("Livro não encontrado!");
        
        if (livroEmprestado.getQuantidadeDisponivel() < 0) 
            throw new IllegalArgumentException("Livro indisponível para empréstimo!");
        
        // Classe dos emprestimos
        LocalDate dataAtual = LocalDate.now();
        // Adiciona 30 dias à data atual para definir a data de devolução
        LocalDate dataDevolucao = dataAtual.plusDays(30); // Adiciona 30 dias à data atual

        Emprestimo emprestimo = new Emprestimo(String.valueOf(emprestimos.size() + 1), codigoUsuario, codigoLivro, dataAtual, dataDevolucao, true);
        // Adiciona o emprestimo à List de emprestimos da biblioteca
        emprestimos.add(emprestimo);
        livroEmprestado.realizarEmprestimo();

        return true;
    }
    public void realizarDevolucao(String codigoEmprestimo) {
        Emprestimo emprestimoDevolucao = buscarEmprestimo(codigoEmprestimo);
        if(emprestimoDevolucao == null)
            throw new IllegalArgumentException("Emprestimo não encontrado!");

        if (emprestimoDevolucao.getEmprestado()) {
            for(Emprestimo emprestimo : this.emprestimos)
                if(emprestimo.getCodigoEmprestimo().equals(emprestimoDevolucao.getCodigoEmprestimo())) {
                    emprestimo.setEmprestado(false);
                    emprestimo.setDataDevolucao(LocalDate.now());
                    emprestimo.calculaMulta(emprestimo.getDataDevolucao());
                }    
            // Incrementa a quantidade disponível do livro devolvido        
            Livro livroDevolvido = buscarLivro(emprestimoDevolucao.getIsbn());
            if (livroDevolvido == null)
                throw new IllegalArgumentException("Livro não encontrado!");

            livroDevolvido.realizarDevolucao();
        }
    }
}