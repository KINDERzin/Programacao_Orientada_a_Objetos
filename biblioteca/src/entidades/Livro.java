package entidades;

public class Livro 
{
    private String Titulo;
    private String Autor;
    private String Genero;
    private String Editora;
    private String NumeroLivro;
    private Integer QuantidadePaginas;
    private Integer QuantidadeDisponivel;

    public Livro(String titulo, String autor, String Genero, String Editora, 
                 String NumeroLivro, Integer QuantidadePaginas, Integer QuantidadeDisponivel)
    {
        setTitulo               (titulo);
        setAutor                (autor);
        setGenero               (Genero);
        setEditora              (Editora);
        setNumeroLivro          (NumeroLivro);
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
        this.Titulo = titulo;
    }
    // AUTOR
    public String getAutor()
    {
        return Autor;
    }
    public void setAutor(String autor)
    {
        this.Autor = autor;
    }
    // GENERO
    public String getGenero()
    {
        return Genero;
    }
    public void setGenero(String Genero)
    {
        this.Genero = Genero;
    }
    // EDITORA
    public String getEditora()
    {
        return Editora;
    }
    public void setEditora(String Editora)
    {
        this.Editora = Editora;
    }
    // NUMERO DO LIVRO
    public String getNumeroLivro()
    {
        return NumeroLivro;
    }
    public void setNumeroLivro(String NumeroLivro)
    {
        this.NumeroLivro = NumeroLivro;
    }
    // QUANTIDADE DE PAGINAS
    public Integer getQuantidadePaginas()
    {
        return QuantidadePaginas;
    }
    public void setQuantidadePaginas(Integer QuantidadePaginas)
    {
        this.QuantidadePaginas = QuantidadePaginas;
    }
    // QUANTIDADE DISPONIVEL
    public Integer getQuantidadeDisponivel()
    {
        return QuantidadeDisponivel;
    }
    public void setQuantidadeDisponivel(Integer QuantidadeDisponivel)
    {
        this.QuantidadeDisponivel = QuantidadeDisponivel;
    }    
}
