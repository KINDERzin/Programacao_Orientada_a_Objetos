package entidades;

public class Tese extends ItemBiblioteca{
    private String autor;
    private String orientador;
    private String areaPesquisada;

    public Tese(String CodigoUnico, String Titulo, String Editora, Integer AnoPublicacao, Integer QuantidadePaginas, Integer QuantidadeDisponivel, String Autor, String Orientador, String AreaPesquisada) {
        super(CodigoUnico, Titulo, Editora, AnoPublicacao, QuantidadePaginas, QuantidadeDisponivel, TipoItemBiblioteca.TESE);
        setAutor(Autor);
        setOrientador(Orientador);
        setAreaPesquisada(AreaPesquisada);
    }

    // AUTOR
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do autor não pode ser vazio ou nulo!");
        }
        this.autor = autor.trim();
    }

    // ORIENTADOR
    public String getOrientador() {
        return orientador;
    }
    public void setOrientador(String orientador) {
        if (orientador == null || orientador.trim().isEmpty())
            throw new IllegalArgumentException("O nome do orientador não pode ser vazio ou nulo!");
        
        this.orientador = orientador.trim();
    }

    // ÁREA PESQUISADA 
    public String getAreaPesquisada() {
        return areaPesquisada;
    }
    public void setAreaPesquisada(String areaPesquisada) {
        if (areaPesquisada == null || areaPesquisada.trim().isEmpty()) 
            throw new IllegalArgumentException("A área pesquisada deve ser informada!");
        
        this.areaPesquisada = areaPesquisada.trim();
    }
}
