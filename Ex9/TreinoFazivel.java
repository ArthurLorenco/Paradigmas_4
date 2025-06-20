package Ex9;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

public class TreinoFazivel extends TreinosFixo{

    LocalDate dataDoTreino;
    ArrayList<Boolean> exerciciosFeitos;

    public TreinoFazivel(){

    }

    public void marcarComoFeito(int i){
        exerciciosFeitos.set(i, true);
    }

    public void setDataDoTreino(LocalDate data){
        dataDoTreino = data;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exercicios do treino:\n");

        for (int i = 0; i < exerciciosLista.size(); i++)
            sb.append(exerciciosLista.get(i) +
                    " Feito: " + exerciciosFeitos.get(i) + "\n");

        return sb.toString();
    }


}
