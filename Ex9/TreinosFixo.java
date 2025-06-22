package Ex9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreinosFixo {

    ArrayList<Exercicios> exerciciosLista = new ArrayList<Exercicios>();
    ArrayList<Integer> exerciciosCargas = new ArrayList<Integer>();

    public TreinosFixo() {}
    public TreinosFixo(List<Exercicios> exercicios, List<Integer> cargas) {
        if (exercicios.size() != cargas.size()) {
            throw new IllegalArgumentException("O número de exercícios deve ser igual ao número de cargas.");
        }

        this.exerciciosLista = new ArrayList<>(exercicios);
        this.exerciciosCargas = new ArrayList<>(cargas);
    }


    public void addicionarExercicio(Exercicios ex, int carga) {
        exerciciosLista.add(ex);
        exerciciosCargas.add(carga);
    }

    public void alterarCarga(int i, int novaCarga) {
        exerciciosCargas.set(i,novaCarga);
    }

    public static TreinosFixo EscolherTreino(Scanner sc, ArrayList<TreinosFixo> ListaTreinosFixo) {
        if(ListaTreinosFixo.isEmpty()) {
            System.out.println("nao tem treinos");
            return null;
        }

        System.out.println("Qual dos treinos a seguir tu quer? (0 pra nenhum)" );
        for(int i=0; i<ListaTreinosFixo.size(); i++){
            System.out.println("Exercicio " + (i+1) + ":\n" + ListaTreinosFixo.get(i).toString());
        }

        while(true) {
            int opcao = sc.nextInt();
            if (opcao > 0 && opcao <= ListaTreinosFixo.size()) {
                return ListaTreinosFixo.get(opcao-1);
            } else if (opcao == 0){
                return null;
            } else{
                System.out.println("opcao invalida, tente novamente");
            }
        }
    }

    public static void ListarTreinos(ArrayList<TreinosFixo> treinos) {
        int i = 1;

        if(treinos.isEmpty()) {
            System.out.println("nao tem treinos");
        }

        for (TreinosFixo treino : treinos) {
            System.out.println("Treino " + i + ": " + treino);
            i++;
        }
        System.out.println();
    }
    public static void AdicionarTreino(Scanner sc, ArrayList<TreinosFixo> ListaTreinosFixo, ArrayList<Exercicios> ListaExercicios) {

        ArrayList<Exercicios> exerciciosProTreino = new ArrayList<Exercicios>();
        ArrayList<Integer> cargas = new ArrayList<Integer>();

        System.out.println("Assim, escolhe um exercicio, e logo depois escolhe uma carga pra ele, ok?\n");

        while (true) {
            Exercicios ex = Exercicios.EscolherExercicios(sc, ListaExercicios);
            if (ex == null) {
                break;
            }
            exerciciosProTreino.add(ex);

            System.out.println("Qual vai ser a carga pro exercicio?");
            cargas.add(sc.nextInt());
        }

        ListaTreinosFixo.add(new TreinosFixo(exerciciosProTreino, cargas));

    }
    public static void ExcluirTreino(Scanner sc, ArrayList<TreinosFixo> ListaTreinosFixo) {
        TreinosFixo treino = EscolherTreino(sc, ListaTreinosFixo);
            if(treino != null) {
            ListaTreinosFixo.remove(treino);
            System.out.println("Feito :D\n");
    }
}
    public static void EditarTreinoFixo(Scanner sc, ArrayList<TreinosFixo> ListaTreinosFixo, ArrayList<Exercicios> ListaExercicios){

        TreinosFixo treino = EscolherTreino(sc, ListaTreinosFixo);
        if(treino == null) return;

        treino.exerciciosCargas.clear();
        treino.exerciciosLista.clear();

        System.out.println("Assim, escolhe um exercicio, e logo depois escolhe uma carga pra ele, ok?\n");

        while (true) {
            Exercicios ex = Exercicios.EscolherExercicios(sc, ListaExercicios);
            if (ex == null) {
                break;
            }
            treino.exerciciosLista.add(ex);

            System.out.println("Qual vai ser a carga pro exercicio?");
            treino.exerciciosCargas.add(sc.nextInt());
        }

    }


@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exercicios do treino:\n");

        for (int i = 0; i < exerciciosLista.size(); i++)
            sb.append("Carga " + exerciciosCargas.get(i) + " - " + exerciciosLista.get(i) + "\n");

        return sb.toString();
    }

}
