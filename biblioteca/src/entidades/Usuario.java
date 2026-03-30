package entidades;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Usuario
{
    private String Nome;
    private String CodigoUsuario;
    private LocalDate DataNascimento;
    //Armazena apenas o codigo/id de cada emrpestimo feito
    private List<String> codigoEmprestimos;

    public Usuario(String nome, String codigoUsuario, LocalDate dataNascimento)
    {
        setNome          (nome);
        setCodigoUsuario (codigoUsuario);
        setDataNascimento(dataNascimento);  
        codigoEmprestimos = new ArrayList<>();
    }
    
    // GETTER E SETTERS
    //NOME
    public String getNome()
    {
        return Nome;
    }
    public void setNome(String nome)
    {
        this.Nome = nome;
    }
    // CÓDIGO DO USUÁRIO
    public String getCodigoUsuario()
    {
        return CodigoUsuario;
    }
    public void setCodigoUsuario(String codigoUsuario)
    {
        this.CodigoUsuario = codigoUsuario;
    }
    // DATA DE NASCIMENTO
    public LocalDate getDataNascimento()
    {
        return DataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento)
    {
        this.DataNascimento = dataNascimento;
    }
    // CÓDIGOS DOS EMPRÉSTIMOS
    public List<String> getCodigoEmprestimos()
    {
        return codigoEmprestimos;
    }
    public void setCodigoEmprestimos(String codigoEmprestimo)
    {
        this.codigoEmprestimos.add(codigoEmprestimo);
    }
}