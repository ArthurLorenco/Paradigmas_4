package Ex9;
import java.time.LocalDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Alunos {
    private String nome;
    private String CPF;
    private LocalDate dataNascimento;
    ArrayList<TreinosFixo> treinosDisponiveis = new ArrayList<>();
    ArrayList<TreinoFazivel> treinosFeitos = new ArrayList<>();
    TreinoFazivel treinoAtual = new TreinoFazivel();

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

    public void addTreinoDisponivel(TreinosFixo treino) {
        treinosDisponiveis.add(treino);
    }

    public void EscolherTreino(Scanner sc, LocalDate data){

        TreinoFazivel treino = new TreinoFazivel();

        System.out.println("Qual dos treinos a seguir o aluno quer fazer?");
        for(int i=0; i<treinosDisponiveis.size(); i++){
            System.out.println("Treino " + (i+1) + ":\n" + treinosDisponiveis.get(i).toString());
        }

        while(true) {
            int opcao = sc.nextInt();
            if (opcao > 0 && opcao <= treinosDisponiveis.size()) {
                treino = treinosDisponiveis.get(opcao).iniciarTreino(data);
                break;
            } else {
                System.out.println("opcao invalida, tente novamente" );
            }
        }

        treinoAtual = treino;
    }

    public void finalizarTreinoAtual(){

        treinosFeitos.add(treinoAtual);
        treinoAtual = null;

    }


    @Override
    public String toString() {
        String nomeFormatado = String.format("%-15s", nome);
        return CPF + "  " + nomeFormatado + "   " + dataNascimento;
    }
}
