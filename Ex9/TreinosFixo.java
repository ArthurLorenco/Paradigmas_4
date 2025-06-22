package Ex9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exercicios do treino:\n");

        for (int i = 0; i < exerciciosLista.size(); i++)
            sb.append(exerciciosLista.get(i) + "\n");

        return sb.toString();
    }

}
