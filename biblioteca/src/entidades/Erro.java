package entidades;

public class Erro {
    String Mensagem;
    //Numero do erro, caso queira usar
    String Identificador;

    public String GetError()
    {
        return this.Mensagem;
    }
    public void SetErro(String mensagem)
    {
        this.Mensagem = mensagem;
    }
}
