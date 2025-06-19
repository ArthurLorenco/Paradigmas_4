package Ex5;
import java.util.Map;
import java.util.TreeMap;

public class Ex5 {
    public static void main(String[] args) {
        // ordena automaticamente as chaves em ordem alfabética
        TreeMap<String, Double> arvores = new TreeMap<>();

        // exemplo de espécies de árvores e suas alturas
        arvores.put("Ipê-Amarelo", 7.0);
        arvores.put("Araucária", 25.0);
        arvores.put("Mangueira", 15.0);
        arvores.put("Cerejeira-silvestre", 20.0);
        arvores.put("Bananeira", 4.5);

        // impressão ordenada padrão
        System.out.println("Espécies de árvores e suas alturas médias:");
        for (Map.Entry<String, Double> entry : arvores.entrySet()) {
            System.out.printf("%s: %.2f metros%n", entry.getKey(), entry.getValue());
        }
    }
}
