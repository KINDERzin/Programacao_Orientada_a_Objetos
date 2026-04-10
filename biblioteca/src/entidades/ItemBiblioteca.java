package entidades;

public class ItemBiblioteca {
    private String Titulo;
    private String Editora;
    private Integer AnoPublicacao;
    public Integer QuantidadeDisponivel;
    public Integer QuantidadePaginas;

    // TÍTULO
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

    // Editora
    public String getEditora()
    {
        return Editora;
    }
    public void setEditora(String editora)
    {
        if(editora == null || editora.isEmpty())
            throw new IllegalArgumentException("A Editora não foi inserida!");

        if(editora != null)
            editora = editora.trim();

        this.Editora = editora;
    }

    // ANO PUBLICAÇAO
    public Integer getAnoPublicacao() {
        return this.AnoPublicacao;
    }
    public void setAnoPublicacao(Integer anoPublicado) {
        this.AnoPublicacao = anoPublicado;
    }
    
    // QUANTIDADE DE PÁGINAS
    public Integer getQuantidadePaginas()
    {
        return quantidadePaginas;
    }
    public void setQuantidadePaginas(Integer QuantidadePaginas)
        {
            if(QuantidadePaginas == null || QuantidadePaginas <= 0)
                throw new IllegalArgumentException("Número de páginas inválido!");
    
            this.quantidadePaginas = QuantidadePaginas;
        }

    //QUANTIDADE DISPONÍVEL
    public Integer getQuantidadeDisponivel()
    {
        return QuantidadeDisponivel;
    }
    public void setQuantidadeDisponivel(Integer quantidadeDisponivel)
    {
        if(quantidadeDisponivel == null || quantidadeDisponivel < 0)
            throw new IllegalArgumentException("Quantidade de livros diponíveis é inválida!");

        this.QuantidadeDisponivel = quantidadeDisponivel;
    }

    // REALIZAÇÃO EMPRÉSTIMO OU DEVOLUÇAO
    public void realizarEmprestimo()
    {
        this.QuantidadeDisponivel--;
    }
    public void realizarDevolucao()
    {
        this.QuantidadeDisponivel++;
    }
}