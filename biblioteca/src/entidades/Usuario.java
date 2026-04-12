package entidades;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Usuario {
    private String Nome;
    private String CodigoUsuario;
    private LocalDate DataNascimento;
    private TipoUsuario tipoUsuario;
    // Armazena apenas o codigo/id de cada emrpestimo feito
    private List<String> codigoEmprestimos;

    public Usuario(String nome, String codigoUsuario, LocalDate dataNascimento, TipoUsuario tipo) {
        setNome(nome);
        setCodigoUsuario(codigoUsuario);
        setDataNascimento(dataNascimento);
        setTipoUsuario(tipo);
        codigoEmprestimos = new ArrayList<>();
    }

    // GETTER E SETTERS
    // NOME
    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        if (nome != null)
            nome = nome.trim();

        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("O nome do usuário nã pode estar vazio. Tente novamente!");

        this.Nome = nome;
    }

    // CÓDIGO DO USUÁRIO
    public String getCodigoUsuario() {
        return CodigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        if (codigoUsuario != null)
            codigoUsuario = codigoUsuario.trim();

        if (codigoUsuario == null || codigoUsuario.isEmpty())
            throw new IllegalArgumentException("Codigo de usuário não inserido. Tente novamente!");

        this.CodigoUsuario = codigoUsuario;
    }

    // DATA DE NASCIMENTO
    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento)
    {
        if(dataNascimento == null)
            throw new IllegalArgumentException("Data de nascimento não inserida. Tente novamente!");
     
        if(dataNascimento.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Data de nascimento invalida. Tente novamente!");

        this.DataNascimento = dataNascimento;
    }

    // CÓDIGOS DOS EMPRÉSTIMOS
    public List<String> getCodigoEmprestimos() {
        return codigoEmprestimos;
    }

    public void setCodigoEmprestimos(String codigoEmprestimo) {
        if(codigoEmprestimo != null)
            codigoEmprestimo = codigoEmprestimo.trim();

        if(codigoEmprestimo == null || codigoEmprestimo.isEmpty())
            throw new IllegalArgumentException("Codigo de empréstimo não inserido. Tente novamente!");
     
        if(codigoEmprestimos.contains(codigoEmprestimo))
            throw new IllegalArgumentException("Este código de emprestimo esté registrado para este usuario!");
        
        codigoEmprestimos.add(codigoEmprestimo);
    }

    // TIPO USUÁRIO
    public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }
    public void setTipoUsuario(TipoUsuario tipoUser) {
        this.tipoUsuario = tipoUser;
    }
}