package entidades;

public class Revista extends ItemBiblioteca{
    private String Issn;
    private String TemaPrincipal; 
    private Integer NumeroEdicao;

    public Revista(String issn, String temaPrincipal, Integer numeroEdicao) {
        setIssn(issn);
        setTemaPrincipal(temaPrincipal);
        setNumeroEdicao(numeroEdicao); 
    }
    // ISSN
    public String getIssn()
    {
        return Issn;
    }
    public void setIssn(String Issn)
    {
        if(Issn != null)
            Issn = Issn.trim();

        if(Issn == null || Issn.isEmpty())
            throw new IllegalArgumentException("O número do livro nao foi inserido!");

        this.Issn = Issn;
    }

    // TEMA PRINCIPAL
    public String getTemaPrincipal() {
        return this.TemaPrincipal;
    }
    public void setTemaPrincipal(String tema) {

        if( tema == null || tema.trim().isEmpty() )
            throw new IllegalArgumentException("O tema da revista inserido não é válido!");
        
        this.TemaPrincipal = tema; 
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
