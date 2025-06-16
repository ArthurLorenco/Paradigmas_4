package Ex9;
import java.time.LocalDate;

import java.time.LocalDate;

public class Alunos {
    private String nome;
    private String CPF;
    private LocalDate dataNascimento;

    public Alunos() {}
    public Alunos(String nome, String CPF, LocalDate dataNascimento) {
        this.setNome(nome);
        this.setCPF(CPF);
        this.setDataNascimento(dataNascimento);
    }

    public String getNome() {
        return nome;
    }
    public String getCPF() {
        return CPF;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("nome vazio");
        }

        nome = nome.trim();

        if (nome.length() > 15)
            nome = nome.substring(0, 15);

        this.nome = nome;
    }
    public void setCPF(String CPF) {
        if (CPF.matches("\\d{11}")) {
            this.CPF = formatarCPF(CPF);
        } else {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos.");
        }
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    private String formatarCPF(String cpf) {
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);
    }

    @Override
    public String toString() {
        String nomeFormatado = String.format("%-15s", nome);
        return CPF + "  " + nomeFormatado + "   " + dataNascimento;
    }
}
