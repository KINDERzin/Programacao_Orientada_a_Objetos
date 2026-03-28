package entidades;
import java.util.Date;
import java.util.List;

public class Usuario
{
    private String Nome;
    private String Registro;
    private Date DataNascimento;
    // Numero de cada livro emprestado
    private List<String> livrosEmprestados;

    public Usuario(String nome, String registro, Date dataNascimento)
    {
        setNome(nome);
        setRegistro(registro);
        setDataNascimento(dataNascimento);   
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
    // REGISTRO
    public String getRegistro()
    {
        return Registro;
    }
    public void setRegistro(String registro)
    {
        this.Registro = registro;
    }
    // DATA DE NASCIMENTO
    public Date getDataNascimento()
    {
        return DataNascimento;
    }
    public void setDataNascimento(Date dataNascimento)
    {
        this.DataNascimento = dataNascimento;
    }
    // LIVROS EMPRESTADOS
    public List<String> getLivrosEmprestados()
    {
        return livrosEmprestados;
    }
    public void setLivrosEmprestados(String livroEmprestado)
    {
        this.livrosEmprestados.add(livroEmprestado);
    }
}
