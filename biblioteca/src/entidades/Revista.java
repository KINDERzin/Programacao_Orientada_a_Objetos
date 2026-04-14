package entidades;

public class Revista extends ItemBiblioteca{
    private String issn;
    private String temaPrincipal; 
    private Integer numeroEdicao;

    public Revista(String CodigoUnico, String Titulo, String Editora, Integer AnoPublicacao, Integer QuantidadePaginas, Integer QuantidadeDisponivel,String Issn, String TemaPrincipal, Integer NumeroEdicao) {
        super(CodigoUnico, Titulo, Editora, AnoPublicacao, QuantidadePaginas, QuantidadeDisponivel, TipoItemBiblioteca.REVISTA);
        setIssn(Issn);
        setTemaPrincipal(TemaPrincipal);
        setNumeroEdicao(NumeroEdicao);
    }
    // ISSN
    public String getIssn() {
        return issn;
    }
    public void setIssn(String Issn) {
        if(Issn == null || Issn.trim().isEmpty())
            throw new IllegalArgumentException("O número do livro nao foi inserido!");

        this.issn = Issn.trim();
    }

    // TEMA PRINCIPAL
    public String getTemaPrincipal() {
        return temaPrincipal;
    }
    public void setTemaPrincipal(String Tema) {
        if(Tema == null || Tema.trim().isEmpty())
            throw new IllegalArgumentException("O tema da revista inserido não é válido!");
        
        this.temaPrincipal = Tema.trim(); 
    }

    // NÚMERO DE EDIÇÃO
    public Integer getNumeroEdicao() {
        return numeroEdicao;
    }
    public void setNumeroEdicao(Integer Edicao) {
        if(Edicao == null || Edicao < 0)
            throw new IllegalArgumentException("Edição inválida!");

        this.numeroEdicao = Edicao;
    }
}
