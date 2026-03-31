package entidades;

public class Livro 
{
    private String Titulo;
    private String Autor;
    private String Genero;
    private String Editora;
    private String Isbn;
    private Integer QuantidadePaginas;
    private Integer QuantidadeDisponivel;

    public Livro(String titulo, String autor, String Genero, String Editora, 
                 String Isbn, Integer QuantidadePaginas, Integer QuantidadeDisponivel)
    {
        setTitulo               (titulo);
        setAutor                (autor);
        setGenero               (Genero);
        setEditora              (Editora);
        setIsbn          (Isbn);
        setQuantidadePaginas    (QuantidadePaginas);
        setQuantidadeDisponivel (QuantidadeDisponivel);
    }

    // GETTER E SETTERS
    // TITULO
    public String getTitulo()
    {
        return Titulo;
    }
    public void setTitulo(String titulo)
    {
        if(titulo != null)
            titulo = titulo.trim();

        if(titulo == null || titulo.isEmpty())
            throw new IllegalArgumentException("O titulo não foi inserido!");

        this.Titulo = titulo;
    }
    // AUTOR
    public String getAutor()
    {
        return Autor;
    }
    public void setAutor(String autor)
    {
        if(autor != null)
            autor = autor.trim();

        if(autor == null || autor.isEmpty())
            throw new IllegalArgumentException("Nome de autor não inserido!");

        this.Autor = autor;
    }
    // GENERO
    public String getGenero()
    {
        return Genero;
    }
    public void setGenero(String Genero)
    {
        if(Genero != null)
            Genero = Genero.trim();
    
        if(Genero == null || Genero.isEmpty())
            throw new IllegalArgumentException("O gênero do livro não foi inserido!");

        this.Genero = Genero;
    }
    // EDITORA
    public String getEditora()
    {
        return Editora;
    }
    public void setEditora(String Editora)
    {
        if(Editora != null)
            Editora = Editora.trim();

        if(Editora == null || Editora.isEmpty())
            throw new IllegalArgumentException("A Editora não foi inserida!");

        this.Editora = Editora;
    }
    // NUMERO DO LIVRO
    public String getIsbn()
    {
        return Isbn;
    }
    public void setIsbn(String Isbn)
    {
        if(Isbn != null)
            Isbn = Isbn.trim();

        if(Isbn == null || Isbn.isEmpty())
            throw new IllegalArgumentException("O número do lvro nao foi inserido!");

        this.Isbn = Isbn;
    }
    // QUANTIDADE DE PAGINAS
    public Integer getQuantidadePaginas()
    {
        return QuantidadePaginas;
    }
    public void setQuantidadePaginas(Integer QuantidadePaginas)
    {
        if(QuantidadePaginas == null || QuantidadePaginas <= 0)
            throw new IllegalArgumentException("Número de páginas inválido!");

        this.QuantidadePaginas = QuantidadePaginas;
    }
    // QUANTIDADE DISPONIVEL
    public Integer getQuantidadeDisponivel()
    {
        return QuantidadeDisponivel;
    }
    public void setQuantidadeDisponivel(Integer QuantidadeDisponivel)
    {
        if(QuantidadeDisponivel == null || QuantidadeDisponivel < 0)
            throw new IllegalArgumentException("Quantidade de livros diponíveis é inválida!");

        this.QuantidadeDisponivel = QuantidadeDisponivel;
    }  
    public void emprestarLivro()
    {
            this.QuantidadeDisponivel--;
    }
    public void devolverLivro()
    {
            this.QuantidadeDisponivel++;
    }
}