package Ex1;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex1 {
    public static void main(String[] args) {
        var l = new ArrayList<String>();
        l.add("Curitiba");
        l.add("Santa Maria");
        l.add("Florianópolis");
        l.add("Manaus");
        l.add("São Paulo");
        l.add("Brasília");

        Iterator<String> iterator = l.iterator();
        while (iterator.hasNext()) {
            String cidade = iterator.next();
            int num_de_caracteres = cidade.length();

            if (num_de_caracteres % 2 == 0) {
                System.out.println(cidade + " - Número de caracteres par: " + num_de_caracteres);
                System.out.println("O dado não será removido.\n");
            } else {
                System.out.println(cidade + " - Número de caracteres ímpar: " + num_de_caracteres);
                System.out.println("Removendo dado da lista...\n");
                iterator.remove();
            }
        }

        System.out.println("Resultado final: ");
        for (String cidade : l) {
            System.out.println(cidade);
        }
    }
}
