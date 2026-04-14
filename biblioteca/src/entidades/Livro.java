package entidades;

public class Livro extends ItemBiblioteca {
    private String autor;
    private String genero;
    private String isbn;
    private Integer numeroEdicao;

    public Livro(String CodigoUnico, String Titulo, String Editora, Integer AnoPublicacao, Integer QuantidadePaginas, Integer QuantidadeDisponivel, String Autor, String Genero,  
                 String Isbn, Integer NumeroEdicao) {
        super(CodigoUnico, Titulo, Editora, AnoPublicacao, QuantidadePaginas, QuantidadeDisponivel, TipoItemBiblioteca.LIVRO);
        setAutor                (Autor);
        setGenero               (Genero);
        setIsbn                 (Isbn);
        setNumeroEdicao         (NumeroEdicao);
    }
    
    // AUTOR
    public String getAutor() {
        return autor;
    }
    public void setAutor(String Autor) {
        if(Autor == null || Autor.trim().isEmpty())
            throw new IllegalArgumentException("Nome de autor não inserido!");

        this.autor = Autor.trim();
    }
    
    // GENERO
    public String getGenero() {
        return genero;
    }
    public void setGenero(String Genero) {
        if(Genero == null || Genero.trim().isEmpty())
            throw new IllegalArgumentException("O gênero do livro não foi inserido!");

        this.genero = Genero.trim();
    }
    
    // ISBN
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String Isbn) {
        if(Isbn == null || Isbn.trim().isEmpty())
            throw new IllegalArgumentException("O número do livro não foi inserido!");

        this.isbn = Isbn.trim();
    }

    // NÚMERO DE EDIÇÃO
    public Integer getNumeroEdicao() {
        return this.numeroEdicao;
    }
    public void setNumeroEdicao(Integer Edicao) {
        if(Edicao == null || Edicao < 0)
            throw new IllegalArgumentException("Edição inválida!");

        this.numeroEdicao = Edicao;
    }
}