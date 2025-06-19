import java.util.Map;
import java.util.TreeMap;

public class ArvoresAltura {
    public static void main(String[] args) {
        // TreeMap ordena automaticamente as chaves em ordem alfabética
        TreeMap<String, Double> arvores = new TreeMap<>();

        // Adicionando algumas espécies de árvores e suas alturas médias (em metros)
        arvores.put("Ipê-Amarelo", 7.0);
        arvores.put("Araucária", 25.0);
        arvores.put("Mangueira", 15.0);
        arvores.put("Jacarandá", 12.5);
        arvores.put("Baobá", 18.0);

        // Impressão ordenada (TreeMap já garante a ordenação natural das chaves)
        System.out.println("Espécies de Árvores e suas Alturas Médias:");
        for (Map.Entry<String, Double> entry : arvores.entrySet()) {
            System.out.printf("%s: %.2f metros%n", entry.getKey(), entry.getValue());
        }
    }
}
