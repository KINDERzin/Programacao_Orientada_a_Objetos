package entidades;

public class ItemBiblioteca {
    private String titulo;
    private String editora;
    private Integer anoPublicacao;
    public Integer quantidadeDisponivel;
    public Integer quantidadePaginas;

    // TÍTULO
    public String getTitulo()
    {
        return titulo;
    }
    public void setTitulo(String titulo)
    {
        if(titulo != null)
            titulo = titulo.trim();

        if(titulo == null || titulo.isEmpty())
            throw new IllegalArgumentException("O titulo não foi inserido!");

        this.titulo = titulo;
    }

    // Editora
    public String getEditora()
    {
        return editora;
    }
    public void setEditora(String editora)
    {
        if(editora == null || editora.isEmpty())
            throw new IllegalArgumentException("A Editora não foi inserida!");

        if(editora != null)
            editora = editora.trim();

        this.editora = editora;
    }

    // ANO PUBLICAÇAO
    public Integer getAnoPublicacao() {
        return this.anoPublicacao;
    }
    public void setAnoPublicacao(Integer anoPublicado) {
        this.anoPublicacao = anoPublicado;
    }
    
    // QUANTIDADE DE PÁGINAS
    public Integer getQuantidadePaginas()
    {
        return quantidadePaginas;
    }
    public void setQuantidadePaginas(Integer quantidadePaginas)
        {
            if(quantidadePaginas == null || quantidadePaginas <= 0)
                throw new IllegalArgumentException("Número de páginas inválido!");
    
            this.quantidadePaginas = quantidadePaginas;
        }

    //QUANTIDADE DISPONÍVEL
    public Integer getQuantidadeDisponivel()
    {
        return quantidadeDisponivel;
    }
    public void setQuantidadeDisponivel(Integer quantidadeDisponivel)
    {
        if(quantidadeDisponivel == null || quantidadeDisponivel < 0)
            throw new IllegalArgumentException("Quantidade de livros diponíveis é inválida!");

        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    // REALIZAÇÃO EMPRÉSTIMO OU DEVOLUÇAO
    public void realizarEmprestimo()
    {
        this.quantidadeDisponivel--;
    }
    public void realizarDevolucao()
    {
        this.quantidadeDisponivel++;
    }
}