package Ex9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TreinosFixo {

    ArrayList<Exercicios> exerciciosLista = new ArrayList<Exercicios>();
    ArrayList<Integer> exerciciosCargas = new ArrayList<Integer>();

    ArrayList<LocalDate> dataDoTreino = new ArrayList<LocalDate>();

    public TreinosFixo() {}

    public void addicionarExercicio(Exercicios ex, int carga) {
        exerciciosLista.add(ex);
        exerciciosCargas.add(carga);
    }

    public TreinoFazivel iniciarTreino(LocalDate data){
        TreinoFazivel treinoFazivel = new TreinoFazivel();
        treinoFazivel.setDataDoTreino(data);

        System.out.println(treinoFazivel);

        return treinoFazivel;
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
