package entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    // ID do emprestimo
    String codigoEmprestimo;
    String registroUsuario;
    String numeroLivro;
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;
    // Verifica se ja foi devolvido ou não
    boolean emprestado;
    double multa;

    public Emprestimo(String codigoEmprestimo, String registroUsuario, String numeroLivro, LocalDate dataEmprestimo,
            LocalDate dataDevolucao, boolean emprestado) {
        setCodigoEmprestimo(codigoEmprestimo);
        setRegistroUsuario(registroUsuario);
        setNumeroLivro(numeroLivro);
        setDataEmprestimo(dataEmprestimo);
        // ADICIONAR LOGICA PARA CALCULAR A DATA DE DEVOLUÇÃO
        setDataDevolucao(dataDevolucao); // + 30 dias -
        setEmprestado(emprestado);
    }

    // --- GETTERS AND SETTERS ---
    // CÓDIGO DO EMPRÉSTIMO
    public String getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public void setCodigoEmprestimo(String codigoEmprestimo) {
        this.codigoEmprestimo = codigoEmprestimo;
    }

    // REGISTRO DO USUÁRIO
    public String getRegistroUsuario() {
        return registroUsuario;
    }

    public void setRegistroUsuario(String registroUsuario) {
        this.registroUsuario = registroUsuario;
    }

    // NÚMERO DO LIVRO
    public String getNumeroLivro() {
        return numeroLivro;
    }

    public void setNumeroLivro(String numeroLivro) {
        this.numeroLivro = numeroLivro;
    }

    // DATA EMPRÉSTIMO
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    // DATA DA DEVOLUÇÃO
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    // EMPRESTADO - true or false
    public boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    // MULTA
    public double getMulta() {
        return multa;
    }

    public void calculaMulta(LocalDate dataAtual) {
        int diasAtraso = (int) ChronoUnit.DAYS.between(dataDevolucao, dataAtual);

        if (dataAtual.isAfter(dataDevolucao)) {
            if (dataAtual.isAfter(dataDevolucao) && diasAtraso >= 1 && diasAtraso <= 3)
                this.multa = diasAtraso * 2.0;
            else
                this.multa = diasAtraso * 5.0;
        } 
        else
            this.multa = 0.0;

        return;
    }
}