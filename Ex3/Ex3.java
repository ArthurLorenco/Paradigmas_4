package Ex3;

import java.util.TreeSet;
import java.util.NavigableSet;

public class Ex3 {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>();

        numeros.add(20);
        numeros.add(10);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        int valor = 30;

        System.out.println("Elementos: " + numeros);
        System.out.println("Vizinho inferior do " + valor + ": " + numeros.lower(valor));
        System.out.println("Vizinho superior do " + valor + ": " + numeros.higher(valor));

        NavigableSet<Integer> decrescente = numeros.descendingSet();
        System.out.println("Elementos em ordem decrescente: " + decrescente);
    }
}