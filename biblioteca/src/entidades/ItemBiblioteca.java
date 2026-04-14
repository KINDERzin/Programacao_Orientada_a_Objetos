package entidades;

public abstract class ItemBiblioteca {
    private String codigoUnico;
    private String titulo;
    private String editora;
    private Integer anoPublicacao;
    private Integer quantidadeDisponivel;
    private Integer quantidadePaginas;
    private TipoItemBiblioteca tipoItem;

    public ItemBiblioteca(String CodigoUnico, String Titulo, String Editora, Integer AnoPublicacao, Integer QuantidadePaginas, Integer QuantidadeDisponivel, TipoItemBiblioteca tipoItem) {
        setCodigo(CodigoUnico);
        setTitulo(Titulo);
        setEditora(Editora);
        setAnoPublicacao(AnoPublicacao);
        setQuantidadePaginas(QuantidadePaginas);
        setQuantidadeDisponivel(QuantidadeDisponivel);
        setTipoItem(tipoItem);
    }

    // CÓDIGO ÚNICO
    public String getCodigo() {
        return codigoUnico;
    }
    public void setCodigo(String CodigoUnico) {
        if(CodigoUnico == null || CodigoUnico.trim().isEmpty())
            throw new IllegalArgumentException("O código único do item é inválido!");

        this.codigoUnico = CodigoUnico.trim();
    }

    // TÍTULO
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String Titulo) {
        if(Titulo == null || Titulo.trim().isEmpty())
            throw new IllegalArgumentException("O titulo não foi inserido!");

        this.titulo = Titulo.trim();
    }

    // Editora
    public String getEditora() {
        return editora;
    }
    public void setEditora(String Editora) {
        if(Editora == null || Editora.trim().isEmpty())
            throw new IllegalArgumentException("A Editora não foi inserida!");

        this.editora = Editora.trim();
    }

    // ANO PUBLICAÇAO
    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setAnoPublicacao(Integer AnoPublicado) {
        this.anoPublicacao = AnoPublicado;
    }
    
    // QUANTIDADE DE PÁGINAS
    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }
    public void setQuantidadePaginas(Integer QuantidadePaginas) {
        if(QuantidadePaginas == null || QuantidadePaginas <= 0)
            throw new IllegalArgumentException("Número de páginas inválido!");

        this.quantidadePaginas = QuantidadePaginas;
    }

    //QUANTIDADE DISPONÍVEL
    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }
    public void setQuantidadeDisponivel(Integer QuantidadeDisponivel) {
        if(QuantidadeDisponivel == null || QuantidadeDisponivel < 0)
            throw new IllegalArgumentException("Quantidade de livros diponíveis é inválida!");

        this.quantidadeDisponivel = QuantidadeDisponivel;
    }

    // REALIZAÇÃO EMPRÉSTIMO OU DEVOLUÇAO
    public void realizarEmprestimo() {
        quantidadeDisponivel--;
    }
    public void realizarDevolucao() {
        quantidadeDisponivel++;
    }

    // TIPO DE ITEM
    public TipoItemBiblioteca getTipoItem() {
        return tipoItem;
    }
    public void setTipoItem(TipoItemBiblioteca tipoItem) {
        if(tipoItem == null)
            throw new IllegalArgumentException("O tipo do item é inválido!");

        this.tipoItem = tipoItem;
    }

    public void ShowData() {
        System.out.println("Código: " + getCodigo());
        System.out.println("Título: " + getTitulo());
        System.out.println("Editora: " + getEditora());
        System.out.println("Ano de Publicação: " + getAnoPublicacao());
        System.out.println("Quantidade de Páginas: " + getQuantidadePaginas());
        System.out.println("Quantidade Disponível: " + getQuantidadeDisponivel());
        System.out.println("Tipo do Item: " + getTipoItem());
    }
}