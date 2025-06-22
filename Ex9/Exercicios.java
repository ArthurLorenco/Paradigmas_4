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

    public static void ListarExercicios(ArrayList<Exercicios> exercicios) {
        for (Exercicios exercicio : exercicios) {
            System.out.println(exercicio);
        }
        System.out.println();
    }
    public static void AdicionarExercicio(Scanner sc, ArrayList<Exercicios> ListaExercicios) {

        Exercicios exercicio = new Exercicios();

        System.out.print("fala o número do exercício: ");
        int numero = sc.nextInt();
        sc.nextLine();

        System.out.print("diz o nome do exercício: ");
        String nome = sc.nextLine();

        System.out.print("quais os músculos ativados (separados por vírgula): ");
        String musculosInput = sc.nextLine();
        List<String> musculos = new ArrayList<>();
        for (String m : musculosInput.split(",")) {
            musculos.add(m.trim());
        }

        exercicio.setNumero(numero);
        exercicio.setNome(nome);
        exercicio.setMusculosAtivados(musculos);

        ListaExercicios.add(exercicio);

        System.out.println("Pronto :O\n");

    }

    // Representação em string
    @Override
    public String toString() {
        return String.format("%03d   %s - %s", numero, nome, String.join(", ", musculosAtivados));
    }

}
