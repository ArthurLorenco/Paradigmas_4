package Ex9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exercicios {

    private int numero;
    private String nome;
    private List<String> musculosAtivados;

    public Exercicios(int numero, String nome, List<String> musculosAtivados) {
        this.numero = numero;
        this.nome = nome;
        this.musculosAtivados = musculosAtivados;
    }
    public Exercicios() {
    }


    public int getNumero() {
        return numero;
    }
    public String getNome() {
        return nome;
    }
    public List<String> getMusculosAtivados() {
        return musculosAtivados;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setMusculosAtivados(List<String> musculosAtivados) {
        this.musculosAtivados = musculosAtivados;
    }

    public static Exercicios EscolherExercicios(Scanner sc, ArrayList<Exercicios> ListaExercicios) {
        if(ListaExercicios.isEmpty()) {
            System.out.println("nao tem exercicios");
            return null;
        }

        System.out.println("Qual dos exercicios a seguir tu quer? (0 pra nenhum)" );
        for(int i=0; i<ListaExercicios.size(); i++){
            System.out.println("Exercicio " + (i+1) + ":\n" + ListaExercicios.get(i).toString());
        }

        while(true) {
            int opcao = sc.nextInt();
            if (opcao > 0 && opcao <= ListaExercicios.size()) {
                return ListaExercicios.get(opcao-1);
            } else if (opcao == 0){
                return null;
            } else{
                System.out.println("opcao invalida, tente novamente");
            }
        }
    }

    public static void ListarExercicios(ArrayList<Exercicios> exercicios) {
        for (Exercicios exercicio : exercicios) {
            System.out.println(exercicio);
        }
        System.out.println();
    }
    public static void AdicionarExercicio(Scanner sc, ArrayList<Exercicios> ListaExercicios) {

        Exercicios exercicio = new Exercicios();

        System.out.print("fala o número do exercício: ");
        exercicio.setNumero(sc.nextInt());
        sc.nextLine();

        System.out.print("diz o nome do exercício: ");
        exercicio.setNome(sc.nextLine());

        System.out.print("quais os músculos ativados (separados por vírgula): ");
        String musculosInput = sc.nextLine();
        List<String> musculos = new ArrayList<>();
        for (String m : musculosInput.split(",")) {
            musculos.add(m.trim());
        }
        exercicio.setMusculosAtivados(musculos);

        ListaExercicios.add(exercicio);

        System.out.println("Pronto :O\n");

    }
    public static void ExcluirExercicio(Scanner sc, ArrayList<Exercicios> ListaExercicios) {
        Exercicios ex = EscolherExercicios(sc, ListaExercicios);
        if(ex != null) {
            ListaExercicios.remove(ex);
            System.out.println("Feito :D\n");
        }
    }
    public static void EditarExercicio(Scanner sc, ArrayList<Exercicios> ListaExercicios) {

        Exercicios ex = EscolherExercicios(sc, ListaExercicios);
        if(ex == null) {return;}

        System.out.print("fala o novo número do exercício: ");
        ex.setNumero(sc.nextInt());
        sc.nextLine();

        System.out.print("diz o novo nome do exercício: ");
        ex.setNome(sc.nextLine());

        System.out.print("quais os músculos ativados (separados por vírgula): ");
        String musculosInput = sc.nextLine();
        List<String> musculos = new ArrayList<>();
        for (String m : musculosInput.split(",")) {
            musculos.add(m.trim());
        }
        ex.setMusculosAtivados(musculos);
    }

    @Override
    public String toString() {
        return String.format("%03d   %s - %s", numero, nome, String.join(", ", musculosAtivados));
    }

}
