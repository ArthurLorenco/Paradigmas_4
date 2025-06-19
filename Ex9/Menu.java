package Ex9;

import java.util.*;

import static Ex9.Alunos.*;

public class Menu {

    public static ArrayList<Alunos> ListaAlunos = new ArrayList<>();
    public static Map<String, Alunos> MapAlunosPorCpf = new HashMap<>();
    public static Map<String, List<Alunos>> MapAlunosPorNome = new HashMap<>();

    public static ArrayList<Exercicios> ListaExercicios = new ArrayList<>();
    public static ArrayList<Planos> ListaPlanos = new ArrayList<>();
    public static ArrayList<TreinosFixo> ListaTreinoFixo = new ArrayList<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.printf("O que quer fzr?\n" +
                    "1 - Modificar alunos\n" +
                    "2 - Modificar exercicios\n" +
                    "3 - Modificar Treinos\n" +
                    "4 - Modificar Planos\n" +
                    "0 - Sair\n\n");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1: {
                    ModificarAluno(sc);
                    break;
                }
                case 2:{

                }
                case 3:{

                }
                case 4:{

                }
                case 0: {

                    break;
                }
            }

        }
    }
    public static void ModificarAluno(Scanner sc) {

        while (true) {
            System.out.printf("(Alunos) O que quer fzr?\n" +
                    "1 - Listar alunos\n" +
                    "2 - Adicionar aluno\n" +
                    "3 - Editar aluno\n" +
                    "4 - Excluir aluno\n" +
                    "5 - Buscar aluno\n" +
                    "0 - Sair\n\n");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:{
                    ListarAlunos(ListaAlunos);
                    break;
                }
                case 2:{
                    AdicionarAluno(sc, ListaAlunos, MapAlunosPorCpf, MapAlunosPorNome);
                    break;
                }

            }
        }

    }



}
