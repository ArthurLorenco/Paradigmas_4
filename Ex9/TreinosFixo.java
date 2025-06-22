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

    public static void ListarTreinos(ArrayList<TreinosFixo> treinos) {
        int i = 1;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exercicios do treino:\n");

        for (int i = 0; i < exerciciosLista.size(); i++)
            sb.append("Carga " + exerciciosCargas.get(i) + " - " + exerciciosLista.get(i) + "\n");

        return sb.toString();
    }

}
