package entidades;

public class Livro extends ItemBiblioteca
{
    private String Autor;
    private String Genero;
    private String Isbn;
    private Integer NumeroEdicao;

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
    
    // ISBN
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

    // NÚMERO DE EDIÇÃO
    public Integer getNumeroEdicao() {
        return this.NumeroEdicao;
    }
    public void setNumeroEdicao(Integer edicao) {
        if( edicao == null)
            throw new IllegalArgumentException("Edição inválida!");

        this.NumeroEdicao = edicao;
    }
}