import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnimaisVistos {
    public static void main(String[] args) {
        // Criando o HashMap para armazenar os animais e a contagem
        HashMap<String, Integer> animais = new HashMap<>();

        // Dados fictícios da expedição exemplo
        animais.put("Onça", 3);
        animais.put("Tamanduá", 5);
        animais.put("Capivara", 8);
        animais.put("Arara", 12);
        animais.put("Jaguatirica", 2);

        // Leitura do nome do animal a ser consultado
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do animal que deseja verificar: ");
        String animalBuscado = scanner.nextLine();

        // Verificação e exibição do resultado
        if (animais.containsKey(animalBuscado)) {
            int quantidade = animais.get(animalBuscado);
            System.out.printf("%s foi visto %d vez(es) na expedição.%n", animalBuscado, quantidade);
        } else {
            System.out.printf("%s não foi registrado na expedição.%n", animalBuscado);
        }

        scanner.close();
    }
}
