package Ex9;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TreinoFazivel extends TreinosFixo{

    LocalDate dataDoTreino;
    ArrayList<Boolean> exerciciosFeitos = new ArrayList<Boolean>(exerciciosLista.size());

    public TreinoFazivel(){}

    public boolean treinoCompleto() {
        return exerciciosFeitos.stream().allMatch(b -> b);
    }

    public void InicializarListaBoolean(){
        for (int i = 0; i < exerciciosLista.size(); i++){
            exerciciosFeitos.add(false);
        }
    }
    public void marcarComoFeito(Scanner sc){
        int opc = 1;

        if(treinoCompleto()){
            System.out.println("Todos os exercicios já foram feitors, pode concluir o treino");
            return;
        }

        while (opc != 0){
            System.out.println("Qual exercicio quer marcar como feito? (0 pra sair)");
            ListarExerciciosAindaNaoFeitos();
            opc = sc.nextInt();
            sc.nextLine();

            if (opc > 0 && opc <= exerciciosLista.size()) {
                if(exerciciosFeitos.get(opc-1)){
                    System.out.println("Exercicio ja foi feito, escolha outro");
                } else{
                    exerciciosFeitos.set(opc-1, true);
                    return;
                }
            } else if (opc == 0){
                break;
            } else{
                System.out.println("opcao invalida, tente novamente");
            }

        }

    }

    public void ListarExerciciosAindaNaoFeitos() {
        if(exerciciosLista.isEmpty()){
            System.out.println("Nao existem exercicios no treino, vix");
            return;
        }
        for (int i = 0; i < exerciciosLista.size(); i++) {
            if (!exerciciosFeitos.get(i)) {
                System.out.println("Exercicio " + (i + 1) + ":\n" + exerciciosLista.get(i).toString() + "\n");
            }
        }
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
