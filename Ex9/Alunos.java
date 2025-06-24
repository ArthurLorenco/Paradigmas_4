package Ex9;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Alunos {
    private String nome;
    private String CPF;
    private LocalDate dataNascimento;
    private Planos plano;

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

    public static String formatarCPF(String cpf) {
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

    public void EscolherTreinoDisponivel(Scanner sc, ArrayList<TreinosFixo> ListaTreinosDisponiveis) {

        if(ListaTreinosDisponiveis.isEmpty()) {
            System.out.println("nao tem treinos");
            return;
        }

        System.out.println("Qual dos trenos a seguir eh?" );
        for(int i=0; i<ListaTreinosDisponiveis.size(); i++){
            System.out.println("Treino " + (i+1) + ":\n" + ListaTreinosDisponiveis.get(i).toString());
        }

        while(true) {
            int opcao = sc.nextInt();
            if (opcao > 0 && opcao <= ListaTreinosDisponiveis.size()) {
                treinosDisponiveis.add(ListaTreinosDisponiveis.get(opcao-1));
                break;
            } else {
                System.out.println("opcao invalida, tente novamente" );
            }
        }
    }
    public void EscolherPlano(Scanner sc, ArrayList<Planos> ListaPlanos) {

        if(ListaPlanos.isEmpty()) {
            System.out.println("nao tem planos");
            return;
        }

        System.out.println("Qual dos planos a seguir eh?" );
        for(int i=0; i<ListaPlanos.size(); i++){
            System.out.println("Plano " + (i+1) + ":\n" + ListaPlanos.get(i).toString());
        }

        while(true) {
            int opcao = sc.nextInt();
            if (opcao > 0 && opcao <= ListaPlanos.size()) {
                this.plano = ListaPlanos.get(opcao-1);
                break;
            } else {
                System.out.println("opcao invalida, tente novamente" );
            }
        }
    }
    public void ExcluirTreinoDisponivel(Scanner sc) {

        if(treinosDisponiveis.isEmpty()) {
            System.out.println("nao tem treinos disponiveis");
            return;
        }

        System.out.println("Qual dos treinos quer excluir?" );
        for(int i=0; i<treinosDisponiveis.size(); i++){
            System.out.println("Treino " + (i+1) + ":\n" + treinosDisponiveis.get(i).toString());
        }

        while(true) {
            int opcao = sc.nextInt();
            if (opcao > 0 && opcao <= treinosDisponiveis.size()) {
                treinosDisponiveis.remove(treinosDisponiveis.get(opcao-1));
                break;
            } else {
                System.out.println("opcao invalida, tente novamente" );
            }
        }

    }
    public void EscolherTreinoPraFazer(Scanner sc){

        TreinoFazivel treino = new TreinoFazivel();

        if(treinosDisponiveis.isEmpty()){
            System.out.println("Nenhum treino cadastrado pro aluno");
            return;
        }

        System.out.println("Qual dos treinos a seguir o aluno quer fazer?");
        for(int i=0; i<treinosDisponiveis.size(); i++){
            System.out.println("Treino " + (i+1) + ":\n" + treinosDisponiveis.get(i).toString());
        }

        while(true) {
            int opcao = sc.nextInt();
            if (opcao > 0 && opcao <= treinosDisponiveis.size()) {
                TreinosFixo tfixo = treinosDisponiveis.get(opcao-1);
                treino.exerciciosCargas = tfixo.exerciciosCargas;
                treino.exerciciosLista = tfixo.exerciciosLista;
                break;
            } else {
                System.out.println("opcao invalida, tente novamente" );
            }
        }
        treino.setDataDoTreino(LocalDate.now());
        treinoAtual = treino;
        treinoAtual.InicializarListaBoolean();
    }
    public void finalizarTreinoAtual(){

        treinosFeitos.add(treinoAtual);
        treinoAtual = null;

    }

    public void ListarTreinosDisponiveis(){
        int i = 1;

        if(treinosDisponiveis.isEmpty()) {
            System.out.println("nao tem treinos");
        }

        for (TreinosFixo treino : treinosDisponiveis) {
            System.out.println("Treino " + i + ": " + treino);
            i++;
        }
        System.out.println();

    }
    public void ExecutarTreino(Scanner sc){

        int opcao = 1;
        while (opcao != 0) {
            System.out.print("(treinando) O que vai fzr?\n" +
                    "1 - Listar exercicios ainda não feitos\n" +
                    "2 - Finalizar treino\n" +
                    "3 - Marcar exercicio como concluido\n" +
                    "4 - Alterar carga de algum exercicio\n" +
                    "0 - Sair\n\n");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    treinoAtual.ListarExerciciosAindaNaoFeitos();
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    treinoAtual.marcarComoFeito(sc);
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Opcao invalida, tenta dnv");
                    break;
                }

            }

        }
    }

    public static void ListarAlunos(ArrayList<Alunos> alunos) {
        for (Alunos aluno : alunos) {
            System.out.println(aluno);
        }
    }
    public static void AdicionarAluno(Scanner sc, ArrayList<Alunos> ListaAlunos, Map<String, Alunos> MapAlunosPorCpf, Map<String, Alunos> MapAlunosPorNome) {

        Alunos aluno = new Alunos(sc);

        ListaAlunos.add(aluno);
        MapAlunosPorCpf.put(aluno.getCPF(), aluno);
        MapAlunosPorNome.put(aluno.getNome(), aluno);
    }
    public static void EditarAluno(Scanner sc, Map<String, Alunos> MapAlunosPorCpf, Map<String, Alunos> MapAlunosPorNome, ArrayList<Planos> ListaPlanos, ArrayList<TreinosFixo> ListaTreinoFixo){

        Alunos alunoPraEditar = BuscarAluno(sc, MapAlunosPorCpf, MapAlunosPorNome);

        if(alunoPraEditar == null)
            return;

        int opcao = 1;

        while(opcao != 0) {
            System.out.print("(editar aluno) O que voce quer fazer?\n" +
                    "1 - Escolher um plano para o aluno\n" +
                    "2 - Escolher um treino pro aluno fazer agora\n" +
                    "3 - Excluir um treino do aluno \n" +
                    "4 - Adicionar um treino pro aluno \n" +
                    "0 - Sair\n");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:{
                    alunoPraEditar.EscolherPlano(sc, ListaPlanos);
                    break;
                }
                case 2:{
                    alunoPraEditar.EscolherTreinoPraFazer(sc);
                    break;
                }
                case 3:{
                    alunoPraEditar.ExcluirTreinoDisponivel(sc);
                    break;
                }
                case 4:{
                    alunoPraEditar.EscolherTreinoDisponivel(sc, ListaTreinoFixo);
                    break;
                }
                case 0:{
                    break;
                }
                default:
                    System.out.println("opcao invalida");
                    break;
            }
        }









    }
    public static void ExcluirAluno(Scanner sc, ArrayList<Alunos> ListaAlunos, Map<String, Alunos> MapAlunosPorCpf, Map<String, Alunos> MapAlunosPorNome) {
        Alunos alunoPraExcluir = BuscarAluno(sc, MapAlunosPorCpf, MapAlunosPorNome);

        if(alunoPraExcluir == null){
            return;
        }

        ListaAlunos.remove(alunoPraExcluir);
        MapAlunosPorCpf.remove(alunoPraExcluir.getCPF());
        MapAlunosPorNome.remove(alunoPraExcluir.getNome());

        System.out.println("Aluno excluido!");

    }
    public static Alunos BuscarAluno(Scanner sc, Map<String, Alunos> MapAlunosPorCpf, Map<String, Alunos> MapAlunosPorNome) {

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
                    Alunos alunosComNome = MapAlunosPorNome.get(nome);

                    if (alunosComNome == null) {
                        System.out.println("Nenhum aluno encontrado com o nome " + nome);
                        return null;
                    } else {
                        System.out.println("Aluno esncontrado: \n" + alunosComNome.toString());
                        return alunosComNome;
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
