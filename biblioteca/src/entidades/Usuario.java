package entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private String Nome;
    private String CodigoUsuario;
    private Integer limiteEmprestimos;
    private TipoUsuario tipoUsuario;
    // Armazena apenas o codigo/id de cada emrpestimo feito
    private List<String> codigoEmprestimos;

    public Usuario(String nome, String codigoUsuario, TipoUsuario tipo, Integer limiteEmprestimos) {
        setNome(nome);
        setCodigoUsuario(codigoUsuario);
        setTipoUsuario(tipo);
        setLimiteEmprestimos(limiteEmprestimos);
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

    // LIMITE DE EMPRÉSTIMOS
    public Integer getLimiteEmprestimos() {
        return this.limiteEmprestimos;
    }
    public void setLimiteEmprestimos(Integer limiteEmprestimos) {
        if (limiteEmprestimos == null || limiteEmprestimos < 0)
            throw new IllegalArgumentException("Limite de empréstimos inválido. Tente novamente!");

        this.limiteEmprestimos = limiteEmprestimos;
    }
}