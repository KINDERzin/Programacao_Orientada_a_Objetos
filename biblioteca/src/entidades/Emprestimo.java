package entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    String codigoEmprestimo; // ID do emprestimo
    String registroUsuario;
    String idLivro;
    double multa;
    boolean emprestado; // Verifica se ja foi devolvido ou não
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;

    public Emprestimo(String codigoEmprestimo, String registroUsuario, String IdLivro, LocalDate dataEmprestimo, LocalDate dataDevolucao, boolean emprestado) {
        setCodigoEmprestimo(codigoEmprestimo);
        setRegistroUsuario(registroUsuario);
        setIdLivro(IdLivro);
        setDataEmprestimo(dataEmprestimo);
        setDataDevolucao(dataDevolucao);
        setEmprestado(emprestado);
    }

    // CÓDIGO DO EMPRÉSTIMO
    public String getCodigoEmprestimo() {
        return this.codigoEmprestimo;
    }
    public void setCodigoEmprestimo(String CodigoEmprestimo) {
        if(CodigoEmprestimo == null || CodigoEmprestimo.trim().isEmpty())
            throw new IllegalArgumentException("O código do empréstimo é inválido!");

        this.codigoEmprestimo = CodigoEmprestimo.trim();
    }

    // REGISTRO DO USUÁRIO
    public String getRegistroUsuario() {
        return this.registroUsuario;
    }
    public void setRegistroUsuario(String RegistroUsuario) {
        if(RegistroUsuario == null || RegistroUsuario.trim().isEmpty())
            throw new IllegalArgumentException("O código de usuário é invalido!");

        this.registroUsuario = RegistroUsuario.trim();
    }

    // ID DO LIVRO
    public String getIdLivro() {
        return idLivro;
    }
    public void setIdLivro(String IdLivro) {
        if(IdLivro == null || IdLivro.trim().isEmpty())
            throw new IllegalArgumentException("O número do livro é inválido!");
        
        this.idLivro = IdLivro.trim();
    }

    // DATA EMPRÉSTIMO
    public LocalDate getDataEmprestimo() {
        return this.dataEmprestimo;
    }
    public void setDataEmprestimo(LocalDate DataEmprestimo) {
        if(DataEmprestimo == null)
            throw new IllegalArgumentException("A data do empréstimo é inválida!");
        
        if(DataEmprestimo.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Não e possivel realizar um empréstimo em uma data futura!");
        
        this.dataEmprestimo = DataEmprestimo;
    }

    // DATA DA DEVOLUÇÃO
    public LocalDate getDataDevolucao() {
        return this.dataDevolucao;
    }
    public void setDataDevolucao(LocalDate DataDevolucao) {
        if(DataDevolucao == null || DataDevolucao.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Data de devolução inválida!");

        this.dataDevolucao = DataDevolucao;
    }

    // EMPRESTADO
    public boolean getEmprestado() {
        return this.emprestado;
    }
    public void setEmprestado(Boolean Emprestado) {
        if(Emprestado == null)
            throw new IllegalArgumentException("E ai, tá emprestado ou não?");
    
        this.emprestado = Emprestado;
    }

    // MULTA
    public double getMulta() {
        return this.multa;
    }
    public void calculaMulta(LocalDate DataAtual) {
        if(DataAtual == null)
            throw new IllegalArgumentException("Data não inserida");

        if(DataAtual.isBefore(dataEmprestimo))
            throw new IllegalArgumentException("A data de devolução não pode ser anterior à data de empréstimo!");

        int diasAtraso = (int) ChronoUnit.DAYS.between(dataDevolucao, DataAtual);

        if (DataAtual.isAfter(dataDevolucao)) {
            if (DataAtual.isAfter(dataDevolucao) && diasAtraso >= 1 && diasAtraso <= 3)
                this.multa = diasAtraso * 2.0;
            if (DataAtual.isAfter(dataDevolucao) && diasAtraso > 3)
                this.multa = diasAtraso * 5.0;
            else
                throw new IllegalArgumentException("Data de devolução inválida!");
        } 
        else
            this.multa = 0.0;
    }
}