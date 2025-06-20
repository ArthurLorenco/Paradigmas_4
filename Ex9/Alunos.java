package Ex9;
import java.time.LocalDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Alunos {
    private String nome;
    private String CPF;
    private LocalDate dataNascimento;

    ArrayList<TreinosFixo> treinosDisponiveis = new ArrayList<>();
    ArrayList<TreinoFazivel> treinosFeitos = new ArrayList<>();

    TreinoFazivel treinoAtual = new TreinoFazivel();

    public Alunos(Scanner sc) {

        sc.nextLine();

        System.out.println("Digite o nome do aluno: ");
        String nome = sc.nextLine();
        this.setNome(nome);
        System.out.println("Digite o cpf do aluno: ");
        String CPF = sc.nextLine();
        this.setCPF(CPF);
        System.out.println("Digite a data de nascimento (YYYY-MM-DD): ");
        String dataNascimento = sc.nextLine();
        this.setDataNascimento(LocalDate.parse(dataNascimento));

    }
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

        this.nome = formatarNome(nome);

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

    private static String formatarCPF(String cpf) {
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);
    }
    private static String formatarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("nome vazio");
        }

        nome = nome.trim();

        if (nome.length() > 15)
            nome = nome.substring(0, 15);
        return nome;
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

    public static void ListarAlunos(ArrayList<Alunos> alunos) {
        for (Alunos aluno : alunos) {
            System.out.println(aluno);
        }
    }

    public static void AdicionarAluno(Scanner sc, ArrayList<Alunos> ListaAlunos, Map<String, Alunos> MapAlunosPorCpf, Map<String, List<Alunos>> MapAlunosPorNome) {

        Alunos aluno = new Alunos(sc);

        ListaAlunos.add(aluno);
        MapAlunosPorCpf.put(aluno.getCPF(), aluno);
        MapAlunosPorNome.computeIfAbsent(aluno.getNome(), k -> new ArrayList<>()).add(aluno);
    }

    public static Alunos BuscarAluno(Scanner sc, ArrayList<Alunos> ListaAlunos, Map<String, Alunos> MapAlunosPorCpf, Map<String, List<Alunos>> MapAlunosPorNome) {

        Alunos alunoBuscado = null;
        int escolha = 1;

        while(escolha != 0) {
            System.out.print("Como voce quer buscar o aluno?\n" +
                    "1 - por nome\n" +
                    "2 - por CPF\n" +
                    "0 - Sair (retorna null)" );
            escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha) {
                case 1:{
                    System.out.println("Digite o nome do aluno: ");
                    String nome = sc.nextLine();
                    nome = formatarNome(nome);
                    List<Alunos> alunosComNome = MapAlunosPorNome.get(nome);

                    if (alunosComNome == null || alunosComNome.isEmpty()) {
                        System.out.println("Nenhum aluno encontrado com o nome " + nome);
                        return null;
                    } else {
                        if(alunosComNome.size() > 1){
                            System.out.println("Alunos encontrados com o nome \"" + nome + "\":" );
                            for (Alunos aluno : alunosComNome) {
                                System.out.println(aluno);
                            }
                        }else{
                            System.out.println("Aluno esncontrado: \n" + alunosComNome.get(0).toString());
                        }
                        return alunosComNome.getFirst();
                    }
                }
                case 2:{
                    System.out.println("Digite o CPF do aluno: ");
                    String cpf = sc.nextLine();
                    cpf = formatarCPF(cpf);

                    Alunos cpfEncontrado = MapAlunosPorCpf.get(cpf);

                    if(cpfEncontrado == null){
                        System.out.println("Nenhum aluno encontrado com o cpf " + cpf);
                        return null;
                    }else {
                        System.out.println("Aluno encontrado com o cpf digitado: " + cpfEncontrado.toString());
                        return cpfEncontrado;
                    }
                }
                case 0:{
                    break;
                }
                default:{
                    System.out.println("Opcao invalida, tente novamente");
                    break;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String nomeFormatado = String.format("%-15s", nome);
        return CPF + "  " + nomeFormatado + "   " + dataNascimento;
    }
}
