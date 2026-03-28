package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // GET SETTERS
    // LIVROS
    public List<Livro> getLivros() {
        return livros;
    }

    public boolean adicionarLivro(String titulo, String autor, String genero, String editora, String numeroLivro, Integer quantidadePaginas, Integer quantidadeDisponivel) 
    {
        Livro livro = new Livro(titulo, autor, genero, editora, numeroLivro, quantidadePaginas, quantidadeDisponivel);

        for(int i = 0; i < this.livros.size(); i++)
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

    // USUARIOS
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean adicionarUsuario(String nome, String registro, Date dataNascimento) {
        Usuario usuario = new Usuario(nome, registro, dataNascimento);

        for (int i = 0; i < this.usuarios.size(); i++)
            if (this.usuarios.get(i).getRegistro().equals(usuario.getRegistro()))
                // Retorna FALSE se o registro do usuário já existir
                return false;

        this.usuarios.add(usuario);
        // Retorna TRUE se o usuário for adicionado com sucesso
        return true;
    }

    public boolean removerUsuario(String registro) {
        for (int i = 0; i < this.usuarios.size(); i++)
            if (this.usuarios.get(i).getRegistro().equals(registro)) {
                this.usuarios.remove(i);
                // Retorna TRUE se o usuário for encontrado e removido
                return true;
            }
        // Retorna FALSE se o usuário não for encontrado
        return false;
    }
}