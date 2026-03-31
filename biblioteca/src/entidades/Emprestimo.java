package entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    // ID do emprestimo
    String codigoEmprestimo;
    String registroUsuario;
    String Isbn;
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;
    // Verifica se ja foi devolvido ou não
    boolean emprestado;
    double multa;

    public Emprestimo(String codigoEmprestimo, String registroUsuario, String Isbn, LocalDate dataEmprestimo, LocalDate dataDevolucao, boolean emprestado) {
        setCodigoEmprestimo(codigoEmprestimo);
        setRegistroUsuario(registroUsuario);
        setIsbn(Isbn);
        setDataEmprestimo(dataEmprestimo);
        setDataDevolucao(dataDevolucao);
        setEmprestado(emprestado);
    }

    // --- GETTERS AND SETTERS ---
    // CÓDIGO DO EMPRÉSTIMO
    public String getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public void setCodigoEmprestimo(String codigoEmprestimo) {
        if(codigoEmprestimo != null)
            codigoEmprestimo = codigoEmprestimo.trim();

        if(codigoEmprestimo == null || codigoEmprestimo.isEmpty())
            throw new IllegalArgumentException("O código do empréstimo é inválido!");

        this.codigoEmprestimo = codigoEmprestimo;
    }

    // REGISTRO DO USUÁRIO
    public String getRegistroUsuario() {
        return registroUsuario;
    }

    public void setRegistroUsuario(String registroUsuario) {
        if(registroUsuario != null)
            registroUsuario = registroUsuario.trim();

        if(registroUsuario == null || registroUsuario.isEmpty())
            throw new IllegalArgumentException("O código de usuário é invalido!");

        this.registroUsuario = registroUsuario;
    }

    // NÚMERO DO LIVRO
    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String Isbn) {
        if(Isbn != null)
            Isbn = Isbn.trim();

        if(Isbn == null || Isbn.isEmpty())
            throw new IllegalArgumentException("O número do livro é inválido!");
        
        this.Isbn = Isbn;
    }

    // DATA EMPRÉSTIMO
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        if(dataEmprestimo == null)
            throw new IllegalArgumentException("A data do empréstimo é inválida!");
        
        if(dataEmprestimo.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Não e possivel realizar um empréstimo em uma data futura!");
        this.dataEmprestimo = dataEmprestimo;
    }

    // DATA DA DEVOLUÇÃO
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        if(dataDevolucao == null || dataDevolucao.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Data de devolução inválida!");

        this.dataDevolucao = dataDevolucao;
    }

    // EMPRESTADO - true or false
    public boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(Boolean emprestado) {
        if(emprestado == null)
            throw new IllegalArgumentException("E ai, tá emprestado ou não?");
    
        this.emprestado = emprestado;
    }

    // MULTA
    public double getMulta() {
        return multa;
    }

    public void calculaMulta(LocalDate dataAtual) {
        if(dataAtual == null)
            throw new IllegalArgumentException("Data não inserida");

        if(dataAtual.isBefore(dataEmprestimo))
            throw new IllegalArgumentException("A data de devolução não pode ser anterior à data de empréstimo!");

        int diasAtraso = (int) ChronoUnit.DAYS.between(dataDevolucao, dataAtual);

        if (dataAtual.isAfter(dataDevolucao)) {
            if (dataAtual.isAfter(dataDevolucao) && diasAtraso >= 1 && diasAtraso <= 3)
                this.multa = diasAtraso * 2.0;
            else
                this.multa = diasAtraso * 5.0;
        } 
        else
            this.multa = 0.0;
    }
}