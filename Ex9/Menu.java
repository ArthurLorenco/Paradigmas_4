package Ex9;

import java.time.LocalDate;
import java.util.*;

import static Ex9.Alunos.*;
import static Ex9.Exercicios.*;
import static Ex9.Planos.*;
import static Ex9.TreinosFixo.*;

public class Menu {

    public static ArrayList<Alunos> ListaAlunos = new ArrayList<>();
    public static Map<String, Alunos> MapAlunosPorCpf = new HashMap<>();
    public static Map<String, Alunos> MapAlunosPorNome = new HashMap<>();

    public static ArrayList<Exercicios> ListaExercicios = new ArrayList<>();
    public static ArrayList<Planos> ListaPlanos = new ArrayList<>();
    public static ArrayList<TreinosFixo> ListaTreinoFixo = new ArrayList<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao = 1;

        AdicionarBasico();

        while (opcao != 0) {
            System.out.printf("O que quer fzr?\n" +
                    "1 - Modificar alunos\n" +
                    "2 - Modificar exercicios\n" +
                    "3 - Modificar Treinos\n" +
                    "4 - Modificar Planos\n" +
                    "5 - Entrar como aluno\n" +
                    "0 - Sair\n\n");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    ModificarAluno(sc);
                    break;
                }
                case 2:{
                    ModificarExercicios(sc);
                    break;
                }
                case 3:{
                    ModificarTreinos(sc);
                    break;
                }
                case 4:{
                    ModificarPlanos(sc);
                    break;
                }
                case 5:{
                    EntrarComoAluno(sc);
                    break;
                }
                case 0: {
                    break;
                }
            }

        }
    }
    public static void ModificarAluno(Scanner sc) {

        int opcao = 1;
        while (opcao != 0) {
            System.out.print("(Alunos) O que quer fzr?\n" +
                    "1 - Listar alunos\n" +
                    "2 - Adicionar aluno\n" +
                    "3 - Editar aluno\n" +
                    "4 - Excluir aluno\n" +
                    "5 - Buscar aluno\n" +
                    "0 - Sair\n\n");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:{
                    ListarAlunos(ListaAlunos);
                    break;
                }
                case 2:{
                    AdicionarAluno(sc, ListaAlunos, MapAlunosPorCpf, MapAlunosPorNome);
                    break;
                }
                case 3:{
                    EditarAluno(sc, MapAlunosPorCpf, MapAlunosPorNome, ListaPlanos, ListaTreinoFixo);
                    break;
                }
                case 4:{
                    ExcluirAluno(sc, ListaAlunos, MapAlunosPorCpf, MapAlunosPorNome);
                    break;
                }
                case 5:{
                    BuscarAluno(sc, MapAlunosPorCpf, MapAlunosPorNome);
                    break;
                }
                case 0: {
                    break;
                }

            }
        }

    }
    public static void ModificarExercicios(Scanner sc) {

        int opcao = 1;

        while (opcao != 0) {
            System.out.print("(Exercicios) O que quer fzr?\n" +
                    "1 - Listar exercicios\n" +
                    "2 - Adicionar exercicio\n" +
                    "3 - Excluir exercicio\n" +
                    "4 - Editar exercicio\n" +
                    "0 - Sair\n\n");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    ListarExercicios(ListaExercicios);
                    break;
                }
                case 2: {
                    AdicionarExercicio(sc, ListaExercicios);
                    break;
                }
                case 3: {
                    ExcluirExercicio(sc, ListaExercicios);
                    break;
                }
                case 4: {
                    EditarExercicio(sc, ListaExercicios);
                    break;
                }
                case 0: {
                    break;
                }
            }
        }
    }
    public static void ModificarTreinos(Scanner sc) {

        int opcao = 1;

        while (opcao != 0) {
            System.out.print("(Treinos) O que quer fzr?\n" +
                    "1 - Listar treinos\n" +
                    "2 - Adicionar treino\n" +
                    "3 - Excluir treino\n" +
                    "4 - Editar treino\n" +
                    "0 - Sair\n\n");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    ListarTreinos(ListaTreinoFixo);
                    break;
                }
                case 2: {
                    AdicionarTreino(sc, ListaTreinoFixo, ListaExercicios);
                    break;
                }
                case 3: {
                    ExcluirTreino(sc, ListaTreinoFixo);
                    break;
                }
                case 4:{
                    EditarTreinoFixo(sc, ListaTreinoFixo, ListaExercicios);
                    break;
                }
                case 0: {
                    break;
                }
            }
        }
    }
    public static void ModificarPlanos(Scanner sc) {
        int opcao = 1;
        while (opcao != 0) {
            System.out.print("(Planos) O que quer fzr?\n" +
                    "1 - Listar Planos\n" +
                    "2 - Adicionar plano\n" +
                    "3 - Excluir plano\n" +
                    "0 - Sair\n\n");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    ListarPlanos(ListaPlanos);
                    break;
                }
                case 2: {
                    AdicionarPlano(sc, ListaPlanos);
                    break;
                }
                case 3: {
                    ExcluirPlano(sc, ListaPlanos);
                    break;
                }
                case 0: {
                    break;
                }

            }
        }
    }
    public static void EntrarComoAluno(Scanner sc) {

        String CPF;
        while(true){
            System.out.print("Faca seu login! digite seu cpf: ");
            CPF = sc.next();
            if (CPF.matches("\\d{11}")) {
                CPF = formatarCPF(CPF);
                break;
            } else {
                throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos.");
            }
        }
        System.out.print("Seja bem vindo!!!\n ");
        Alunos alunoAtual = MapAlunosPorCpf.get(CPF);

        int opcao = 1;
        while (opcao != 0) {
            System.out.print("Ola "+ alunoAtual.getNome() + "! O que vose quer fazer?\n" +
                    "1 - Comecar um treino\n" +
                    "2 - Listar treinos disponiveis\n" +
                    "0 - Sair\n\n");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    alunoAtual.EscolherTreinoPraFazer(sc);
                    alunoAtual.ExecutarTreino(sc);
                    break;
                }
                case 2: {
                    alunoAtual.ListarTreinosDisponiveis();
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

    public static void AdicionarBasico() {
        Alunos aluno1 = new Alunos("Julio", "12345678900", LocalDate.parse("2000-05-05"));
        ListaAlunos.add(aluno1);
        MapAlunosPorCpf.put(aluno1.getCPF(), aluno1);
        MapAlunosPorNome.put(aluno1.getNome(), aluno1);

        Planos plano1 = new Planos("Plano1", 101, 100);
        ListaPlanos.add(plano1);

        Exercicios ex1 = new Exercicios(1, "Supino Reto", Arrays.asList("Peito", "Tríceps", "Ombros"));
        Exercicios ex2 = new Exercicios(2, "Agachamento Livre", Arrays.asList("Quadríceps", "Glúteos", "Posterior de Coxa"));
        Exercicios ex3 = new Exercicios(3, "Puxada na Barra", Arrays.asList("Costas", "Bíceps", "Antebraço"));
        ListaExercicios.add(ex1);
        ListaExercicios.add(ex2);
        ListaExercicios.add(ex3);

        List<Exercicios> listaEx = new ArrayList<>();
        listaEx.add(ex1);
        listaEx.add(ex2);
        List<Integer> cargas = List.of(60, 80);
        TreinosFixo treino1 = new TreinosFixo(listaEx, cargas);
        ListaTreinoFixo.add(treino1);

        aluno1.treinosDisponiveis.add(treino1);

    }



}
